package com.yago.carteira.controller;

import com.yago.carteira.domain.dtos.CarteiraDTO;
import com.yago.carteira.service.CarteiraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carteira")
public class CarteiraController {

    private final CarteiraService carteiraService;

    public CarteiraController(CarteiraService carteiraService) {
        this.carteiraService = carteiraService;
    }

    @PostMapping
    public ResponseEntity<CarteiraDTO> createCarteira(@RequestBody CarteiraDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carteiraService.create(dto));
    }
}
