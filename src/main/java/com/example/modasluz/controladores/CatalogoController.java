package com.example.modasluz.controladores;

import com.example.modasluz.dto.CatalogoDTO;
import org.springframework.web.bind.annotation.*;
import com.example.modasluz.modelos.Catalogo;
import com.example.modasluz.services.CatalogoService;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/catalogo")
@AllArgsConstructor
public class CatalogoController {

    private CatalogoService catalogoService;

    @GetMapping("/listar")
    public List<CatalogoDTO> getCatalogo(){
        List<CatalogoDTO> lista= catalogoService.getAll();
        return lista;
    }

    @GetMapping()
    public CatalogoDTO getCatalogoById(@RequestParam Integer id){
        CatalogoDTO catalogo= catalogoService.getById(id);
        return catalogo;
    }

    @GetMapping("/{id}")
    public CatalogoDTO getCatalogoByIdPath(@PathVariable Integer id){
        CatalogoDTO catalogo= catalogoService.getById(id);
        return catalogo;
    }

    @PostMapping()
    public Catalogo guardar(@RequestBody CatalogoDTO catalogo){
        Catalogo catalogoGuardado = catalogoService.guardar(catalogo);
        return catalogoGuardado;
    }

    @DeleteMapping()
    public String eliminar(@RequestParam Integer id){
        CatalogoDTO catalogoDTO = catalogoService.getById(id);
        String mensaje = "";
        if (catalogoDTO == null) {
            mensaje = "El perfil con el id indicado no existe ";
        }
        try {
            catalogoService.eliminar(id);
            catalogoDTO = catalogoService.getById(id);
            if (catalogoDTO != null) {
                mensaje = ("No se ha podido eliminar el catalogo");
            }
        } catch (Exception e) {
            mensaje = "No se ha podido eliminar el catalogo";
        }
        return mensaje;
    }
}
