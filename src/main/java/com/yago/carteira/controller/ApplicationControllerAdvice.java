package com.yago.carteira.controller;

import com.yago.carteira.exception.SaldoException;
import com.yago.carteira.exception.TipoUsuarioException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(TipoUsuarioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleTipoUsuarioException(TipoUsuarioException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(SaldoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleSaldoException(SaldoException ex) {
        return ex.getMessage();
    }
}
