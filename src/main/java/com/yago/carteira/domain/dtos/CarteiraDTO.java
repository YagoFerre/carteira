package com.yago.carteira.domain.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public record CarteiraDTO(
        @NotNull @Column(name = "nome_completo") String nomeCompleto,
        @NotNull @Column(name = "email", nullable = false, unique = true) String email,
        @NotNull @Length(min = 11, max = 14) @Column(name = "cpf_cnpj", nullable = false, unique = true) String cpfCnpj,
        @NotNull String senha,
        @NotNull BigDecimal saldo,
        @NotNull @Pattern(regexp = "Comum|Lojista") String tipoCarteira
) {
}
