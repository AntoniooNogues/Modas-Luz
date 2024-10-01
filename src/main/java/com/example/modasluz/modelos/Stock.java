package com.example.modasluz.modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stock", schema = "modasluz", catalog = "postgres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", referencedColumnName = "id", nullable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_talla", referencedColumnName = "id", nullable = false)
    private Talla talla;

    @Column(name = "cantidad")
    private Integer cantidad;
}
