package Servicio.demo.controladores;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Servicio.demo.modelo.categoriaModelo;
import Servicio.demo.servicios.categoriaServicio;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/categoria")

public class categoriaControlador {

    @Autowired
    categoriaServicio categoriaServicio;
    
    @GetMapping()
    public ArrayList<categoriaModelo> obtenerCategorias() {
        return categoriaServicio.obtenerCategorias();
    }

   @PostMapping()
    public categoriaModelo guardarCategoria(@RequestBody categoriaModelo categoria) {
        return this.categoriaServicio.guardarCategoria(categoria);
    }

    @GetMapping(path = "/{id}")
    public Optional <categoriaModelo> obtenerCategoriaPorId(@PathVariable("id") Long id) {
        return this.categoriaServicio.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<categoriaModelo> obtenerCategoriaPorNombre(@RequestParam("nombre") String nombre) {
        return this.categoriaServicio.obtenerPorNombre(nombre);
    }
    
    @DeleteMapping( path = "/{id}" )
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.categoriaServicio.eliminarCategoria(id);
        if (ok) {
            return "Se eliminó la categoria con id " + id;
        } else {
            return "No pudo eliminar la categoria con id" + id;
        }
    }
}
