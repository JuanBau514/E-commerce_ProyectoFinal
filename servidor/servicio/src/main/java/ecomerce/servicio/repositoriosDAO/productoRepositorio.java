package ecomerce.servicio.repositoriosDAO;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ecomerce.servicio.modelo.productoModelo;

@Repository
public interface productoRepositorio extends CrudRepository <productoModelo, Long>{
    
    public abstract ArrayList<productoModelo> findByTitulo(String Titulo);
    public abstract ArrayList<productoModelo> findById(long id);

}
