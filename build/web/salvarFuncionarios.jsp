<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmação de Cadastro</title>
    <link rel="stylesheet" href="estilo/salvarFuncionariosStyle.css">
</head>
<body>
   <%
       String mensagem = (String) request.getAttribute("mensagem");
       if(mensagem != null){
       %>
       <h3><%= mensagem%></h3>
       <a href="cadFunc.html"> cadastrar outro funcionario</a>
        <%
       }
   %>
</body>
</html>
