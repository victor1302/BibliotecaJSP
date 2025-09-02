<%-- 
    Document   : ListagemLivrosDisponiveis.jsp
    Created on : 2 de abr. de 2025, 20:07:31
    Author     : Vhugo
--%>


<%@page import="model.Cliente"%>
<%@page import="model.Emprestimo"%>
<%@page import="java.util.List"%>
<%@page import="model.Livros"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
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
                    <th>Usuario</th>
                    <th><a href="index.html" class="voltar-link">Voltar</a><th>
                    </th>
                </tr>
            </thead>
            <tbody>
                <%
    List<Emprestimo> emprestimos = (List<Emprestimo>) request.getAttribute("emprestimos");
    for (Emprestimo emprestimo : emprestimos) {
        Livros livro = emprestimo.getLivro();
        Cliente cliente = emprestimo.getCliente();
%>
<tr>
    <td><%= livro.getNome() %></td>
    <td><%= livro.getAutor() %></td>
    <td><%= livro.getEditora() %></td>
    <td><%= livro.getEdicao() %></td>
    <td>
       <%= cliente.getNome() %>
    </td>
    <td>
        <form action="<%=request.getContextPath()%>/livros" method="post">
        <input type="hidden" name="acao" value="deletarEmprestimo">
        <input type="hidden" name="emprestimoId" value="<%= emprestimo.getId() %>">
        <button type="submit">Devolver</button>
</form>
    </td>
</tr>
<%
    }
%>

            </tbody>
        </table>
    </body>
