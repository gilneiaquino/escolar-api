package br.com.escolar.colecoes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "disciplinas")
public class Disciplina {

    @Id
    private String id;
    private String nome;
    private String descricao;
    private Professor professorResponsavel;
    private List<Curso> cursosAssociados;
    // Outros atributos
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(Professor professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public List<Curso> getCursosAssociados() {
        return cursosAssociados;
    }

    public void setCursosAssociados(List<Curso> cursosAssociados) {
        this.cursosAssociados = cursosAssociados;
    }
}

