package com.example.catalogocoppelsb.repositories;

import com.example.catalogocoppelsb.models.CategoriaModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository <CategoriaModel, Long> {

}
