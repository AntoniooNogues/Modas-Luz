package com.example.modasluz;

import com.example.modasluz.enums.EstatusPago;
import com.example.modasluz.enums.MetodoPago;
import com.example.modasluz.modelos.Talla;
import com.example.modasluz.modelos.TipoPago;
import com.example.modasluz.services.TallaService;
import com.example.modasluz.services.TipoPagoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TipoPagoTest {

    @Autowired
    private TipoPagoService tipoPagoService;

    @Test
    public void verTipoPago() {
        for (TipoPago t: tipoPagoService.getAll()) {
            System.out.println(t);
        }
    }

    @Test
    public void agregarTipoPago() {
        TipoPago t = new TipoPago();
        t.setId(4);
        t.setEstatus_pago(EstatusPago.PAGADO);
        t.setMetodo_pago(MetodoPago.EFECTIVO);
        t.setDetalles_efectivo("Pagado en efectivo, 2024-02-10");
        t.setReferencia_pago("REF54109");
        tipoPagoService.guardar(t);
        System.out.println("Nuevo TipoPago agregado");
    }

    @Test
    public void verTipoPagoPorId() {
        System.out.println(tipoPagoService.getById(4));
    }

    @Test
    public void eliminarTipoPago() {
        tipoPagoService.eliminar(4);
        System.out.println("TipoPago eliminado");
    }
}
