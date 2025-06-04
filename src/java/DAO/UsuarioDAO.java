/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import util.Conexao;
import java.sql.Connection;
import model.Usuario;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author luanp
 */
public class UsuarioDAO {
    
    /**
     * cadastra um novo usuario no banco de dados
     * @param u
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public boolean cadastrar(Usuario u) throws SQLException, ClassNotFoundException {
        String sql = "insert into usuarios (nome, email, senha) values(?, ?, ?)";
        
        try (Connection con = Conexao.getConexao(); 
            PreparedStatement stmt = con.prepareStatement(sql)) { 
            // O preparedStatement nao deixara a condicao admin' OR '1'='1 funcionar como uma brecha
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            return stmt.executeUpdate() > 0;
        }
    }
    
    /**
     * Autentica um usuario com base no email e senha informados
     * @param email
     * @param senha
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Usuario autenticar(String email, String senha) throws SQLException, ClassNotFoundException {
        String sql = "select * from usuarios where email = ? and senha = ?";
        
        try (Connection con = Conexao.getConexao(); 
            PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("nome"), email, senha);
            }
        }
        return null;
    }

}
