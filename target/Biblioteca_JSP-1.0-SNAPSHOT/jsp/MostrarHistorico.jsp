<%@page import="java.util.List"%>
<%@page import="model.Emprestimo"%>
<%@page import="model.Cliente"%>
<%@page import="model.Livros"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Histórico de Empréstimos</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listar.css"/>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Cliente</th>
                <th>Livro</th>
                <th>Data do Empréstimo</th>
                <th>Data da Devolução</th>
                <th><a href="index.html" class="voltar-link">Voltar</a></th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Emprestimo> historico = (List<Emprestimo>) request.getAttribute("historico");
                for (Emprestimo emp : historico) {
                    Cliente cliente = emp.getCliente();
                    Livros livro = emp.getLivro();
            %>
            <tr>
                <td><%= cliente.getNome() %></td>
                <td><%= livro.getNome() %></td>
                <td><%= emp.getDataEmprestimo() %></td>
                <td><%= emp.getDataDevolucao() != null ? emp.getDataDevolucao() : "Ainda não devolvido" %></td>
            </tr>
            <% } %>
        </tbody>
    </table>

    <br>
    
</body>
</html>