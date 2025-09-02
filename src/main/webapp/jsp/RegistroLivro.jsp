<%-- 
    Document   : RegistroLivro
    Created on : 2 de abr. de 2025, 18:51:49
    Author     : Vhugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String acao = request.getParameter("acao");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Livros</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/registrarLivros.css"/>
    </head>
    <body>
        <form class="formulario" action="<%=request.getContextPath()%>/livros" method="post">
  <input type="hidden" name="acao" value="<%=acao%>">   
  <table>
    <tr>
      <td class="label">Nome</td>
      <td><input type="text" name="nome" value=""></td>
    </tr>
    <tr>
      <td class="label">Edição</td>
      <td><input type="number" name="edicao" value=""></td>
    </tr>
    <tr>
      <td class="label">Autor</td>
      <td><input type="text" name="autor" value=""></td>
    </tr>
    <tr>
      <td class="label">Editora</td>
      <td><input type="text" name="editora" value=""></td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center;">
        <input type="submit" value="Enviar">
        <input type="reset" value="Limpar">
        <a href="../index.html" class="botao-link">Voltar</a>
      </td>
    </tr>
  </table>
</form>
    </body>
</html>
