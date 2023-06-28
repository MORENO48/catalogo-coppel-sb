package com.example.catalogocoppelsb.repositories;

import com.example.catalogocoppelsb.models.CategoriaModel;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository <CategoriaModel, Long> {
    public abstract ArrayList<CategoriaModel> findByStatus(Integer status);
}
