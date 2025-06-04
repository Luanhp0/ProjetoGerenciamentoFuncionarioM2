/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.FuncionarioDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import model.Funcionario;

/**
 *Servlet responsavel por controlar as acoes do crud de funcionarios
 * ele redireciona paginas, executa operacoes como dao e reponde requisicoes post
 * @author luanp
 */

@WebServlet(name = "FuncionarioController", urlPatterns = {"/FuncionarioController"})

public class FuncionarioController extends HttpServlet {

    /**
     * processa requisicoes Post para, cadastrar, atualizar, deletar e consultar funcionarios
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String op = request.getParameter("op");
        FuncionarioDAO fdao = new FuncionarioDAO();
        Funcionario f = new Funcionario();
        String mensagem = "";
        
        /**
         * cadastra um novo funcionario. Recebe dados do formulario e mosta o objeto para enviar para o dao
         */
        if (op.equals("cadastrar")) {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            String cargo = request.getParameter("cargo");
            String departamento = request.getParameter("departamento");
            LocalDate dataAdmissao = null;
            String dataAdmissaoStr = request.getParameter("dataAdmissao");

            if (dataAdmissaoStr != null && !dataAdmissaoStr.isEmpty()) {
                dataAdmissao = LocalDate.parse(dataAdmissaoStr);
            }

            f.setNome(nome);
            f.setEmail(email);
            f.setTelefone(telefone);
            f.setCargo(cargo);
            f.setDepartamento(departamento);
            f.setDataAdmissao(dataAdmissao);

            try {
                FuncionarioDAO dao = new FuncionarioDAO();
                dao.cadastrar(f);
                request.setAttribute("mensagem", "funcionario cadastrado com sucesso!");
            } catch (ClassNotFoundException | SQLException e) {
                request.setAttribute("mensagem", "erro ao salvar funcionario: " + e.getMessage());
            }

            RequestDispatcher rd = request.getRequestDispatcher("salvarFuncionarios.jsp");
            rd.forward(request, response);
            
        } 
        /**
         * Deleta um funcionario com base no Id recebido. Executa a exclusao via dao e define uma mensagem de retorno
         */
        else if (op.equals("DELETAR")) {
            String idStr = request.getParameter("id");

            if (idStr != null && !idStr.isEmpty()) {
                try {
                    int id = Integer.parseInt(idStr);
                    FuncionarioDAO dao = new FuncionarioDAO();
                    dao.deletar(id);
                    mensagem = "funcionario deletado com sucesso!";
                } catch (NumberFormatException e) {
                    mensagem = "Id invalido!";
                } catch (ClassNotFoundException | SQLException e) {
                    mensagem = "erro ao deletar funcionario: " + e.getMessage();
                }
            } else {
                mensagem = "id do funcionário nao informado!";
            }
            response.sendRedirect("FuncionarioController");

        }
        /**
         * Atualiza dados do formulario. Le os campos do formulario, atualiza o objeto e executa o update no banco
         */
        else if ("ATUALIZAR".equals(op)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                String nome = request.getParameter("nome");
                String cpf = request.getParameter("cpf");
                String email = request.getParameter("email");
                String telefone = request.getParameter("telefone");
                String endereco = request.getParameter("endereco");
                String cargo = request.getParameter("cargo");
                String departamento = request.getParameter("departamento");
                double salario = Double.parseDouble(request.getParameter("salario"));
                String dataAdmissaoStr = request.getParameter("dataAdmissao");
                LocalDate dataAdmissao = LocalDate.parse(dataAdmissaoStr);

                Funcionario funcionario = new Funcionario();
                funcionario.setId(id);
                funcionario.setNome(nome);
                funcionario.setCpf(cpf);
                funcionario.setEmail(email);
                funcionario.setTelefone(telefone);
                funcionario.setEndereco(endereco);
                funcionario.setCargo(cargo);
                funcionario.setDepartamento(departamento);
                funcionario.setSalario(salario);
                funcionario.setDataAdmissao(dataAdmissao);

                fdao.atualizar(funcionario);

                response.sendRedirect("FuncionarioController"); // vai redirecionar para a listagem
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("Erro ao atualizar: " + e.getMessage());
            }
        } 
        /**
         * consulta um funcionario por id. Ele busca dados no banco e redireciona para a pagina do resultado
         */
        else if ("CONSULTAR".equals(op)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));

                Funcionario funcionario = fdao.buscarPorId(id);

                if (funcionario != null) {
                    request.setAttribute("funcionario", funcionario);
                    request.getRequestDispatcher("resultadoConsulta.jsp").forward(request, response);
                } else {
                    request.setAttribute("erro", "Funcionário não encontrado!");
                    request.getRequestDispatcher("resultadoConsulta.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("erro", "Erro ao consultar: " + e.getMessage());
                request.getRequestDispatcher("resultadoConsulta.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 
        FuncionarioDAO fdao = new FuncionarioDAO();
        List<Funcionario> funcionarios = fdao.listar();
        request.setAttribute("listaFuncionarios", funcionarios);
        RequestDispatcher rd = request.getRequestDispatcher("listarFuncionarios.jsp");
        rd.forward(request, response);
    }

}
