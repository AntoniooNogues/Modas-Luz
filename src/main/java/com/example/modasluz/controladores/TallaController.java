package com.example.modasluz.controladores;

import com.example.modasluz.modelos.Color;
import com.example.modasluz.modelos.Talla;
import com.example.modasluz.services.ColorService;
import com.example.modasluz.services.TallaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/talla")
@AllArgsConstructor
public class TallaController {

    private TallaService tallaService;


    @GetMapping("/listar")
    public List<Talla> getColor(){
        List<Talla> talla= tallaService.getAll();
        return talla;
    }

    @GetMapping()
    public Talla getColorById(@RequestParam Integer id){
        Talla talla= tallaService.getById(id);
        return talla;
    }

    @GetMapping("/{id}")
    public Talla getColorByIdPath(@PathVariable Integer id){
        Talla talla= tallaService.getById(id);
        return talla;
    }

    @PostMapping()
    public Talla guardarColor(@RequestBody Talla talla){
        Talla tallaGuardar = tallaService.guardar(talla);
        return tallaGuardar;
    }

    @DeleteMapping()
    public String eliminarColor(@RequestParam Integer id) {
        Talla talla = tallaService.getById(id);
        String mensaje = "";
        if (talla == null) {
            mensaje = "El perfil con el id indicado no existe ";
        }
        try {
            tallaService.eliminar(id);
            talla = tallaService.getById(id);
            if (talla != null) {
                mensaje = ("No se ha podido eliminar el catalogo");
            }
        } catch (Exception e) {
            mensaje = "No se ha podido eliminar el catalogo";
        }
        return mensaje;
    }
}
