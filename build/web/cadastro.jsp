<%-- 
    Document   : cadastro.jsp
    Created on : May 22, 2025, 4:30:02 PM
    Author     : luanp
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Usuário</title>
    <link rel="stylesheet" href="estilo/cadastroStyle.css">

</head>
<body>

    <div class="container">
        <h2>Cadastro de Usuário</h2>

        <form action="UsuarioController" method="post">
            <input type="hidden" name="op" value="CADASTRAR">

            <label for="nome">Nome</label>
            <input type="text" name="nome" required>

            <label for="email">Email</label>
            <input type="email" name="email" required>

            <label for="senha">Senha</label>
            <input type="password" name="senha" required>

            <button type="submit" class="botao-cadastrar">Cadastrar</button>
            
        </form>

        <% 
            //exibe a mensagem de erro se existir erro
            if (request.getAttribute("erro") != null) { %>
            <p class="mensagem"><%= request.getAttribute("erro") %></p>
        <% } %>

        <a href="login.jsp" class="link-voltar">Já tem conta? Fazer login</a>
    </div>

</body>
</html>
