package Servicio.demo.repositorios;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Servicio.demo.modelo.categoriaModelo;

@Repository
public interface categoriaRepositorio extends CrudRepository <categoriaModelo, Long> {
    
    public abstract ArrayList<categoriaModelo> findByNombre(String nombre);
    public abstract ArrayList<categoriaModelo> findById(long id);
}
