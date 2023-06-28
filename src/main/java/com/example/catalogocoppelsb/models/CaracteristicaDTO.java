package com.example.catalogocoppelsb.models;

public class CaracteristicaDTO {
    private Long id;
    private Long articulo;
    private String nombre;
    private String Valor;
    private Integer status;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getArticulo() {
        return articulo;
    }
    public void setArticulo(Long articulo_id) {
        this.articulo = articulo_id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getValor() {
        return Valor;
    }
    public void setValor(String valor) {
        Valor = valor;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
}
