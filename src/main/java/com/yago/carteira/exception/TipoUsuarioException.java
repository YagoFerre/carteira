package com.yago.carteira.exception;

import com.yago.carteira.domain.enumerators.TipoCarteira;

public class TipoUsuarioException extends RuntimeException {

    public TipoUsuarioException(TipoCarteira tipo) {
        super("Operação não permitida para o perfil: " + tipo.getValue());
    }
}
