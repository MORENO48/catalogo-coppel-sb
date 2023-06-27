package com.example.catalogocoppelsb.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogocoppelsb.models.ArticuloModel;
import com.example.catalogocoppelsb.services.ArticuloService;

@RestController
@RequestMapping("/articulo")
public class ArticuloController {
    @Autowired
    ArticuloService articuloService;

    @GetMapping()
    public ArrayList<ArticuloModel> obtenerArticulos() {
        return articuloService.obtenerArticulos();
    }

    @PostMapping()
    public ArticuloModel guardarArticulo(@RequestBody ArticuloModel articulo) {
        System.out.println(articulo.getCodigo());
        return this.articuloService.guardarArticulo(articulo);
    }

    @GetMapping( path = "/{id}")
    public Optional<ArticuloModel> obtenerArticuloPorId(@PathVariable("id") Long id) {
        return this.articuloService.obtenerById(id);
    }

    @GetMapping("query")
    public ArrayList<ArticuloModel> obtenerArticuloPorBusqueda(@RequestParam("codigo") String codigo, @RequestParam("nombre") String nombre, @RequestParam("categoria_id") Long categoria_id) {
        return this.articuloService.obtenerArticuloPorBusqueda(codigo,nombre,categoria_id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarporId(@PathVariable("id") Long id) {
        boolean ok = this.articuloService.eliminarArticulo(id);

        if (ok) {
            return "Se eliminó el articulo "+id;
        } else {
            return "No se pudo eliminar el articulo "+id;
        }
    }
}
