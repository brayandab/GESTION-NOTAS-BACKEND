package com.bdba.gestion_notas.service;

import com.bdba.gestion_notas.model.Alumno;
import com.bdba.gestion_notas.model.Materia;
import com.bdba.gestion_notas.model.request.CrearMateriaRequest;
import com.bdba.gestion_notas.model.response.CrearMateriaResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MateriaService {
    CrearMateriaResponse crearMataria(CrearMateriaRequest crearMateriaRequest);

    Page<CrearMateriaResponse> listarMatarias(int page, int size);

    CrearMateriaResponse consultarMateria(Long id);

    CrearMateriaResponse actualizarMateria(Long id, CrearMateriaRequest crearMateriaRequest);

    void eliminarMateria(Long id);
}
