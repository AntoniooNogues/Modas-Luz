package com.example.modasluz.modelos;
import com.example.modasluz.enums.Rol;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Table(name = "usuario", schema = "modasluz")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Usuario  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "rol", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Rol rol;

    @Column(name = "correo_electronico", nullable = false)
    private String correo_electronico;

    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "codigo_postal")
    private Integer codigo_postal;

    /*@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Pedido> pedidos;*/

}
