package br.com.escolar.colecoes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "professores")
public class Professor {

    @Id
    private String id;
    private String nome;
    private String dataNascimento;
    private String genero;

    @DBRef
    private Endereco endereco;
    private List<Telefone> telefones;
    private List<Disciplina> disciplinasLecionadas;
    // Outros atributos

    // Construtores, getters e setters
}
