package com.bdba.gestion_notas.controller;

import com.bdba.gestion_notas.exception.MateriaNotFoundException;
import com.bdba.gestion_notas.model.Alumno;
import com.bdba.gestion_notas.model.Materia;
import com.bdba.gestion_notas.model.request.CrearAlumnoRequest;
import com.bdba.gestion_notas.model.request.CrearMateriaRequest;
import com.bdba.gestion_notas.model.response.ApiResponse;
import com.bdba.gestion_notas.model.response.CrearMateriaResponse;
import com.bdba.gestion_notas.service.MateriaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    private final MateriaService materiaService;


    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Page<CrearMateriaResponse>>> listarMaterias(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        String path = "/materias";

        Page<CrearMateriaResponse> materia = materiaService.listarMatarias(page, size);
        return ResponseEntity.ok( new ApiResponse<>(
                200,
                "Materias consultadas satisfactoriamente.",
                materia
        ));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CrearMateriaResponse>> crearMateria (
            @Valid @RequestBody CrearMateriaRequest request) {
        CrearMateriaResponse materia = materiaService.crearMataria(request);
        return ResponseEntity.status(201).body(
                new ApiResponse<>(
                        201,
                        "Alumno created successfully",
                        materia
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CrearMateriaResponse>> actualizarAlumno(
            @PathVariable Long id,
            @Valid @RequestBody CrearMateriaRequest request) {

        CrearMateriaResponse materia = materiaService.actualizarMateria(id, request);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Materia updated successfully",
                        materia
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CrearMateriaResponse>> consultarMateria(@PathVariable Long id) {
        CrearMateriaResponse materia = materiaService.consultarMateria(id);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Alumno retrieved successfully",
                        materia
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminarAlumno(@PathVariable Long id) {
        try {
            materiaService.eliminarMateria(id);

            return ResponseEntity.ok(
                    new ApiResponse<>(
                            200,
                            "Materia con id " +  " eliminada satisfactoriamente.",
                            null
                    )
            );

        } catch (MateriaNotFoundException ex) {

            return ResponseEntity.status(404).body(
                    new ApiResponse<>(
                            404,
                            "Materia not found. Unable to delete",
                            null
                    )
            );
        }
    }
}
