package com.service.ecomerce.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ecomerce.Modelos.categoriaModelo;
import com.service.ecomerce.Repositorios.categoriaRepositorio;

@Service
public class servicioCategoria {
    
    @Autowired
    private categoriaRepositorio repositorioCategoria;

    public java.util.List<categoriaModelo> obtenerTodos() {
        return (java.util.List<categoriaModelo>) repositorioCategoria.findAll();
    }

    public Optional<categoriaModelo> obtenerPorId(int id) {
        return repositorioCategoria.findById(id);
    }

    public categoriaModelo update(categoriaModelo categoriaModelo){
        return repositorioCategoria.save(categoriaModelo);
    }
    

    public categoriaModelo guardar(categoriaModelo categoriaModelo) {
        return repositorioCategoria.save(categoriaModelo);
    }

    public void eliminarPorId(int id) {
        repositorioCategoria.deleteById(id);
    }

    public void eliminarTodos() {
        repositorioCategoria.deleteAll();
    }

}
