package com.example.modasluz.modelos;

import jakarta.persistence.*;
import lombok.*;
import java.util.Objects;

@Entity
@Table(name = "registro_venta", schema = "modasluz")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class RegistroVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id")
    private Pedido pedido;

    @ManyToOne()
    @JoinColumn(name = "id_producto", referencedColumnName = "id", nullable = false)
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    // Esto se calcula mediante la cantidad x precio (tipo_producto_precio).
    @Column(name = "precio_venta", nullable = false)
    private Double precio_venta;

}
