package com.example.modasluz.controladores;

import com.example.modasluz.dto.CatalogoDTO;
import com.example.modasluz.dto.CatalogoPersonalizadoDTO;
import com.example.modasluz.services.CatalogoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
@AllArgsConstructor
public class StockModificarController {

    private final CatalogoService catalogoService;


@PostMapping("/modificar")
  public Object guardar(@RequestBody CatalogoPersonalizadoDTO catalogoPersonalizadoDTO) {
       return catalogoService.modificarStock(catalogoPersonalizadoDTO);
    }
}
