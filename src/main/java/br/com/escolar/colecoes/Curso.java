package br.com.escolar.colecoes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "cursos")
public class Curso {
    @Id
    private String id;
    private String titulo;
    private int progresso;
    private List<String> conquistas;
    private String descricaoResumida;
    private String descricaoCompleta;
    private String cor;
    private String agrupamento;

    public Curso(String id, String titulo, int progresso, List<String> conquistas, String descricaoResumida, String descricaoCompleta, String cor, String agrupamento) {
        this.id = id;
        this.titulo = titulo;
        this.progresso = progresso;
        this.conquistas = conquistas;
        this.descricaoResumida = descricaoResumida;
        this.descricaoCompleta = descricaoCompleta;
        this.cor = cor;
        this.agrupamento = agrupamento;
    }

    public Curso(){
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getProgresso() {
        return progresso;
    }

    public void setProgresso(int progresso) {
        this.progresso = progresso;
    }

    public List<String> getConquistas() {
        return conquistas;
    }

    public void setConquistas(List<String> conquistas) {
        this.conquistas = conquistas;
    }

    public String getDescricaoResumida() {
        return descricaoResumida;
    }

    public void setDescricaoResumida(String descricaoResumida) {
        this.descricaoResumida = descricaoResumida;
    }

    public String getDescricaoCompleta() {
        return descricaoCompleta;
    }

    public void setDescricaoCompleta(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAgrupamento() {
        return agrupamento;
    }

    public void setAgrupamento(String agrupamento) {
        this.agrupamento = agrupamento;
    }
}
