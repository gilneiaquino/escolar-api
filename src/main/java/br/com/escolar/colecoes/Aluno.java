package br.com.escolar.colecoes;
import org.springframework.data.annotation.Id;
        import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Aluno")
public class Aluno {

    @Id
    private String id;

    private String nome;
    private int idade;

    // Construtores, getters e setters
}
