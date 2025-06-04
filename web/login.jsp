<%-- 
    Document   : login
    Created on : May 22, 2025, 4:30:56 PM
    Author     : luanp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Sistema de Funcionários</title>
    <link rel="stylesheet" href="estilo/loginStyle.css">

</head>
<body>

    <div class="container">
        <h2>Login</h2>

        <form action="UsuarioController" method="post">
            <input type="hidden" name="op" value="LOGIN">

            <label for="email">Email</label>
            <input type="email" name="email" required>

            <label for="senha">Senha</label>
            <input type="password" name="senha" required>

            <button type="submit" class="botao-login">Entrar</button>
        </form>

        <% if (request.getParameter("msg") != null && request.getParameter("msg").equals("sucesso")) { %>
            <p class="mensagem" style="color: green;">Usuário cadastrado com sucesso!</p>
        <% } %>

        <% if (request.getAttribute("erroLogin") != null) { %>
            <p class="mensagem"><%= request.getAttribute("erroLogin") %></p>
        <% } %>

        <a href="cadastro.jsp" class="link-cadastro">Não tem conta? Cadastre-se</a>
    </div>

</body>
</html>
