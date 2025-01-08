package com.example.modasluz.services;

import com.example.modasluz.dto.PedidoPersonalizadoDTO;
import com.example.modasluz.modelos.Pedido;
import com.example.modasluz.modelos.RegistroVenta;
import com.example.modasluz.repositorios.PedidoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PedidoService {

    private final ProductoService productoService;
    private final TipoPagoService tipoPagoService;
   @Autowired
    @Lazy
    private UsuarioService usuarioService;
    private RegistroVentaService registroVentaService;
    private PedidoRepositorio pedidoRepositorio;
    @Autowired
    private ClientePedidoService clientePedidoService;


    public Pedido guardar (Pedido pedido){
        return pedidoRepositorio.save(pedido);
    }

    public void eliminar (Integer id){
        pedidoRepositorio.deleteById(id);
    }

    public List<Pedido> getAll(){
        return pedidoRepositorio.findAll();
    }

    public Pedido getById(Integer id){
        return pedidoRepositorio.findById(id).orElse(null);
    }

    public String crearPedidoPersonalizado(PedidoPersonalizadoDTO pedidoPersonalizadoDTO){
        try {
            Pedido pedido = new Pedido();
            pedido.setUsuario(usuarioService.getByIdCliente(pedidoPersonalizadoDTO.getId_cliente()));
            pedido.setTipo_pago(tipoPagoService.getById(pedidoPersonalizadoDTO.getId_tipo_pago()));
            pedido.setFecha(pedidoPersonalizadoDTO.getFecha());
            pedido.setCodigo("PED" + clientePedidoService.obtenerUltimoPedidoId());
            guardar(pedido);

            for (int i = 0; i < pedidoPersonalizadoDTO.getProductos().size(); i++) {
                RegistroVenta registro = new RegistroVenta();
                registro.setPedido(pedido);
                registro.setProducto(productoService.getByIdNormal(pedidoPersonalizadoDTO.getProductos().get(i)));
                registro.setCantidad(pedidoPersonalizadoDTO.getCantidades().get(i));
                registro.setPedido(pedido);
                registro = registroVentaService.calcularPrecioVenta(registro);
                registroVentaService.guardar(registro);
            }
            pedido.setCodigo("PED" + pedido.getId());
            guardar(pedido);
            return "Pedido creado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error a la hora de crear un pedido";
        }
    }
}
