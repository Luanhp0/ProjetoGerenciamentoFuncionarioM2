<%@page import="java.util.List"%>
<%@page import="model.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista de Funcionários</title>
        <link rel="stylesheet" href="estilo/listarFuncionarioStyle.css">

    </head>
    <body>

        <div class="container">
            <h2>Lista de Funcionários</h2>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Email</th>
                        <th>Telefone</th>
                        <th>Endereço</th>
                        <th>Cargo</th>
                        <th>Departamento</th>
                        <th>Salário</th>
                        <th>Admissão</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        // ele pega a lista de funcionarios do controller, percorrendo em um loop para exibir os dados da tabela
                        //se estiver fazia ou nula mostra a mensagem de erro ("nenhum funcionario encontrado ")
                        List<Funcionario> lista = (List<Funcionario>) request.getAttribute("listaFuncionarios");
                        if (lista != null && !lista.isEmpty()) {
                            for (Funcionario f : lista) {
                            // aqui e se a lista foi enviada e tem funcionarios entao vai mostrar na tabela
                    %>
                    <tr>
                        <td><%= f.getId()%></td>
                        <td><%= f.getNome()%></td>
                        <td><%= f.getCpf()%></td>
                        <td><%= f.getEmail()%></td>
                        <td><%= f.getTelefone()%></td>
                        <td><%= f.getEndereco()%></td>
                        <td><%= f.getCargo()%></td>
                        <td><%= f.getDepartamento()%></td>
                        <td>R$ <%= f.getSalario()%></td>
                        <td><%= f.getDataAdmissao()%></td>
                        <td>
                            <!-- os botoes -->
                            <a href="editarFuncionario.jsp?id=<%= f.getId()%>" class="botao-acao editar">Editar</a>
                            <form action="FuncionarioController" method="post" style="display:inline;">
                                <input type="hidden" name="op" value="DELETAR">
                                <input type="hidden" name="id" value="<%= f.getId()%>">
                                <button type="submit" class="botao-acao excluir" onclick="return confirm('Tem certeza que deseja excluir?')">Excluir</button>
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="8">Nenhum funcionário encontrado.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>

            <a href="index.html" class="botao-voltar">Voltar ao Início</a>
        </div>

    </body>
</html>
