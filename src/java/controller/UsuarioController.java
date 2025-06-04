/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.UsuarioDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

/**
 * Esse servlet e responsavel pelo controle de cadastro e autenticacao de usuarios
 * ele trata as requisicoes do tipo Post para operacoes como login e cadastro
 * @author luanp
 */

@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})

public class UsuarioController extends HttpServlet {
    
    /**
     * processa requisicoes post para cadastro e login de usuarios
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String op = request.getParameter("op");
        UsuarioDAO dao = new UsuarioDAO();

        if ("CADASTRAR".equals(op)) {
            /**
             * responsavel por cadastrar um novo funcionario
             * ele coleta o nome, email e senha do formulario e salva via dao
             */
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            Usuario user = new Usuario(nome, email, senha);
            try {
                dao.cadastrar(user);
                response.sendRedirect("login.jsp");
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("erro.jsp");
            }

        } else if ("LOGIN".equals(op)) {
            /**
             * Autentica usuario 
             * verifica se o email e senha conferem e redireciona para o index.html ou volta para o login 
             */
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            try {
                Usuario user = dao.autenticar(email, senha);
                if (user != null) {
                    request.getSession().setAttribute("usuarioLogado", user);
                    response.sendRedirect("index.html");
                } else {
                    response.sendRedirect("login.jsp?erro=1");
                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("erro.jsp");
            }
        }
    }
}
