package br.com.escolar.colecoes;

import br.com.escolar.enums.FormaPagamento;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Pagamento")
public class Pagamento {

    @Id
    private String id;

    private FormaPagamento formaPagamento;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Construtores, getters e setters
}
