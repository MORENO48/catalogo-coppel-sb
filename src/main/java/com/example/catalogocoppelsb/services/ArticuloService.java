package com.example.catalogocoppelsb.services;

import java.util.ArrayList;
import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.catalogocoppelsb.models.ArticuloModel;
import com.example.catalogocoppelsb.models.CaracteristicaModel;
import com.example.catalogocoppelsb.repositories.ArticuloRepository;
import com.example.catalogocoppelsb.repositories.CaracteristicaRepository;

@Service
public class ArticuloService {
    @Autowired
    ArticuloRepository articuloRepository;

    @Autowired
    CaracteristicaRepository caracteristicaRepository;

    public ArrayList<ArticuloModel> obtenerArticulos () {
        return (ArrayList<ArticuloModel>)articuloRepository.findAll();
    }

    public ArticuloModel guardarArticulo(ArticuloModel articulo) {
        //guardar articulo
        articulo.setStatus(1);

        List<CaracteristicaModel> caracteristicas = articulo.getCaracteristicas();
        ArticuloModel newArticulo = articuloRepository.save(articulo);
        
        //guardar caracteristicas
        Long newId = newArticulo.getId();
        System.out.println("Id: "+newId);
        for (CaracteristicaModel item : caracteristicas) {
            item.setArticuloId(newId);
            item.setStatus(1);
            caracteristicaRepository.save(item);
        }
        newArticulo.setCaracteristicas(caracteristicas);
        
        return newArticulo;
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
