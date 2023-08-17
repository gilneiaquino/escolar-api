package br.com.escolar.colecoes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Mensalidade")
public class Mensalidade {

    @Id
    private String id;

    private double valor;
    private Date dataPagamento;
    private int quantidade;
    private Pagamento pagamento;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Construtores, getters e setters
}
