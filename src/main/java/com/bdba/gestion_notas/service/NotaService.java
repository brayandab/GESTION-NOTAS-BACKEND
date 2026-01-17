package com.bdba.gestion_notas.service;


import com.bdba.gestion_notas.model.Nota;
import com.bdba.gestion_notas.model.request.CrearNotaRequest;
import com.bdba.gestion_notas.model.response.CrearAlumnoResponse;
import com.bdba.gestion_notas.model.response.CrearNotaResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NotaService {
    CrearNotaResponse crearNota(CrearNotaRequest crearNotaRequest);

    Page<CrearNotaResponse> listarNota(int page, int size);

    CrearAlumnoResponse consultarNotasPorAlumno(Long id) throws JsonProcessingException;

}
