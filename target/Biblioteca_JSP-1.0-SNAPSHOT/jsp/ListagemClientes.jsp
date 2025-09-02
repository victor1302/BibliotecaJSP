<%-- 
    Document   : Listagem
    Created on : 2 de abr. de 2025, 19:11:51
    Author     : Vhugo
--%>

<%@page import="java.util.List"%>
<%@page import="model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String lista = request.getParameter("listagem");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Clientes</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listar.css"/>
    </head>
    <body>
        <table >
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Idade</th>
                    <th>Endereco</th>
                    <th>Id</th>
                    <th>Atualizacao</th>
                    <th><a href="index.html" class="voltar-link">Voltar</a><th>
                    </th>
                </tr>
            </thead>
            <tbody>
                <%
                List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
                for (Cliente cliente : clientes) {
                %>
                <tr>
                    <td><%= cliente.getNome()%></td>
                    <td><%= cliente.getIdade() %></td>
                    <td><%= cliente.getEndereco() %></td>
                    <td><%= cliente.getId() %></td>
                    <td>
                        <form action="<%=request.getContextPath()%>/registrar" method="post">
                        <input type="hidden" name="acao" value="deletar">
                        <input type="hidden" name="clienteId" value="<%= cliente.getId() %>">
                        <button type="submit">Deletar</button>
                    </td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </body>
    
</html>
