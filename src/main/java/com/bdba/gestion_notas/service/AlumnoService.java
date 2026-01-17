package com.bdba.gestion_notas.service;

import com.bdba.gestion_notas.model.Alumno;
import com.bdba.gestion_notas.model.request.CrearAlumnoRequest;
import com.bdba.gestion_notas.model.response.ApiResponse;
import com.bdba.gestion_notas.model.response.CrearAlumnoResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AlumnoService {

    CrearAlumnoResponse crearAlumno(CrearAlumnoRequest crearAlumnoRequest);

    Page<CrearAlumnoResponse> listarAlumnos(int page, int size);

    CrearAlumnoResponse consultarAlumno(Long id);

    CrearAlumnoResponse actualizarAlumno(Long id, CrearAlumnoRequest crearAlumnoRequest);

    void eliminarAlumno(Long id);
}
