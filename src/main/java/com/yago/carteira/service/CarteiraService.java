package com.yago.carteira.service;

import com.yago.carteira.domain.Carteira;
import com.yago.carteira.domain.dtos.CarteiraDTO;
import com.yago.carteira.domain.dtos.mappers.CarteiraMapper;
import com.yago.carteira.repository.CarteiraRepository;
import org.springframework.stereotype.Service;

@Service
public class CarteiraService {

    private final CarteiraRepository carteiraRepository;
    private final CarteiraMapper carteiraMapper;

    public CarteiraService(CarteiraRepository carteiraRepository, CarteiraMapper carteiraMapper) {
        this.carteiraRepository = carteiraRepository;
        this.carteiraMapper = carteiraMapper;
    }

    public CarteiraDTO create(CarteiraDTO dto) {
        Carteira carteira = carteiraMapper.toEntity(dto);

        return carteiraMapper.toDTO(carteiraRepository.save(carteira));
    }
}
