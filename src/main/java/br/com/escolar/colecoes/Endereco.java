package br.com.escolar.colecoes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Endereco")
public class Endereco {

    @Id
    private String id;

    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Construtores, getters e setters
}

