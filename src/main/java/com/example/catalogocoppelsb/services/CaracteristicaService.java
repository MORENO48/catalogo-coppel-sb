package com.example.catalogocoppelsb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.catalogocoppelsb.models.CaracteristicaModel;
import com.example.catalogocoppelsb.repositories.CaracteristicaRepository;

@Service
public class CaracteristicaService {
    @Autowired
    CaracteristicaRepository caracteristicaRepository;

    public List<CaracteristicaModel> getCaracteristicas() {
        return caracteristicaRepository.findAll();
    }

    public CaracteristicaModel guardarCaracteristica (CaracteristicaModel carac) {
        Integer status = 1;
        carac.setStatus(status);
        return caracteristicaRepository.save(carac);
    }
}
