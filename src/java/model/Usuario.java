/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author luanp
 */

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;

    /**
     * construtor vazio caso necessario para iniciar objetos vazios 
     */
    public Usuario() {}
    
    
    /**
     * Construtor usado quando todos os dados estao disponiveis para quando for fazer busca por id
     * @param id
     * @param nome
     * @param email
     * @param senha 
     */
    public Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    /**
     * Construtor usado para quando o id que ainda nao foi gerado, para quando cadastrar um novo usuario
     * @param nome
     * @param email
     * @param senha 
     */
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Getters e setters
    
    /**
     * Obtem o id do usuario.
     * @return id do usuario.
     */
    public int getId() {
        return id;
    }
    /**
     * define o id do usuario.
     * @return id do usuario.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Obtem o nome do usuario.
     * @return Nome do usuario.
     */
    public String getNome() {
        return nome;
    }
    /**
     * define o nome do usuario.
     * @return Nome do usuario.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Obtem o email do usuario.
     * @return email do usuario.
     */
    public String getEmail() {
        return email;
    }
    /**
     * define o email do usuario.
     * @return email do usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    /**
     * Obtem a senha do usuario.
     * @return senha do usuario.
     */
    public String getSenha() {
        return senha;
    }
    /**
     * define a senha do usuario.
     * @return senha do usuario.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}

