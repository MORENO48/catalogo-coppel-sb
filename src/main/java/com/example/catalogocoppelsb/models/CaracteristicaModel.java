package com.example.catalogocoppelsb.models;

import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name="caracteristicas")
public class CaracteristicaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "articulo_id")
    private Long articuloid;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "valor")
    private String Valor;

    @Column(name = "status")
    private Integer status;
    private Timestamp created_at;//timestamp
    private Timestamp updated_at; //timestamp

    @ManyToOne
    @JoinColumn(name = "articulo_id", insertable=false, updatable=false)
    private ArticuloModel articulo;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getArticuloId() {
        return articuloid;
    }
    public void setArticuloId(Long articulo_id) {
        this.articuloid = articulo_id;
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
