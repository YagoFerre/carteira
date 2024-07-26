package com.yago.carteira.domain.dtos.mappers;

import com.yago.carteira.domain.Carteira;
import com.yago.carteira.domain.dtos.CarteiraDTO;
import com.yago.carteira.domain.enumerators.TipoCarteira;
import org.springframework.stereotype.Component;

@Component
public class CarteiraMapper {

    public Carteira toEntity(CarteiraDTO dto) {
        if (dto == null) {
            return null;
        }

        Carteira carteira = new Carteira();
        carteira.setNomeCompleto(dto.nomeCompleto());
        carteira.setEmail(dto.email());
        carteira.setCpfCnpj(dto.cpfCnpj());
        carteira.setSenha(dto.senha());
        carteira.setSaldo(dto.saldo());
        carteira.setTipoCarteira(convertTipoCarteiraValue(dto.tipoCarteira()));

        return carteira;
    }

    public CarteiraDTO toDTO(Carteira carteira) {
        if (carteira == null) {
            return null;
        }

        return new CarteiraDTO(
                carteira.getNomeCompleto(),
                carteira.getEmail(),
                carteira.getCpfCnpj(),
                carteira.getSenha(),
                carteira.getSaldo(),
                carteira.getTipoCarteira().getValue()
        );
    }

    public TipoCarteira convertTipoCarteiraValue(String value) {
        if (value == null) {
            return null;
        }

        return switch (value) {
            case "Comum" -> TipoCarteira.COMUM;
            case "Lojista" -> TipoCarteira.LOJISTA;
            default -> throw new IllegalStateException("Tipo de carteira inválida: " + value);
        };
    }
}
