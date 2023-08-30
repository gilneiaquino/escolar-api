package br.com.escolar.colecoes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String dataNascimento;

    @NotBlank(message = "O gênero não pode estar em branco.")
    @NotNull(message = "O gênero não pode ser nulo.")
    private String genero;

    @DBRef
    private Endereco endereco;

    // Construtor com parâmetros
    public Aluno(Long id, String nome, String dataNascimento, String genero, Endereco endereco) {
        this.endereco = endereco;
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
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

// Construtores, getters e setters
}