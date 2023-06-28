package com.example.catalogocoppelsb.repositories;

import com.example.catalogocoppelsb.models.ArticuloModel;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends JpaRepository <ArticuloModel, Long> {
    public abstract Optional<ArticuloModel> findByCodigo(String codigo);
    public abstract ArrayList<ArticuloModel> findByStatus(Integer status);

    public ArrayList<ArticuloModel> findByCodigoAndNombreContainingAndCatAndStatus(String codigo, String nombre, Long cat_id, Integer status);
    public ArrayList<ArticuloModel> findByCatAndStatus(Long cat_id, Integer status);
    public ArrayList<ArticuloModel> findByCodigoAndStatus(String codigo, Integer status);
    public ArrayList<ArticuloModel> findByNombreContainingAndStatus(String nombre, Integer status);
    public ArrayList<ArticuloModel> findByCodigoAndNombreContainingAndStatus(String codigo, String nombre, Integer status);
    public ArrayList<ArticuloModel> findByNombreContainingAndCatAndStatus(String nombre, Long cat_id, Integer status);
    public ArrayList<ArticuloModel> findByCodigoAndCatAndStatus(String codigo, Long cat_id, Integer status);
    
}
