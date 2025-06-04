/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import jakarta.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import util.Conexao;
import java.sql.ResultSet;

/**
 *
 * @author luanp
 */
public class FuncionarioDAO extends HttpServlet {

    /**
     * Cadastra um novo funcionário no banco de dados.
     *
     * Este método insere os dados de um objeto {@link Funcionario} na tabela
     * `funcionario`, utilizando uma conexão com o banco de dados e instrução
     * SQL preparada (PreparedStatement).
     *
     * @param f O objeto {@link Funcionario} contendo os dados a serem
     * inseridos: nome, CPF, email, telefone, endereço, cargo, departamento,
     * salário e data de admissão.
     *
     * @throws ClassNotFoundException se o driver jdbc não for encontrado.
     * @throws SQLException Se ocorrer um erro ao conectar ou executar a
     * operação no banco de dados.
     */
    public void cadastrar(Funcionario f) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        String sql = "insert into funcionario (nome, cpf, email, telefone, endereco, cargo, departamento, salario, dataAdmissao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, f.getNome());
        stmt.setString(2, f.getCpf());
        stmt.setString(3, f.getEmail());
        stmt.setString(4, f.getTelefone());
        stmt.setString(5, f.getEndereco());
        stmt.setString(6, f.getCargo());
        stmt.setString(7, f.getDepartamento());
        stmt.setDouble(8, f.getSalario());
        stmt.setDate(9, java.sql.Date.valueOf(f.getDataAdmissao()));

        stmt.execute();
        con.close();

    }
    /**
     * Deleta um funcionario com base no id informado no input
     * @param Id
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void deletar(int Id) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        String sql = "delete from funcionario where id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, Id);
        stmt.execute();
        con.close();
    }
    /**
     * Atualiza os dados de um funcionario existente
     * @param f
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void atualizar(Funcionario f) throws ClassNotFoundException, SQLException {
        String sql = "update funcionario set nome = ?, cpf = ?, email = ?, telefone = ?, endereco = ?, cargo = ?, departamento = ?, salario = ?, dataAdmissao = ? WHERE id = ?";

        Connection con = Conexao.getConexao();
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, f.getNome());
        stmt.setString(2, f.getCpf());
        stmt.setString(3, f.getEmail());
        stmt.setString(4, f.getTelefone());
        stmt.setString(5, f.getEndereco());
        stmt.setString(6, f.getCargo());
        stmt.setString(7, f.getDepartamento());
        stmt.setDouble(8, f.getSalario());
        stmt.setDate(9, java.sql.Date.valueOf(f.getDataAdmissao()));
        stmt.setInt(10, f.getId());

        stmt.execute();
        con.close();
    }
    
    /**
     * Lista todos os funcionarios cadastrados no banco
     * @return a lista de objetos do funcionario
     */
    public List<Funcionario> listar() {
        List<Funcionario> lista = new ArrayList<>();

        String sql = "select * from funcionario";

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
                f.setEndereco(rs.getString("endereco"));
                f.setCargo(rs.getString("cargo"));
                f.setDepartamento(rs.getString("departamento"));
                f.setSalario(rs.getDouble("salario"));
                f.setDataAdmissao(rs.getDate("dataAdmissao").toLocalDate());

                lista.add(f);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    /**
     * busca um funcionario com base no id
     * @param id
     * @return objeto funcionario se encontrado  
     */
    public Funcionario buscarPorId(int id) {
        Funcionario f = null;
        String sql = "select * from funcionario WHERE id = ?";

        try (
                Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    f = new Funcionario();
                    f.setId(rs.getInt("id"));
                    f.setNome(rs.getString("nome"));
                    f.setCpf(rs.getString("cpf"));
                    f.setEmail(rs.getString("email"));
                    f.setTelefone(rs.getString("telefone"));
                    f.setEndereco(rs.getString("endereco"));
                    f.setCargo(rs.getString("cargo"));
                    f.setDepartamento(rs.getString("departamento"));
                    f.setSalario(rs.getDouble("salario"));
                    f.setDataAdmissao(rs.getDate("dataAdmissao").toLocalDate());
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

}
