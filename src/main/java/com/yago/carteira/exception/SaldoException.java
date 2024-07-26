package com.yago.carteira.exception;

public class SaldoException extends RuntimeException {

    public SaldoException() {
        super("Saldo insuficiente");
    }
}
