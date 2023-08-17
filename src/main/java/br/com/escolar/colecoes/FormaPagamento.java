package br.com.escolar.colecoes;

import br.com.escolar.enums.TipoPagamento;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "formasPagamento")
public class FormaPagamento {

    @Id
    private String id;
    private TipoPagamento tipoPagamento;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
