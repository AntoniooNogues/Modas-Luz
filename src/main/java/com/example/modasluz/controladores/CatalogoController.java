package com.example.modasluz.controladores;

import com.example.modasluz.dto.CatalogoDTO;
import com.example.modasluz.services.CatalogoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/disponibilidad")
@AllArgsConstructor
public class CatalogoController {

    private CatalogoService catalogoService;


    @GetMapping("/{id}/{talla}")
    public CatalogoDTO consultarDisponibilidad(@PathVariable  Integer id, @PathVariable String talla) throws Exception {
        return catalogoService.consultarDisponibilidad(id, talla);
    }

    @GetMapping("/consultar")
    public CatalogoDTO disponibilidad(@RequestParam Integer id, @RequestParam String talla) throws Exception {
        return catalogoService.consultarDisponibilidad(id, talla);
    }
}