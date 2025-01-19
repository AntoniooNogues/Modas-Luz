package com.example.modasluz.services;


import com.example.modasluz.dto.PedidoDTO;
import com.example.modasluz.dto.RegistroVentaDTO;
import com.example.modasluz.mappers.Mappers;
import com.example.modasluz.mappers.PedidoMapper;
import com.example.modasluz.modelos.Pedido;
import com.example.modasluz.modelos.RegistroVenta;
import com.example.modasluz.repositorios.PedidoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Component
@Service
public class ClientePedidoService {

    @Autowired
    private RegistroVentaService registroVentaService;
    @Autowired
    private PedidoRepositorio pedidoRepositorio;
    @Autowired
    private Mappers mappers;

    @Transactional
    public Set<PedidoDTO> getPedidosByClienteId(Integer clienteId) {
        Set<Pedido> pedidos = pedidoRepositorio.findByClienteId(clienteId);
        Set<PedidoDTO> pedidosDTO = mappers.toDTO(pedidos);
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
