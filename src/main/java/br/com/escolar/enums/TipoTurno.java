package br.com.escolar.enums;

public enum TipoTurno {
    MANHA(1),
    TARDE(2),
    NOITE(3);

    private final int valor;

    TipoTurno(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
