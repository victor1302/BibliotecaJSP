<%-- 
    Document   : Login
    Created on : 25 de mar. de 2025, 20:39:28
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
        <title>Registrar Cliente</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/registrarLivros.css"/>
    </head>
    <div>
        <body>
  <form class="formulario" action="<%=request.getContextPath()%>/registrar" method="post">
    <input type="hidden" name="acao" value="<%=acao%>">   
    <table>
      <tr>
        <td class="label">Nome</td>
        <td><input type="text" name="nome" value=""></td>
      </tr>
      <tr>
        <td class="label">Idade</td>
        <td><input type="number" name="idade" value=""></td>
      </tr>
      <tr>
        <td class="label">Endereço</td>
        <td><input type="text" name="endereco" value=""></td>
      </tr>
      <tr>
        <td class="label">Senha</td>
        <td><input type="password" name="senha" value=""></td>
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
    </div>
</html>
