package com.example.modasluz.modelos;

import com.example.modasluz.enums.EstatusPago;
import com.example.modasluz.enums.MetodoPago;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_pago", schema = "modasLuz")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class TipoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "metodo_pago", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private MetodoPago metodo_pago;

    @Column(name = "detalles_efectivo")
    private String detalles_efectivo;

    @Column(name = "estatus_pago", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private EstatusPago estatus_pago;

    @Column(name = "referencia_pago")
    private String referencia_pago;

    @OneToMany(mappedBy = "tipo_pago", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Pedido> pedidos = new HashSet<>();


}
