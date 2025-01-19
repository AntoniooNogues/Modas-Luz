package com.example.modasluz.modelos;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "talla", schema = "modasluz")
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


}
