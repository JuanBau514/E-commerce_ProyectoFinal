package com.service.ecomerce.Repositorios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.service.ecomerce.Modelos.productoModelo;

@Repository
public interface productoRepositorio extends CrudRepository<productoModelo, Integer> {
    
   
    public abstract ArrayList<productoModelo> findByNombre(String nombre);
}
