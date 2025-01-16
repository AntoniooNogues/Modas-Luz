package com.example.modasluz.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pedido", schema = "modasluz")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_cliente",referencedColumnName = "id", nullable = false)
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pago", referencedColumnName = "id", nullable = false)
    private TipoPago tipo_pago;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "codigo", nullable = false)
    private String codigo;

}
