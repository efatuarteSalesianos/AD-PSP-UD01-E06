package com.salesianostriana.dam.Apartado2.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
@Builder
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private Double puntuacion;

    @OneToMany(mappedBy = "profesor")
    private List<CursoOnline> cursos = new ArrayList<>();
}
