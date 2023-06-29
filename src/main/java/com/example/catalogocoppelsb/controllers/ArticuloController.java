package com.example.catalogocoppelsb.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.example.catalogocoppelsb.models.CaracteristicaDTO;
import com.example.catalogocoppelsb.models.CaracteristicaModel;
import com.example.catalogocoppelsb.services.ArticuloService;
import com.example.catalogocoppelsb.services.CaracteristicaService;

@RestController
@CrossOrigin(origins = "http://localhost:8080/",allowedHeaders = "*")
@RequestMapping("/api/articulo")
public class ArticuloController {
    @Autowired
	private ModelMapper modelMapper;

    @Autowired
    ArticuloService articuloService;

    @Autowired
    CaracteristicaService caracteristicaService;

    @GetMapping( path = "/{id}")
    public Optional<ArticuloModel> obtenerArticuloPorId(@PathVariable("id") Long id) {
        return this.articuloService.obtenerById(id);
    }

    @GetMapping()
    public ArrayList<ArticuloModel> obtenerArticulos() {
        return articuloService.obtenerArticulos();
    }

    @GetMapping("busqueda")
    public ArrayList<ArticuloModel> obtenerArticuloPorBusqueda(@RequestParam(value="codigo", required = false) String codigo, @RequestParam(value = "nombre", required = false) String nombre, @RequestParam(value = "cat", required = false) Long categoria_id) {
        System.out.println("paso 1");
        return this.articuloService.obtenerArticuloPorBusqueda(codigo,nombre,categoria_id);
    }

    @PostMapping()
    public ResponseEntity<?> guardarArticulo(@RequestBody ArticuloDTO articuloData) {        
        try {
            //Convertir datos DTO a modelo
            ArticuloModel articulo = modelMapper.map(articuloData, ArticuloModel.class);
            
            //Guardar articulo
            ArticuloModel articuloResponse = this.articuloService.guardarArticulo(articulo);
            
            return ResponseEntity.status(HttpStatus.OK).body(articuloResponse);
            
        } catch (DataIntegrityViolationException  e) {
            return ResponseEntity.status(400).body("Codigo de articulo ya existe");
        } catch (Exception  e) {
            return ResponseEntity.status(500).body("Error al guardar articulo");
        }
    }

    @PostMapping("caracteristica")
    public ResponseEntity<?> guardarCaracteristica(@RequestBody CaracteristicaDTO caracteristicaData) {
        try {
            System.out.println("articulo_id =>"+caracteristicaData.getArticuloid());
            System.out.println("nombre =>"+caracteristicaData.getNombre());
            System.out.println("valor =>"+caracteristicaData.getValor());
            //Convertir datos DTO a modelo
            CaracteristicaModel carac = modelMapper.map(caracteristicaData, CaracteristicaModel.class);

            //Guardar caracteristica
            CaracteristicaModel caracResponse = this.caracteristicaService.guardarCaracteristica(carac);

            return ResponseEntity.status(HttpStatus.OK).body(caracResponse);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al guardar caracteristica");
        }
    }

    @DeleteMapping( path = "/{id}")
    public ResponseEntity<?> eliminarporId(@PathVariable("id") Long id) {
        boolean ok = this.articuloService.eliminarArticulo(id);

        if (ok) {
            return ResponseEntity.status(HttpStatus.OK).body("Se eliminó el articulo "+id);
        } else {
            return ResponseEntity.status(400).body("No se encontro el articulo "+id);
        }
    }

    @DeleteMapping( path = "/caracteristica/{id}")
    public ResponseEntity<?> eliminarporCaractId(@PathVariable("id") Long id) {
        boolean ok = this.articuloService.eliminarCaracteristica(id);

        if (ok) {
            return ResponseEntity.status(HttpStatus.OK).body("Se eliminó el articulo "+id);
        } else {
            return ResponseEntity.status(400).body("No se encontro el articulo "+id);
        }
    }
}
