package com.service.ecomerce.Controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.ecomerce.Modelos.categoriaModelo;
import com.service.ecomerce.Modelos.productoModelo;
import com.service.ecomerce.Services.productoServicio;

@RestController
@RequestMapping("/producto")

public class productoControlador {
        
    @Autowired
    productoServicio servicioProducto;

    @GetMapping("")
    public ArrayList<productoModelo> obtenerTodos(){
        return (ArrayList<productoModelo>) servicioProducto.obtenerTodos();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<productoModelo> obtenerPorId(@PathVariable int id) {
        Optional<productoModelo> producto = servicioProducto.obtenerPorId(id);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<productoModelo> guardar(@RequestBody productoModelo producto) {
        categoriaModelo categoria = producto.getCategoria();
        if (categoria != null) {
            // Guardar la categoría primero si no se ha guardado previamente
            categoriaModelo nuevaCategoria = servicioCategoria.guardar(categoria);
            producto.setCategoria(categoria);        
        }
        
        productoModelo nuevoProducto = servicioProducto.guardar(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
}


}
    
    
