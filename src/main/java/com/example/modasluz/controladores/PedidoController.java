package com.example.modasluz.controladores;

import com.example.modasluz.dto.PedidoPersonalizadoDTO;
import com.example.modasluz.services.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
@AllArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;


@PostMapping()
  public String guardar(@RequestBody PedidoPersonalizadoDTO pedidoDTO)throws Exception {
        return pedidoService.crearPedidoPersonalizado(pedidoDTO);
    }
}
