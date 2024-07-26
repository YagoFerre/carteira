package com.yago.carteira.domain;

import com.yago.carteira.domain.enumerators.TipoCarteira;
import com.yago.carteira.domain.enumerators.converters.TipoCarteiraConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Entity
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome_completo")
    private String nomeCompleto;

    @NotNull
    @Length(min = 11, max = 14)
    @Column(name = "cpf_cnpj", nullable = false, unique = true)
    private String cpfCnpj;

    @NotNull
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull
    private String senha;

    @NotNull
    private BigDecimal saldo = BigDecimal.ZERO;

    @NotNull
    @Convert(converter = TipoCarteiraConverter.class)
    private TipoCarteira tipoCarteira;

    public Carteira() {
    }

    public Carteira(Long id, String nomeCompleto, String cpfCnpj, String email, String senha, BigDecimal saldo, TipoCarteira tipoCarteira) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.senha = senha;
        this.saldo = saldo;
        this.tipoCarteira = tipoCarteira;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public TipoCarteira getTipoCarteira() {
        return tipoCarteira;
    }

    public void setTipoCarteira(TipoCarteira tipoCarteira) {
        this.tipoCarteira = tipoCarteira;
    }

    public void debitar(BigDecimal valor) {
        this.saldo = this.saldo.subtract(valor);
    }

    public void creditar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }
}
