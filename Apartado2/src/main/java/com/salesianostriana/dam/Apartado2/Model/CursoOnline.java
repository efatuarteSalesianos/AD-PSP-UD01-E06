package com.salesianostriana.dam.Apartado2.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class CursoOnline implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double puntuacion;

    @ManyToOne
    private Profesor profesor;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Video> videos = new ArrayList<>();

    /* MÉTODOS HELPERS */

    public void addProfesor(Profesor p) {
        this.profesor = p;
        p.getCursos().add(this);
    }

    public void deleteProfesor(Profesor p) {
        p.getCursos().remove(this);
        this.profesor = null;
    }

}
