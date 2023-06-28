package com.example.catalogocoppelsb.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogocoppelsb.models.ArticuloDTO;
import com.example.catalogocoppelsb.models.ArticuloModel;
import com.example.catalogocoppelsb.services.ArticuloService;

@RestController
@RequestMapping("/api/articulo")
public class ArticuloController {
    @Autowired
	private ModelMapper modelMapper;

    @Autowired
    ArticuloService articuloService;

    @GetMapping( path = "/{id}")
    public Optional<ArticuloModel> obtenerArticuloPorId(@PathVariable("id") Long id) {
        return this.articuloService.obtenerById(id);
    }

    @GetMapping()
    public ArrayList<ArticuloModel> obtenerArticulos() {
        return articuloService.obtenerArticulos();
    }

    @GetMapping("busqueda")
    public ArrayList<ArticuloModel> obtenerArticuloPorBusqueda(@RequestParam("codigo") String codigo, @RequestParam("nombre") String nombre, @RequestParam("categoria_id") Long categoria_id) {
        return this.articuloService.obtenerArticuloPorBusqueda(codigo,nombre,categoria_id);
    }

    @PostMapping()
    public ArticuloModel guardarArticulo(@RequestBody ArticuloDTO articuloData) {        
        //Convertir datos DTO a modelo
        ArticuloModel articulo = modelMapper.map(articuloData, ArticuloModel.class);
        
        //Guardar articulo
        ArticuloModel articuloResponse = this.articuloService.guardarArticulo(articulo);
        
        return articuloResponse;
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarporId(@PathVariable("id") Long id) {
        boolean ok = this.articuloService.eliminarArticulo(id);

        if (ok) {
            return "Se eliminó el articulo "+id;
        } else {
            return "No se encontro el articulo "+id;
        }
    }
}
