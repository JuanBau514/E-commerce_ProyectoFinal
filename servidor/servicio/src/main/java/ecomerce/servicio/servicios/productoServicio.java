package ecomerce.servicio.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecomerce.servicio.modelo.productoModelo;
import ecomerce.servicio.repositoriosDAO.productoRepositorio;

@Service
public class productoServicio {
    
    @Autowired
    productoRepositorio repositorioProducto;

    public ArrayList<productoModelo> obtenerProductos() {
        return (ArrayList<productoModelo>) repositorioProducto.findAll();
    }

   public productoModelo guardarProducto (productoModelo producto) {
       return repositorioProducto.save(producto);
   }
   
   public ArrayList<productoModelo> obtenerPorTitulo(String Titulo) {
       return repositorioProducto.findByTitulo(Titulo);
   }

   public Optional<productoModelo> obtenerPorId(Long id) {
       return repositorioProducto.findById(id);
   }

   public boolean eliminarProducto(Long id) {
       try {
           repositorioProducto.deleteById(id);
           return true;
       } catch (Exception err) {
           return false;
       }
   }

}
