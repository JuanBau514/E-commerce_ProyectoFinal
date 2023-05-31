package com.service.ecomerce.Controladores;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.ecomerce.Modelos.productoModelo;
import com.service.ecomerce.Services.productoServicio;

@RestController
@RequestMapping("/producto")

public class productoControlador {
        
    @Autowired
    productoServicio servicioProducto;

    @GetMapping()
    public ArrayList <productoModelo> getProductos  () {
        return servicioProducto.obtenerProductos();
    }
    
    @PostMapping()
    public productoModelo guardarProducto(productoModelo producto) {
        return this.servicioProducto.guardarProducto(producto);
    }

    @GetMapping(path = "/{id}")
    public Optional <productoModelo> obtenerProductoPorId( @PathVariable Integer id) {
        return this.servicioProducto.obtenerPorId(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<productoModelo> obtenerProductoPorNombre(@RequestParam ("nombre") String nombre) {
        return this.servicioProducto.obtenerPorNombre(nombre);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(Integer id) {
        boolean ok = this.servicioProducto.eliminarProducto(id);
        if (ok) {
            return "Se eliminó el producto con id " + id;
        } else {
            return "No pudo eliminar el producto con id" + id;
        }
    }

}
    
    
