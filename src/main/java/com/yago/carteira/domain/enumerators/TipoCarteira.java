package com.yago.carteira.domain.enumerators;

public enum TipoCarteira {
    COMUM("Comum"), LOJISTA("Lojista");

    private final String value;

    TipoCarteira(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "TipoCarteira{" +
                "value='" + value + '\'' +
                '}';
    }
}
