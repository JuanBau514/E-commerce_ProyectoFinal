package com.service.ecomerce.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")

public class productoModelo {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;


    private String nombre;
    private String descripcion;
    private int precio;
    private int stock;
    private String imagen;
    private int id_categoria;
    
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripción(String descripción) {
        this.descripcion = descripción;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio= precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock= stock;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen= imagen;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria= id_categoria;
    }
 

}
