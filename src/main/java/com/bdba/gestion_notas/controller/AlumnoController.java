package com.bdba.gestion_notas.controller;

import com.bdba.gestion_notas.exception.AlumnoNotFoundException;
import com.bdba.gestion_notas.model.Alumno;
import com.bdba.gestion_notas.model.enums.ApiStatus;
import com.bdba.gestion_notas.model.request.CrearAlumnoRequest;
import com.bdba.gestion_notas.model.response.ApiResponse;
import com.bdba.gestion_notas.model.response.CrearAlumnoResponse;
import com.bdba.gestion_notas.service.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<CrearAlumnoResponse>>> listarAlumnos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<CrearAlumnoResponse> alumnos = alumnoService.listarAlumnos(page, size);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        ApiStatus.OK.getCode(),
                        ApiStatus.OK.getMessage(),
                        alumnos
                )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CrearAlumnoResponse>> crearAlumno(
            @Valid @RequestBody CrearAlumnoRequest request) {

        CrearAlumnoResponse alumno = alumnoService.crearAlumno(request);

        return ResponseEntity.status(201).body(
                new ApiResponse<>(
                        ApiStatus.OK.getCode(),
                        ApiStatus.OK.getMessage(),
                        alumno
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CrearAlumnoResponse>> consultarAlumno(@PathVariable Long id) {

        CrearAlumnoResponse alumno = alumnoService.consultarAlumno(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        ApiStatus.OK.getCode(),
                        ApiStatus.OK.getMessage(),
                        alumno
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CrearAlumnoResponse>> actualizarAlumno(
            @PathVariable Long id,
            @Valid @RequestBody CrearAlumnoRequest request) {

        CrearAlumnoResponse alumno = alumnoService.actualizarAlumno(id, request);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        ApiStatus.OK.getCode(),
                        ApiStatus.OK.getMessage(),
                        alumno
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminarAlumno(@PathVariable Long id) {

        try {
            alumnoService.eliminarAlumno(id);

            return ResponseEntity.ok(
                    new ApiResponse<>(
                            ApiStatus.OK.getCode(),
                            ApiStatus.OK.getMessage(),
                            null
                    )
            );

        } catch (AlumnoNotFoundException ex) {

            return ResponseEntity.status(404).body(
                    new ApiResponse<>(
                            ApiStatus.NOT_FOUND.getCode(),
                            ApiStatus.OK.getMessage(),
                            null
                    )
            );
        }
    }
}
