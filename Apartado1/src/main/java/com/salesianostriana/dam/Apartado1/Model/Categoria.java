package com.salesianostriana.dam.Apartado1.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
@Builder(toBuilder = true)
public class Categoria implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany (mappedBy = "categoria")
    private List<Producto> productos;

    @OneToMany(mappedBy = "categoriaPadre", cascade = CascadeType.ALL)
    private List<Categoria> subCategorias;

    @ManyToOne
    private Categoria categoriaPadre;

    /* MÉTODOS HELPERS */

    public void addCategoriaPadre(Categoria c) {
        this.categoriaPadre = c;
        c.getSubCategorias().add(this);
    }

    public void deleteCategoriaPadre(Categoria c) {
        c.getSubCategorias().remove(this);
        this.categoriaPadre = null;
    }
}
