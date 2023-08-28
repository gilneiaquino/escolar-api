package br.com.escolar.colecoes;

import br.com.escolar.enums.TipoPagamento;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "formasPagamento")
public class FormaPagamento {

    @Id
    private Long id;
    private TipoPagamento tipoPagamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
