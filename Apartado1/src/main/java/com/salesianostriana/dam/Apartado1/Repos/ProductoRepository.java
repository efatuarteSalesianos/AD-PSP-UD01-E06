package com.salesianostriana.dam.Apartado1.Repos;

import com.salesianostriana.dam.Apartado1.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
