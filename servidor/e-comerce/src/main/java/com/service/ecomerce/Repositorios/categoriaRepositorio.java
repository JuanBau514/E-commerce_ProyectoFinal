package com.service.ecomerce.Repositorios;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.ecomerce.Modelos.categoriaModelo;

import jakarta.transaction.Transactional;

@Repository
public interface categoriaRepositorio extends CrudRepository<categoriaModelo, Integer> {

    categoriaModelo findByNombre(String nombre);

    void deleteByNombre(String nombre);

    void deleteById(int id);

    categoriaModelo save(categoriaModelo categoriaModelo);

    @Modifying
    @Transactional
    @Query("UPDATE categoriaModelo c SET c.nombre = :nombre WHERE c.id = :id")
    void update(@Param("id") int id, @Param("nombre") String nombre);

}
