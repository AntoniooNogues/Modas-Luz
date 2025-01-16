package com.example.modasluz.services;


import com.example.modasluz.dto.PedidoDTO;
import com.example.modasluz.dto.RegistroVentaDTO;
import com.example.modasluz.mappers.PedidoMapper;
import com.example.modasluz.modelos.Pedido;
import com.example.modasluz.modelos.RegistroVenta;
import com.example.modasluz.repositorios.PedidoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class ClientePedidoService {

    private final RegistroVentaService registroVentaService;
    private final PedidoRepositorio pedidoRepositorio;
    private final PedidoMapper pedidoMapper;


    public Set<PedidoDTO> getPedidosByClienteId(Integer clienteId) {
        Set<Pedido> pedidos = pedidoRepositorio.findByClienteId(clienteId);
        Set<PedidoDTO> pedidosDTO = pedidoMapper.toDTO(pedidos);
        for (Pedido p : pedidos) {
            Set<RegistroVentaDTO> registrosDTO = registroVentaService.getRegistroVentaByPedidoId(p.getId());
            for (PedidoDTO pedidoDTO : pedidosDTO) {
                pedidoDTO.setRegistros(registrosDTO);
            }
        }
        return pedidosDTO;
    }

    public Integer obtenerUltimoPedidoId(){
        try{
            Pedido pedido =  pedidoRepositorio.findTopByOrderByIdDesc();
            Integer resultado = pedido.getId();
            return resultado+1;
        } catch (Exception e) {
            return 1;
        }
    }

}
