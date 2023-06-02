package ecomerce.servicio.controladores;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecomerce.servicio.modelo.categoriaModelo;
import ecomerce.servicio.servicios.categoriaServicio;

@RestController
@RequestMapping("/categoria")
public class categoriaControlador {

    @Autowired
    categoriaServicio servicioCategoria;

    @GetMapping()
    public ArrayList<categoriaModelo> obtenerCategorias() {
        return servicioCategoria.obtenerCategorias();
    }

    @PostMapping()
    public categoriaModelo guardarCategoria(@RequestBody categoriaModelo categoria) {
        return servicioCategoria.guardarCategoria(categoria);
    }

    @GetMapping(path = "/{id}")
    public Optional<categoriaModelo> obtenerPorId(@PathVariable Long id) {
            return servicioCategoria.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<categoriaModelo> obtenerPorNombre(@RequestParam("nombre") String nombre) {
        return servicioCategoria.obtenerPorNombre(nombre);
    }

    @DeleteMapping( path = "/{id}" )
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.servicioCategoria.eliminarCategoria(id);
        if (ok) {
            return "Se eliminó la categoria con id " + id;
        } else {
            return "No pudo eliminar la categoria con id" + id;
        }
    }

}