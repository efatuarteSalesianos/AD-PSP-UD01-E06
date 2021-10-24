package com.salesianostriana.dam.Apartado1.Services;

import com.salesianostriana.dam.Apartado1.Model.Categoria;
import com.salesianostriana.dam.Apartado1.Repos.CategoriaRepository;
import com.salesianostriana.dam.Apartado1.Services.Base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends BaseService<Categoria, Long, CategoriaRepository> {
}
