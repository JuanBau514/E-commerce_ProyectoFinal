package com.service.ecomerce.Services;

import java.util.ArrayList;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ecomerce.Modelos.productoModelo;
import com.service.ecomerce.Repositorios.productoRepositorio;

@Service
public class productoServicio {

    @Autowired
    private productoRepositorio repositorioProducto;
    
    public ArrayList<productoModelo> obtenerProductos() {
        return (ArrayList<productoModelo>) repositorioProducto.findAll();
    }

    public productoModelo guardarProducto(productoModelo producto) {
        return repositorioProducto.save(producto);
    }

    public Optional<productoModelo> obtenerPorId(Integer id) {
        return repositorioProducto.findById(id);
    }
    
    public ArrayList<productoModelo> obtenerPorNombre(String nombre) {
        return repositorioProducto.findByNombre(nombre);
    }

    public boolean eliminarProducto(Integer id) {
        try {
            repositorioProducto.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
