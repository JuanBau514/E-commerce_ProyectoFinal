package com.service.ecomerce.Controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.service.ecomerce.Modelos.categoriaModelo;
import com.service.ecomerce.Modelos.productoModelo;
import com.service.ecomerce.Services.productoServicio;
import com.service.ecomerce.Services.servicioCategoria;

@RestController
@RequestMapping("/categoria")
public class categoriaControlador {
    
    @Autowired
    private servicioCategoria categoriaServicio;

    @GetMapping("")
    public List<categoriaModelo> obtenerTodos(){
        return categoriaServicio.obtenerTodos();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<categoriaModelo> obtenerPorId(@PathVariable int id) {
        Optional<categoriaModelo> categoria = categoriaServicio.obtenerPorId(id);
        if (categoria.isPresent()) {
            return ResponseEntity.ok(categoria.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<categoriaModelo> actualizar(@RequestBody categoriaModelo categoria, @PathVariable int id) {
        Optional<categoriaModelo> categoriaExistente = categoriaServicio.obtenerPorId(id);
        if (categoriaExistente.isPresent()) {
            categoriaModelo categoriaActualizada = categoriaExistente.get();
            categoriaActualizada.setNombre(categoria.getNombre());
            categoriaServicio.guardar(categoriaActualizada);
            return ResponseEntity.ok(categoriaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/producto")
    public ResponseEntity <productoModelo> crearProducto(@RequestBody productoModelo producto) {
        productoModelo nuevoProducto = productoServicio.guardar(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }
    

    @PostMapping("/")
    public ResponseEntity <categoriaModelo> crearCategoria(@RequestBody categoriaModelo categoria) {
            categoriaModelo nuevoCategoria = categoriaServicio.guardar(categoria);
            productoServicio.guardar(producto);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCategoria);
        }


    @DeleteMapping("/{id}")
    public ResponseEntity<categoriaModelo> eliminarPorId(@PathVariable int id) {
        Optional<categoriaModelo> categoria = categoriaServicio.obtenerPorId(id);
        if (categoria.isPresent()) {
            categoriaServicio.eliminarPorId(id);
            return ResponseEntity.ok(categoria.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<categoriaModelo> eliminarTodos() {
        categoriaServicio.eliminarTodos();
        return ResponseEntity.ok().build();
    }

}

