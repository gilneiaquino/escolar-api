package br.com.escolar.colecoes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Telefone")
public class Telefone {

    @Id
    private Long id;

    private  Integer ddd;
    private Integer numero;
    private String tipo;

    public Telefone(Long id, Integer ddd, Integer numero, String tipo) {
        this.id = id;
        this.ddd = ddd;
        this.numero = numero;
        this.tipo = tipo;
    }

    public Telefone() {
       super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
