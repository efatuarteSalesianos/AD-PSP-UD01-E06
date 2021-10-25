package com.salesianostriana.dam.Apartado1;

import com.salesianostriana.dam.Apartado1.Model.Categoria;
import com.salesianostriana.dam.Apartado1.Model.Producto;
import com.salesianostriana.dam.Apartado1.Services.CategoriaService;
import com.salesianostriana.dam.Apartado1.Services.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class MainDePrueba {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    @PostConstruct
    public void initData() {

        Categoria bebidas = Categoria.builder()
                .nombre("Bebidas")
                .productos(new ArrayList<>())
                .build();
        Categoria limpieza = Categoria.builder()
                .nombre("Limpieza")
                .productos(new ArrayList<>())
                .build();
        categoriaService.save(bebidas);
        categoriaService.save(limpieza);

        Producto agua = Producto.builder()
                .nombre("Botella de agua 1.5L")
                .pvp(0.70)
                .build();
        Producto vino = Producto.builder()
                .nombre("Botella de vino tinto 0.75L")
                .pvp(12.50)
                .build();
        Producto cerveza = Producto.builder()
                .nombre("Lata de cerveza Cruzcampo 0.33L")
                .pvp(0.80)
                .build();
        Producto trapo = Producto.builder()
                .nombre("Trapo de cocina")
                .pvp(1.99)
                .build();

        agua.addCategoria(bebidas);
        vino.addCategoria(bebidas);
        cerveza.addCategoria(bebidas);
        trapo.addCategoria(limpieza);

        productoService.save(agua);
        productoService.save(vino);
        productoService.save(cerveza);
        productoService.save(trapo);

        System.out.printf("%s, %s\n", agua.getNombre(), agua.getCategoria().getNombre());
        System.out.printf("%s, %s\n", vino.getNombre(), vino.getCategoria().getNombre());
        System.out.printf("%s, %s\n", cerveza.getNombre(), cerveza.getCategoria().getNombre());
        System.out.printf("%s, %s\n", trapo.getNombre(), trapo.getCategoria().getNombre());

        System.out.println("\nN de bebidas:" + bebidas.getProductos().size());
        System.out.println("N de productos de limpieza:" + limpieza.getProductos().size());

        System.out.println("**Elimino la categoria de la botella de agua**");
        agua.deleteCategoria(bebidas);
        productoService.save(agua);

        System.out.printf("%s, %s\n", agua.getNombre(), agua.getCategoria() != null ? agua.getCategoria().getNombre() : "Sin Categoria");
        System.out.printf("%s, %s\n", vino.getNombre(), vino.getCategoria().getNombre());
        System.out.printf("%s, %s\n", cerveza.getNombre(), cerveza.getCategoria().getNombre());
        System.out.println("N de bebidas:" + bebidas.getProductos().size());
    }
}
