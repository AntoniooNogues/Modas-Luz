package com.example.modasluz.controladores;

import com.example.modasluz.services.CatalogoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/disponibilidad")
@AllArgsConstructor
public class CatalogoController {

    private CatalogoService catalogoService;


    @GetMapping("/{id}/{talla}")
    public Object consultarDisponibilidad(@PathVariable  Integer id,@PathVariable String talla) {
        return catalogoService.consultarDisponibilidad(id, talla);
    }

    @GetMapping("/consultar")
    public Object disponibilidad(@RequestParam Integer id, @RequestParam String talla) {
        return catalogoService.consultarDisponibilidad(id, talla);
    }
}