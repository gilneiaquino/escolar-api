package br.com.escolar.dtos;

import jakarta.validation.constraints.NotEmpty;

public class UsuarioDto {
    private String nome;

    @NotEmpty
    private String senha;
    private String email;
    private String cpf;

    public UsuarioDto(String nomeUsuario, String senha) {
        this.nome = nomeUsuario;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
