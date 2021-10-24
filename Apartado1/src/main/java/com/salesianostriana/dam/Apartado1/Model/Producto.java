package com.salesianostriana.dam.Apartado1.Model;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
@Builder(toBuilder = true)
public class Producto implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double pvp;

    @ManyToOne
    private Categoria categoria;

    /* MÉTODOS HELPERS */

    public void addCategoria(Categoria c) {
        this.categoria = c;
        c.getProductos().add(this);
    }

    public void deleteCategoria(Categoria c) {
        c.getProductos().remove(this);
        this.categoria = null;
    }
}
