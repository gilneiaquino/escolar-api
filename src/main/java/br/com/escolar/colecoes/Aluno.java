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
    private List<Mensalidade> mensalidades;
    // Outros atributos

    // Construtores, getters e setters
}