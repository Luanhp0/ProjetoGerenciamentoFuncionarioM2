<%-- 
    Document   : resultadoConsulta
    Created on : May 22, 2025, 2:03:02 PM
    Author     : luanp
--%>
<%@ page import="model.Funcionario" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultado da Consulta</title>
    <link rel="stylesheet" href="estilo/resultadoConsultaStyle.css">

</head>
<body>

    <div class="container">
        <h2>Resultado da Consulta</h2>

        <div class="info">
        <%
            Funcionario f = (Funcionario) request.getAttribute("funcionario");
            if (f != null) {
        %>
            <p><strong>ID:</strong> <%= f.getId() %></p>
            <p><strong>Nome:</strong> <%= f.getNome() %></p>
            <p><strong>CPF:</strong> <%= f.getCpf() %></p>
            <p><strong>Email:</strong> <%= f.getEmail() %></p>
            <p><strong>Telefone:</strong> <%= f.getTelefone() %></p>
            <p><strong>Endereço:</strong> <%= f.getEndereco() %></p>
            <p><strong>Cargo:</strong> <%= f.getCargo() %></p>
            <p><strong>Departamento:</strong> <%= f.getDepartamento() %></p>
            <p><strong>Salário:</strong> R$ <%= f.getSalario() %></p>
            <p><strong>Data de Admissão:</strong> <%= f.getDataAdmissao() %></p>
        <%
            } else {
        %>
            <p class="mensagem">Funcionário nao encontrado.</p>
        <%
            }
        %>
        </div>

        <div class="botao-voltar">
            <a href="index.html">Voltar ao Inicio</a>
        </div>
    </div>

</body>
</html>


