package br.com.escolar.colecoes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "alunos")
public class Aluno {

    @Id
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco.")
    @NotNull(message = "O nome não pode ser nulo.")
    private String nome;

    @NotBlank(message = "A data de nascimento não pode estar em branco.")
    @NotNull(message = "A data de nascimento não pode ser nula.")
    private LocalDate dataNascimento;

    @NotBlank(message = "O gênero não pode estar em branco.")
    @NotNull(message = "O gênero não pode ser nulo.")
    private String genero;

    @DBRef
    private Endereco endereco;
    @DBRef
    private List<Telefone> telefones;

    private String email;

    private String cpf;

    // Construtor com parâmetros
    public Aluno(Long id, String nome, LocalDate dataNascimento, String genero, Endereco endereco, List<Telefone> telefones, String email, String cpf) {
        this.telefones = telefones;
        this.endereco = endereco;
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.email = email;
        this.cpf = cpf;
    }

    public Aluno() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Construtores, getters e setters
}