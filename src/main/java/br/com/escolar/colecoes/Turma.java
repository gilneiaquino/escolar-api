package br.com.escolar.colecoes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "turmas")
public class Turma {

    @Id
    private String id;
    private String nome;
    private int anoLetivo;
    private Professor professorResponsavel;
    private List<Aluno> alunosMatriculados;
    private String horarioAulas;
    // Outros atributos

    // Construtores, getters e setters
}
