<%-- 
    Document   : ListagemLivrosDisponiveis.jsp
    Created on : 2 de abr. de 2025, 20:07:31
    Author     : Vhugo
--%>


<%@page import="model.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="model.Livros"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%
        String lista = request.getParameter("listagem");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listar.css"/>
    </head>

    <body>
        <table >
            <thead>
                <tr >
                    <th>Nome</th>
                    <th>Autor</th>
                    <th>Editora</th>
                    <th>Edicao</th>
                    <th>Emprestar</th>
                    <th><a href="index.html" class="voltar-link">Voltar</a><th>
                    </th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Livros> livros = (List<Livros>) request.getAttribute("livros");
                    List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
                    for (Livros livro : livros) {

                %>
                <tr>
                    <td><%= livro.getNome()%></td>
                    <td><%= livro.getAutor()%></td>
                    <td><%= livro.getEditora()%></td>
                    <td><%= livro.getEdicao()%></td>
                    <td>
                        <form action="<%=request.getContextPath()%>/livros" method="post">
                            <input type="hidden" name="livroId" value="<%= livro.getId()%>"> 
                            <select name="clienteId" required class="select-cliente">
                                <option value="" >Selecione um cliente</option>
                                <%
                                    for (Cliente cliente : clientes) {
                                %>
                                <option value="<%= cliente.getId()%>"><%= cliente.getNome()%> (ID: <%= cliente.getId()%>)</option>
                                <%
                                    }
                                %>
                            </select>
                            <button type="submit">Emprestar</button>
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
