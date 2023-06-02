package Servicio.demo.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Servicio.demo.modelo.categoriaModelo;
import Servicio.demo.repositorios.categoriaRepositorio;

@Service
public class categoriaServicio {
    @Autowired
    categoriaRepositorio repositorioCategoria;

    public ArrayList<categoriaModelo> obtenerCategorias() {
        return (ArrayList<categoriaModelo>) repositorioCategoria.findAll();
    }

    public categoriaModelo guardarCategoria(categoriaModelo categoria) {
        return repositorioCategoria.save(categoria);
    }

    public ArrayList<categoriaModelo> obtenerPorNombre(String nombre) {
        return repositorioCategoria.findByNombre(nombre);
    }

    public Optional<categoriaModelo> obtenerPorId(Long id) {
        return repositorioCategoria.findById(id);
    }

    public boolean eliminarCategoria(Long id) {
        try {
            repositorioCategoria.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
