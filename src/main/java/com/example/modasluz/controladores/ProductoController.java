package com.example.modasluz.controladores;

import com.example.modasluz.dto.ProductoDTO;
import com.example.modasluz.modelos.Producto;
import com.example.modasluz.services.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@AllArgsConstructor
public class ProductoController {

    private ProductoService productoService;


    @GetMapping("/listar")
    public List<ProductoDTO> getColor(){
        List<ProductoDTO> producto= productoService.getAll();
        return producto;
    }

    @GetMapping()
    public Producto getColorById(@RequestParam Integer id){
        Producto producto= productoService.getById(id);
        return producto;
    }

    @GetMapping("/{id}")
    public Producto getColorByIdPath(@PathVariable Integer id){
        Producto producto= productoService.getById(id);
        return producto;
    }

    @PostMapping()
    public Producto guardarColor(@RequestBody ProductoDTO color){
        Producto productoGuardar = productoService.guardar(color);
        return productoGuardar;
    }

    @DeleteMapping()
    public String eliminarColor(@RequestParam Integer id){
        Producto producto = productoService.getById(id);
        String mensaje = "";
        if (producto == null) {
            mensaje = "El perfil con el id indicado no existe ";
        }
        try {
            productoService.eliminar(id);
            producto = productoService.getById(id);
            if (producto != null) {
                mensaje = ("No se ha podido eliminar el catalogo");
            }
        } catch (Exception e) {
            mensaje = "No se ha podido eliminar el catalogo";
        }
        return mensaje;
    }
}
