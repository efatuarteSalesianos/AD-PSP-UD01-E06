package com.salesianostriana.dam.Apartado2.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
@Builder
public class Video implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer orden;
    private String titulo, descripcion, url;

    @ManyToOne
    private CursoOnline curso;

    /* MÉTODOS HELPERS */

    public void addCurso(CursoOnline c) {
        this.curso = c;
        c.getVideos().add(this);
    }

    public void deleteCurso(CursoOnline c) {
        c.getVideos().remove(this);
        this.curso = null;
    }
}
