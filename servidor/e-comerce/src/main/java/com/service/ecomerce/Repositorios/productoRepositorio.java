package com.service.ecomerce.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.service.ecomerce.Modelos.productoModelo;

@Repository
public interface productoRepositorio extends CrudRepository<productoModelo, Integer> {
    
    List<productoModelo> findByTitulo(String titulo);

    Optional<productoModelo> findById(int id);

    void deleteByTitulo(String titulo);

}
