package com.salesianostriana.dam.Apartado1.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder(toBuilder = true)
public class Categoria implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // En este caso es mejor que sea unidireccional, por lo que este atributo no existiría
    @OneToMany (mappedBy = "categoria")
    private List<Producto> productos;

    // Mejor poner un cascade solo para el borrado
    @OneToMany(mappedBy = "categoriaPadre", cascade = CascadeType.REMOVE)
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
