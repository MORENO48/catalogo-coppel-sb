package com.example.catalogocoppelsb.models;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="articulos")
public class ArticuloModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cat_id")
    private Long cat;

    @Column(name = "status")
    private Integer status;
    private Timestamp created_at;
    private Timestamp updated_at;

    @OneToMany(mappedBy="articulo")
    private List<CaracteristicaModel> caracteristicas;

    // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    // @JoinColumn(name = "articulo_id", insertable=false, updatable=false)
    // private List<CaracteristicaModel> caracteristicas;

    @OneToOne(optional=false, cascade = CascadeType.ALL)
    @JoinColumn(name = "cat_id", referencedColumnName = "id", insertable=false, updatable=false)
    private CategoriaModel categoria;

    public Long getCat() {
        return cat;
    }
    public void setCat(Long cat) {
        this.cat = cat;
    }
    public List<CaracteristicaModel> getCaracteristicas() {
        return caracteristicas;
    }
    public void setCaracteristicas(List<CaracteristicaModel> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
    public CategoriaModel getCategoria() {
        return categoria;
    }
    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }
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
