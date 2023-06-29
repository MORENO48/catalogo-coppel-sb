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
        Integer status = 1;
        return (ArrayList<ArticuloModel>)articuloRepository.findByStatus(status);
    }

    public ArticuloModel guardarArticulo(ArticuloModel articulo) {
        //guardar articulo
        articulo.setStatus(1);

        List<CaracteristicaModel> caracteristicas = articulo.getCaracteristicas();
        Long id = articulo.getId();
        if (id != null) {
            //Actualizar articulo
            Optional<ArticuloModel> existe = articuloRepository.findById(id);
            ArticuloModel actualizarArticulo = existe.get();

            actualizarArticulo.setNombre(articulo.getNombre());
            actualizarArticulo.setCat(articulo.getCat());

            return articuloRepository.save(actualizarArticulo);
        }
        
        ArticuloModel newArticulo = articuloRepository.save(articulo);
        
        //guardar caracteristicas
        Long newId = newArticulo.getId();
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

        if (codigo == "" || codigo == null || nombre == "" || nombre == null || categoria_id == null) {

            if (codigo != "" && codigo != null) {
                if (nombre != "" && nombre != null) {
                    //Busqueda por codigo y nombre
                    return articuloRepository.findByCodigoAndNombreContainingAndStatus(codigo,nombre,status);
                } else if (categoria_id != null) {
                    //Busqueda por codigo y categoria
                    return articuloRepository.findByCodigoAndCatAndStatus(codigo, categoria_id,status);
                } else {
                    //Busqueda por codigo
                    return articuloRepository.findByCodigoAndStatus(codigo, status);
                }
            }
     
            if (nombre != "" && nombre != null) {
                if (categoria_id != null) {
                    //Busqueda por nombre y categoria
                    return articuloRepository.findByNombreContainingAndCatAndStatus(nombre, categoria_id, status);
                } else {
                    //Busqueda por nombre
                    return articuloRepository.findByNombreContainingAndStatus(nombre, status);
                }
            }

            if (categoria_id != null) {
                //Busqueda por categoria
                return articuloRepository.findByCatAndStatus(categoria_id, status);
            } 
            
            //busqueda sin parametros
            return articuloRepository.findByStatus(status);
        } else  {
            //Busqueda completa
            return articuloRepository.findByCodigoAndNombreContainingAndCatAndStatus(codigo,nombre,categoria_id,status);
        }
    }

    public boolean eliminarArticulo(Long id) {
        try {
            Optional<ArticuloModel> existe = articuloRepository.findById(id);
            if (!existe.isPresent()) {
                return false;
            }
            ArticuloModel articulo = existe.get();
            if (articulo.getStatus() == 0) {
                return false;
            }
            
            articulo.setStatus(0);
            articuloRepository.save(articulo);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean eliminarCaracteristica(Long id) {
        try {
            caracteristicaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
