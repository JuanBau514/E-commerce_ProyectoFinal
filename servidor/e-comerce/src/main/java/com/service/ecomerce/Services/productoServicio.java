package com.service.ecomerce.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ecomerce.Modelos.productoModelo;
import com.service.ecomerce.Repositorios.productoRepositorio;

@Service
public class productoServicio {

    @Autowired
    private  productoRepositorio repositorioProducto;

    public  productoModelo guardar(productoModelo producto) {
        return repositorioProducto.save(producto);
    }

    public java.util.List<productoModelo> obtenerTodos() {
        return (java.util.List<productoModelo>) repositorioProducto.findAll();
    }

    public Optional<productoModelo> obtenerPorId(int id) {
        return repositorioProducto.findById(id);
    }

    public java.util.List<productoModelo> obtenerPorNombre(String Titulo) {
        return repositorioProducto.findByTitulo(Titulo);
    }

    public void eliminarPorId(int id) {
        repositorioProducto.deleteById(id);
    }

    public void eliminarPorNombre(String Titulo) {
        repositorioProducto.deleteByTitulo(Titulo);
    }

    public void eliminarTodos() {
        repositorioProducto.deleteAll();
    }

    public void actualizar(productoModelo productoModelo) {
        Optional<productoModelo> productoExistente = repositorioProducto.findById(productoModelo.getId());
        if (productoExistente.isPresent()) {
            productoModelo existente = productoExistente.get();
            existente.setTitulo(productoModelo.getTitulo());
            existente.setImagen(productoModelo.getImagen());
            existente.setCategoria(productoModelo.getCategoria());
            existente.setDescripcion(productoModelo.getDescripcion());
            existente.setPrecio(productoModelo.getPrecio());
            existente.setStock(productoModelo.getStock());
            repositorioProducto.save(existente);
        }
    }
    
    
}
