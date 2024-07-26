package com.yago.carteira.domain.enumerators.converters;

import com.yago.carteira.domain.enumerators.TipoCarteira;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class TipoCarteiraConverter implements AttributeConverter<TipoCarteira, String> {
    @Override
    public String convertToDatabaseColumn(TipoCarteira attribute) {
        if (attribute == null) {
            return null;
        }

        return attribute.getValue();
    }

    @Override
    public TipoCarteira convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }

        return Stream.of(TipoCarteira.values())
                .filter(tipoCarteira -> tipoCarteira.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
