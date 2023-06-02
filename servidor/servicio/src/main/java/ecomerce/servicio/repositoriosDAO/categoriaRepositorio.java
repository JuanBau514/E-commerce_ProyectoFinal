package ecomerce.servicio.repositoriosDAO;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ecomerce.servicio.modelo.categoriaModelo;

@Repository
public interface categoriaRepositorio extends CrudRepository <categoriaModelo, Long> {
    
    public abstract ArrayList<categoriaModelo> findByNombre(String nombre);
    public abstract ArrayList<categoriaModelo> findById(long id);
}
