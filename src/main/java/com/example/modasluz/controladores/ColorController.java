package com.example.modasluz.controladores;

import com.example.modasluz.modelos.Color;
import com.example.modasluz.services.ColorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/color")
@AllArgsConstructor
public class ColorController {

    private ColorService colorService;


    @GetMapping("/listar")
    public List<Color> getColor(){
        List<Color> color= colorService.getAll();
        return color;
    }

    @GetMapping()
    public Color getColorById(@RequestParam Integer id){
        Color color= colorService.getById(id);
        return color;
    }

    @GetMapping("/{id}")
    public Color getColorByIdPath(@PathVariable Integer id){
        Color cliente= colorService.getById(id);
        return cliente;
    }

    @PostMapping()
    public Color guardarColor(@RequestBody Color color){
        Color colorGuardar = colorService.guardar(color);
        return colorGuardar;
    }

    @DeleteMapping()
    public String eliminarColor(@RequestParam Integer id){
        Color color = colorService.getById(id);
        String mensaje = "";
        if (color == null) {
            mensaje = "El perfil con el id indicado no existe ";
        }
        try {
            colorService.eliminar(id);
            color = colorService.getById(id);
            if (color != null) {
                mensaje = ("No se ha podido eliminar el catalogo");
            }
        } catch (Exception e) {
            mensaje = "No se ha podido eliminar el catalogo";
        }
        return mensaje;
    }
}
