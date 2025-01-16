package com.example.modasluz.modelos;

import com.example.modasluz.enums.EstatusPago;
import com.example.modasluz.enums.MetodoPago;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_pago", schema = "modasluz")
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

    @Column(name = "tipo_metodo_pago", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private MetodoPago tipo_metodo_pago;

    @Column(name = "tipo_estatus_pago", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private EstatusPago tipo_estatus_pago;

    @Column(name = "referencia_pago")
    private String referencia_pago;




}
