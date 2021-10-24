package com.salesianostriana.dam.Apartado1.Services;

import com.salesianostriana.dam.Apartado1.Model.Producto;
import com.salesianostriana.dam.Apartado1.Repos.ProductoRepository;
import com.salesianostriana.dam.Apartado1.Services.Base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ProductoService extends BaseService<Producto, Long, ProductoRepository> {
}
