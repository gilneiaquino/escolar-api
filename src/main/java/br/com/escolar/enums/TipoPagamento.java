package br.com.escolar.enums;

public enum TipoPagamento {
    CARTAOCREDITO(1),
    BOLETO(2),
    DINHEIRO(3);

    private final int valor;

    TipoPagamento(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}