package com.service.ecomerce.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria") // nombre de la tabla en la base de datos
public class categoriaModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    private String nombre;

    public categoriaModelo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public categoriaModelo(String nombre ) {
        this.nombre = nombre;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "{" + " nombre='" + getNombre() + "'" + ", id='" + getId() + "'" + "}";
    }
}
