package com.yago.carteira.service;

import com.yago.carteira.domain.Carteira;
import com.yago.carteira.domain.Transferencia;
import com.yago.carteira.domain.enumerators.TipoCarteira;
import com.yago.carteira.exception.SaldoException;
import com.yago.carteira.exception.TipoUsuarioException;
import com.yago.carteira.repository.CarteiraRepository;
import com.yago.carteira.repository.TransferenciaRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;
    private final CarteiraRepository carteiraRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository, CarteiraRepository carteiraRepository) {
        this.transferenciaRepository = transferenciaRepository;
        this.carteiraRepository = carteiraRepository;
    }

    public Transferencia transferencia(Transferencia transferencia) {
        Carteira pagador = carteiraRepository.findById(transferencia.getPagador().getId()).orElseThrow(() -> new RuntimeException(""));
        Carteira beneficiario = carteiraRepository.findById(transferencia.getBeneficiario().getId()).orElseThrow(() -> new RuntimeException(""));

        transferenciaValidation(pagador, transferencia);

        pagador.debitar(transferencia.getValor());
        beneficiario.creditar(transferencia.getValor());

        transferencia.setPagador(pagador);
        transferencia.setBeneficiario(beneficiario);

        carteiraRepository.save(pagador);
        carteiraRepository.save(beneficiario);
        return transferenciaRepository.save(transferencia);
    }

    public void transferenciaValidation(Carteira usuarioCarteira, Transferencia transferencia) {
        if (usuarioCarteira.getTipoCarteira().equals(TipoCarteira.LOJISTA)) {
            throw new TipoUsuarioException(usuarioCarteira.getTipoCarteira());
        }

        if (usuarioCarteira.getSaldo().compareTo(transferencia.getValor()) < 0) {
            throw new SaldoException();
        }
    }
}
