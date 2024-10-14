package com.example.modasluz.modelos;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "producto", schema = "modasluz", catalog = "postgres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_tipo_producto", nullable = false)
    private TipoProducto tipo_producto;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name= "imagen")
    private String imagen;


}
