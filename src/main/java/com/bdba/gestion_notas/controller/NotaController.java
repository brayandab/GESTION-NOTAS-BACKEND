package com.bdba.gestion_notas.controller;

import com.bdba.gestion_notas.model.request.CrearNotaRequest;
import com.bdba.gestion_notas.model.response.ApiResponse;
import com.bdba.gestion_notas.model.response.CrearAlumnoResponse;
import com.bdba.gestion_notas.model.response.CrearNotaResponse;
import com.bdba.gestion_notas.service.NotaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaService  notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Page<CrearNotaResponse>>> listarMaterias(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        String path = "/notas";

        Page<CrearNotaResponse> notas = notaService.listarNota(page, size);
        return ResponseEntity.ok( new ApiResponse<>(
                200,
                "Notas consultadas satisfactoriamente.",
                notas
        ));
    }

    @GetMapping("/alumno/{id}")
    public ResponseEntity<ApiResponse<CrearAlumnoResponse>> consultarAlumno(@PathVariable Long id) throws JsonProcessingException {

        CrearAlumnoResponse alumno = notaService.consultarNotasPorAlumno    (id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Alumno retrieved successfully",
                        alumno
                )
        );
    }


    @PostMapping
    public ResponseEntity<ApiResponse<CrearNotaResponse>> crearNota (
            @Valid @RequestBody CrearNotaRequest request) {
        CrearNotaResponse nota = notaService.crearNota(request);
        return ResponseEntity.status(201).body(
                new ApiResponse<>(
                        201,
                        "Alumno created successfully",
                        nota
                )
        );
    }


}
