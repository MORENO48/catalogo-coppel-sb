package com.example.catalogocoppelsb.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.catalogocoppelsb.models.ArticuloModel;
import com.example.catalogocoppelsb.repositories.ArticuloRepository;

@Service
public class ArticuloService {
    @Autowired
    ArticuloRepository articuloRepository;

    public ArrayList<ArticuloModel> obtenerArticulos () {
        return (ArrayList<ArticuloModel>)articuloRepository.findAll();
    }

    public ArticuloModel guardarArticulo(ArticuloModel articulo) {
        articulo.setStatus(1);
        return articuloRepository.save(articulo);
    }

    public Optional<ArticuloModel> obtenerById(Long id) {
        return articuloRepository.findById(id);
    }

    public ArrayList<ArticuloModel> obtenerArticuloPorBusqueda (String codigo, String nombre, Long categoria_id) {
        Integer status = 1;
        return articuloRepository.findByCodigoAndNombreContainingAndCatAndStatus(codigo,nombre,categoria_id,status);
    }

    public boolean eliminarArticulo(Long id) {
        try {
            articuloRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
