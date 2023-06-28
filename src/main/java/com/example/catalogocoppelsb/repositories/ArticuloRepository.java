package com.example.catalogocoppelsb.repositories;

import com.example.catalogocoppelsb.models.ArticuloModel;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends JpaRepository <ArticuloModel, Long> {
    public abstract ArrayList<ArticuloModel> findByCodigo(String codigo);
    public abstract ArrayList<ArticuloModel> findByStatus(Integer status);

    public ArrayList<ArticuloModel> findByCodigoAndNombreContainingAndCatAndStatus(String codigo, String nombre, Long cat_id, Integer status);
}
