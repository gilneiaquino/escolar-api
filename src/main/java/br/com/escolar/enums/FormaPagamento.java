package br.com.escolar.enums;

public enum FormaPagamento {
    CARTAO_CREDITO(1),
    DINHEIRO(2),
    BOLETO(3);

    private final int valor;

    FormaPagamento(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static FormaPagamento fromValor(int valor) {
        for (FormaPagamento forma : FormaPagamento.values()) {
            if (forma.getValor() == valor) {
                return forma;
            }
        }
        throw new IllegalArgumentException("Valor inválido para FormaPagamento: " + valor);
    }
}
