/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luanp
 */
public class Conexao {
    /**
     * metodo para Conexao com o banco de dados mysql 
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetom2","root", "1103200");
        return con;
    }
}
