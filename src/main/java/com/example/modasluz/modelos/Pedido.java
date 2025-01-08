package com.example.modasluz.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pedido", schema = "modasluz", catalog = "postgres")
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
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pago", referencedColumnName = "id", nullable = false)
    private TipoPago tipo_pago;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Set<RegistroVenta> registros = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
