package com.example.modasluz.modelos;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "tipo_producto_precio", schema = "modasluz", catalog = "postgres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TipoProductoPrecio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_talla", referencedColumnName = "id",  nullable = false)
    private Talla talla;

    @ManyToOne
    @JoinColumn(name = "id_color", referencedColumnName = "id", nullable = false)
    private Color color;

    @Column(name = "precio", nullable = false)
    private Double precio;
}
