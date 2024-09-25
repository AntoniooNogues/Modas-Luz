package com.example.modasluz.modelos;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "talla", schema = "modasLuz")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Talla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "tipo")
    private String tipo;

    @OneToMany(mappedBy = "talla", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TipoProductoPrecio> tipo_producto_precio = new HashSet<>();

    @OneToMany(mappedBy = "talla", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Stock> stock = new HashSet<>();
}
