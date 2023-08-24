package br.com.escolar.colecoes;
import br.com.escolar.enums.TipoTurno;
import org.springframework.data.annotation.Id;
        import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "alunos")
public class Aluno {

    @Id
    private String id;
    private String nome;
    private String dataNascimento;
    private String genero;
    private Endereco endereco;
    private List<Telefone> telefones;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    // Construtores, getters e setters
}