package com.example.modasluz.modelos;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

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

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_talla", referencedColumnName = "id", nullable = false)
    private Talla talla;

    @Column(name = "cantidad")
    private Integer cantidad;
}
