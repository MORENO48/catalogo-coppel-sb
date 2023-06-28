package com.example.catalogocoppelsb.models;

import java.util.ArrayList;

public class ArticuloDTO {
    private Long id;
    private String codigo;
    private String nombre;
    private Long cat;
    private Integer status;
    private ArrayList<CaracteristicaDTO> caracteristicas;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Long getCat() {
        return cat;
    }
    public void setCat(Long cat) {
        this.cat = cat;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public ArrayList<CaracteristicaDTO> getCaracteristicas() {
        return caracteristicas;
    }
    public void setCaracteristicas(ArrayList<CaracteristicaDTO> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }


}
