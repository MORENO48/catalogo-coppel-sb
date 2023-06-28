package com.example.catalogocoppelsb.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.catalogocoppelsb.models.CategoriaModel;
import com.example.catalogocoppelsb.repositories.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public ArrayList<CategoriaModel> getCategorias() {
        Integer status = 1;
        return categoriaRepository.findByStatus(status);
    }

    public Optional<CategoriaModel> obtenerPorId(Long id) {
        return categoriaRepository.findById(id);
    }

}
