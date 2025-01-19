package com.example.modasluz;

import com.example.modasluz.dto.PedidoDTO;
import com.example.modasluz.dto.UsuarioDTOPedidos;
import com.example.modasluz.enums.EstatusPago;
import com.example.modasluz.enums.MetodoPago;
import com.example.modasluz.enums.Rol;
import com.example.modasluz.mappers.Mappers;
import com.example.modasluz.modelos.Pedido;
import com.example.modasluz.modelos.TipoPago;
import com.example.modasluz.modelos.Usuario;
import com.example.modasluz.repositorios.PedidoRepositorio;
import com.example.modasluz.repositorios.TipoPagoRepositorio;
import com.example.modasluz.repositorios.UsuarioRepositorio;
import com.example.modasluz.services.ClientePedidoService;
import com.example.modasluz.services.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteIntegracionTest {

    @Mock
    private UsuarioRepositorio usuarioRepositorio;

    @Mock
    private PedidoRepositorio pedidoRepositorio;

    @Mock
    private ClientePedidoService clientePedidoService;

    @Mock
    private Mappers mappers;

    @InjectMocks
    private UsuarioService usuarioService;

    private Usuario usuario;
    private Pedido pedido1;
    private Pedido pedido2;
    private Set<PedidoDTO> pedidosDTO;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario(1, "Juan", "Perez García", "Juanpe", Rol.CLIENTE, "juanpe@gmail.com", "12345678A", "Aragon", 31045);
        TipoPago tipoPago = new TipoPago(1, MetodoPago.EFECTIVO, EstatusPago.PAGADO, "123456789");
        pedido1 = new Pedido(1, usuario, tipoPago, LocalDate.now(), "123456789");
        pedido2 = new Pedido(2, usuario, tipoPago, LocalDate.now().minusMonths(2), "987654321");
        pedidosDTO = new HashSet<>();
    }

    @Test
    public void testEliminarUsuarioPositivo() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId(1);
        when(usuarioRepositorio.findById(1)).thenReturn(Optional.of(usuario));

        String resultado = usuarioService.eliminar(1);
        assertEquals("Cliente eliminado correctamente", resultado);
        verify(usuarioRepositorio, times(1)).deleteById(1);
    }

    @Test
    public void testGetPedidosDeCliente() throws Exception {
        when(usuarioRepositorio.findById(1)).thenReturn(Optional.of(usuario));
        when(clientePedidoService.getPedidosByClienteId(1)).thenReturn(pedidosDTO);

        PedidoDTO pedidoDTO1 = new PedidoDTO();
        pedidoDTO1.setFecha(LocalDate.now());
        pedidoDTO1.setCodigo("123456789");
        PedidoDTO pedidoDTO2 = new PedidoDTO();
        pedidoDTO2.setFecha(LocalDate.now().minusMonths(2));
        pedidoDTO2.setCodigo("987654321");
        pedidosDTO.add(pedidoDTO1);
        pedidosDTO.add(pedidoDTO2);

        UsuarioDTOPedidos usuarioDTOPedidos = new UsuarioDTOPedidos();
        usuarioDTOPedidos.setNombre("Juan");
        usuarioDTOPedidos.setApellidos("Perez García");
        usuarioDTOPedidos.setDni("12345678A");
        usuarioDTOPedidos.setCorreo_electronico("juanpe@gmail.com");
        usuarioDTOPedidos.setPedidosDTO(pedidosDTO);

        when(mappers.toDTO(any(Optional.class))).thenReturn(usuarioDTOPedidos);

        UsuarioDTOPedidos result = usuarioService.getPedidosDeCliente(1);

        assertNotNull(result);
        assertEquals("Juan", result.getNombre());
        assertEquals("Perez García", result.getApellidos());
        assertEquals("12345678A", result.getDni());
        assertEquals("juanpe@gmail.com", result.getCorreo_electronico());
        assertEquals(2, result.getPedidosDTO().size());
        verify(usuarioRepositorio, times(1)).findById(1);
        verify(clientePedidoService, times(1)).getPedidosByClienteId(1);
    }

}