package com.example.modasluz.controladores;

import com.example.modasluz.dto.CatalogoDTO;
import com.example.modasluz.mappers.CatalogoMapper;
import com.example.modasluz.modelos.Catalogo;
import org.springframework.web.bind.annotation.*;
import com.example.modasluz.services.CatalogoService;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/catalogo")
@AllArgsConstructor
public class EjemplosUsosController {

    private CatalogoService catalogoService;

    private CatalogoMapper catalogoMapper;

    // Metodo del ejercicio 1

    @GetMapping("/listar")
    public List<CatalogoDTO> getCatalogo() {
        return catalogoService.getAllDTO();
    }

    // ------------------------------------------------------------------------------------ //


    @GetMapping("/all")
    public List<Catalogo> getCatalogoNormal() {
        return catalogoService.getAll();
    }

    @GetMapping()
    public CatalogoDTO getCatalogoById(@RequestParam Integer id) {
        return catalogoService.getById(id);
    }

    @GetMapping("/{id}")
    public CatalogoDTO getCatalogoByIdPath(@PathVariable Integer id) {
        return catalogoService.getById(id);
    }

    @PostMapping()
    public Catalogo guardar(@RequestBody CatalogoDTO catalogo) {
        return catalogoService.guardar(catalogo);
    }

    @DeleteMapping()
    public String eliminar(@RequestParam Integer id) {
        Catalogo catalogo = catalogoMapper.toEntity(catalogoService.getById(id));

        String mensaje = "";
        if (catalogo == null) {
            mensaje = "El perfil con el id indicado no existe ";
        }
        try {
            catalogoService.eliminar(id);
            catalogo = catalogoMapper.toEntity(catalogoService.getById(id));
            if (catalogo != null) {
                mensaje = ("No se ha podido eliminar el catalogo");
            }
        } catch (Exception e) {
            mensaje = "No se ha podido eliminar el catalogo";
        }
        return mensaje;
    }
}
