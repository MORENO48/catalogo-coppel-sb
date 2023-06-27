package com.example.catalogocoppelsb.models;

import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name="cat_articulos")
public class CaracteristicaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Long articulo_id;
    private String nombre;
    private String Valor;
    private Integer status;
    private Timestamp created_at;//timestamp
    private Timestamp updated_at; //timestamp

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getArticulo_id() {
        return articulo_id;
    }
    public void setArticulo_id(Long articulo_id) {
        this.articulo_id = articulo_id;
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
    public Timestamp getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
    public Timestamp getUpdated_at() {
        return updated_at;
    }
    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

}
