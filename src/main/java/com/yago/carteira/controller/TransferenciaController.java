package com.yago.carteira.controller;

import com.yago.carteira.domain.Transferencia;
import com.yago.carteira.service.TransferenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transferencia")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping
    public ResponseEntity<Transferencia> create(@RequestBody Transferencia transferencia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transferenciaService.transferencia(transferencia));
    }
}
