<%-- 
    Document   : editarFuncionario
    Created on : May 20, 2025, 11:04:05 AM
    Author     : luanp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Funcionario" %>
<%@ page import="DAO.FuncionarioDAO" %>

<%
    // recuperacao de um funcionario pelo id enviado pelo url editarfuncinario.jsp
    int id = 0;
    Funcionario f = null;

    try {
        id = Integer.parseInt(request.getParameter("id")); // id pela url
        FuncionarioDAO fdao = new FuncionarioDAO(); 
        f = fdao.buscarPorId(id); // busca o funcionario
        if (f == null) {
            out.println("<p style='color:red;'>Funcionário não encontrado.</p>");
            return;
        }
    } catch (Exception e) {
        out.println("<p style='color:red;'>Erro ao carregar funcionário: " + e.getMessage() + "</p>");
        return;
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Editar Funcionário</title>
        <link rel="stylesheet" href="estilo/editarFuncionarioStyle.css">

    </head>
    <body>

        <div class="container">
            <h2>Editar Funcionário</h2>

            <form action="FuncionarioController" method="post">
                <input type="hidden" name="op" value="ATUALIZAR">
                <input type="hidden" name="id" value="<%= f.getId()%>">

                <div class="grupo">
                    <label for="nome">Nome completo</label>
                    <input type="text" id="nome" name="nome" value="<%= f.getNome()%>" required />
                </div>

                <div class="grupo">
                    <label for="cpf">CPF</label>
                    <input type="text" id="cpf" name="cpf" value="<%= f.getCpf()%>" required />
                </div>

                <div class="grupo">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" value="<%= f.getEmail()%>" required />
                </div>

                <div class="grupo">
                    <label for="cargo">Cargo</label>
                    <input type="text" id="cargo" name="cargo" value="<%= f.getCargo()%>" required />
                </div>

                <div class="grupo">
                    <label for="departamento">Departamento</label>
                    <input type="text" id="departamento" name="departamento" value="<%= f.getDepartamento()%>" required />
                </div>

                <div class="grupo">
                    <label for="telefone">Telefone</label>
                    <input type="tel" id="telefone" name="telefone" value="<%= f.getTelefone()%>" />
                </div>

                <div class="grupo">
                    <label for="endereco">Endereço</label>
                    <input type="text" id="endereco" name="endereco" value="<%= f.getEndereco()%>" required />
                </div>

                <div class="grupo">
                    <label for="salario">Salário</label>
                    <input type="number" step="0.01" id="salario" name="salario" value="<%= f.getSalario()%>" required />
                </div>

                <div class="grupo">
                    <label for="data">Data de contratação</label>
                    <input type="date" id="data" name="dataAdmissao" value="<%= f.getDataAdmissao()%>" />
                </div>


                <div class="botoes">
                    <a href="FuncionarioController" class="botao botao-voltar">Cancelar</a>
                    <button type="submit" class="botao botao-atualizar">Atualizar</button>
                </div>
            </form>
        </div>

    </body>
</html>
