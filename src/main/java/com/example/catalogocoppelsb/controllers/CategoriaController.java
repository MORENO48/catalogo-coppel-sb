package com.example.catalogocoppelsb.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogocoppelsb.models.CategoriaModel;
import com.example.catalogocoppelsb.services.CategoriaService;

@CrossOrigin(origins = "http://localhost:8080/",allowedHeaders = "*")
@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @CrossOrigin
    @GetMapping()
    public ArrayList<CategoriaModel> obtenerCategorias () {
        return categoriaService.getCategorias();
    }

    @CrossOrigin
    @GetMapping( path = "/{id}")
    public Optional<CategoriaModel> obtenerPorId (@PathVariable("id") Long id) {
        return categoriaService.obtenerPorId(id);
    }
}
