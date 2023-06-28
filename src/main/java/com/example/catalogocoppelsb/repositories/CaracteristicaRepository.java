package com.example.catalogocoppelsb.repositories;

import com.example.catalogocoppelsb.models.CaracteristicaModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicaRepository extends JpaRepository <CaracteristicaModel, Long> {

}
