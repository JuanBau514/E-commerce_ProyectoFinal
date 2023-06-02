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

import ecomerce.servicio.modelo.productoModelo;
import ecomerce.servicio.servicios.productoServicio;

@RestController
@RequestMapping("/producto")
public class productoControlador {
    
    @Autowired
    productoServicio productoService;

    @RequestMapping()
    public ArrayList<productoModelo> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    @PostMapping()
    public productoModelo guardarProducto (@RequestBody productoModelo producto) {
        return productoService.guardarProducto(producto);
    }
       
   @GetMapping(path = "/{id}")
   public Optional<productoModelo> obtenerPorId(@PathVariable Long id) {
       return productoService.obtenerPorId(id);
   }

   @GetMapping(path = "/query")
   public ArrayList<productoModelo> obtenerPorTitulo(@RequestParam String Titulo) {
       return productoService.obtenerPorTitulo(Titulo);
   }

   @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.productoService.eliminarProducto(id);
        if (ok) {
            return "Se eliminó la categoria con id " + id;
        } else {
            return "No pudo eliminar la categoria con id" + id;
        }
}

}
