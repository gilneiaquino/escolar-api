package br.com.escolar.colecoes;

import br.com.escolar.enums.TipoNota;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Nota")
public class Nota {

    @Id
    private String id;

    private double valor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private TipoNota tipo;

}
