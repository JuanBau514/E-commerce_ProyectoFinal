package com.service.ecomerce.Modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity 
@Table(name = "producto") // nombre de la tabla en la base de datos
@JsonIgnoreProperties(ignoreUnknown = true) // ignora los campos que no estan en la tabla

public class productoModelo {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)

    private int id;

    private String titulo;
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private categoriaModelo categoria;

    private String descripcion;
    private int precio;
    private int stock;

    public productoModelo() {
    }

    public productoModelo(int id, String titulo, String imagen, categoriaModelo categoria, String descripcion,
            int precio, int stock) {
        this.id = id;
        this.titulo = titulo;
        this.imagen = imagen;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public productoModelo(String titulo, String imagen, categoriaModelo categoria, String descripcion, int precio,
            int stock) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;

    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setCategoria(categoriaModelo categoria) {
        this.categoria = categoria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getImagen() {
        return this.imagen;
    }

    public categoriaModelo getCategoria() {
        return this.categoria;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public int getPrecio() {
        return this.precio;
    }

    public int getStock() {
        return this.stock;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", titulo='" + getTitulo() + "'" + ", imagen='" + getImagen() + "'"
                + ", categoria='" + getCategoria() + "'" + ", descripcion='" + getDescripcion() + "'" + ", precio='"
                + getPrecio() + "'" + ", stock='" + getStock() + "'" + "}";
    }

}
