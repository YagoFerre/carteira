package com.yago.carteira.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal valor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "carteira_pagador_id")
    private Carteira pagador;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "carteira_beneficiario_id")
    private Carteira beneficiario;

    public Transferencia() {
    }

    public Transferencia(Long id, BigDecimal valor, Carteira pagador, Carteira beneficiario) {
        this.id = id;
        this.valor = valor;
        this.pagador = pagador;
        this.beneficiario = beneficiario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Carteira getPagador() {
        return pagador;
    }

    public void setPagador(Carteira pagador) {
        this.pagador = pagador;
    }

    public Carteira getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Carteira beneficiario) {
        this.beneficiario = beneficiario;
    }
}
