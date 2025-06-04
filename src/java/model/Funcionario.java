/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author luanp
 */public class Funcionario {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private String cargo;
    private String departamento;
    private double salario;
    private LocalDate dataAdmissao;

    /**
     * Obtém o ID do funcionário.
     * @return ID do funcionário.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do funcionário.
     * @param id ID a ser definido.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do funcionário.
     * @return Nome do funcionário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do funcionário.
     * @param nome Nome a ser definido.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o CPF do funcionário.
     * @return CPF do funcionário.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do funcionário.
     * @param cpf CPF a ser definido.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Obtém o e-mail do funcionário.
     * @return E-mail do funcionário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o e-mail do funcionário.
     * @param email E-mail a ser definido.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o telefone do funcionário.
     * @return Telefone do funcionário.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do funcionário.
     * @param telefone Telefone a ser definido.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém o endereço do funcionário.
     * @return Endereço do funcionário.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço do funcionário.
     * @param endereco Endereço a ser definido.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtém o cargo do funcionário.
     * @return Cargo do funcionário.
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Define o cargo do funcionário.
     * @param cargo Cargo a ser definido.
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Obtém o departamento do funcionário.
     * @return Departamento do funcionário.
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Define o departamento do funcionário.
     * @param departamento Departamento a ser definido.
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtém o salário do funcionário.
     * @return Salário do funcionário.
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Define o salário do funcionário.
     * @param salario Salario a ser definido.
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Obtém a data de admissão do funcionário.
     * @return Data de admissão.
     */
    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    /**
     * Define a data de admissao do funcionario.
     * @param dataAdmissao Data a ser definida.
     */
    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
}