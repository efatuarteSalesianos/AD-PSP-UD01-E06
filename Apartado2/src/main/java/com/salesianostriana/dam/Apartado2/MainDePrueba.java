package com.salesianostriana.dam.Apartado2;

import com.salesianostriana.dam.Apartado2.Model.CursoOnline;
import com.salesianostriana.dam.Apartado2.Model.Profesor;
import com.salesianostriana.dam.Apartado2.Model.Video;
import com.salesianostriana.dam.Apartado2.Services.CursoOnlineService;
import com.salesianostriana.dam.Apartado2.Services.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDePrueba {

    private final ProfesorService profesorService;
    private final CursoOnlineService cursoService;

    @PostConstruct
    public void initData() {

        Profesor p1 = Profesor.builder()
                .nombre("Luismi")
                .email("luismi.lopez@salesianos.edu")
                .puntuacion(9.5)
                .cursos(new ArrayList<>())
                .build();
        profesorService.save(p1);

        CursoOnline c1 = CursoOnline.builder()
                .nombre("Curso Spring JPA")
                .puntuacion(10.0)
                .videos(new ArrayList<>())
                .build();

        c1.addProfesor(p1);

        Video v1 = Video.builder()
                .orden(1)
                .titulo("Introducción a JPA")
                .descripcion("Bienvenidos al curso de spring JPA")
                .url("https://www.youtube.com/ow/curso/spring-jpa/introduccion-spring-jpa")
                .build();
        Video v2 = Video.builder()
                .orden(1)
                .titulo("Fetching con Spring")
                .descripcion("Aprendiendo tipos de fetching con spring")
                .url("https://www.youtube.com/ow/curso/spring-jpa/fetching-en-spring")
                .build();

        v1.addCurso(c1);
        v2.addCurso(c1);

        cursoService.save(c1);

        List<CursoOnline> cursos = cursoService.findAll();
        System.out.println("\n");
        for(CursoOnline c : cursos) {
            System.out.println("Curso: " + c);
            System.out.println("Videos: " + c.getVideos());
        }

    }
}
