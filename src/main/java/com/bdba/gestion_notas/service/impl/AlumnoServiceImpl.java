package com.bdba.gestion_notas.service.impl;

import com.bdba.gestion_notas.exception.AlumnoNotFoundException;
import com.bdba.gestion_notas.model.Alumno;
import com.bdba.gestion_notas.model.Materia;
import com.bdba.gestion_notas.model.Nota;
import com.bdba.gestion_notas.model.request.CrearAlumnoRequest;
import com.bdba.gestion_notas.model.response.CrearAlumnoResponse;
import com.bdba.gestion_notas.model.response.CrearMateriaResponse;
import com.bdba.gestion_notas.model.response.CrearNotaResponse;
import com.bdba.gestion_notas.repository.AlumnoRepository;
import com.bdba.gestion_notas.service.AlumnoService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final ModelMapper modelMapper;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository, ModelMapper modelMapper) {
        this.alumnoRepository = alumnoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CrearAlumnoResponse crearAlumno(CrearAlumnoRequest request) {
        Alumno alumno = modelMapper.map(request, Alumno.class);
        System.out.println("FECHA: "+ request.getFechaNacimiento());
        return modelMapper.map(alumnoRepository.save(alumno),CrearAlumnoResponse.class);
    }

    @Override
    public Page<CrearAlumnoResponse> listarAlumnos(int page, int size) {
        Page<Alumno> alumnos = alumnoRepository.findAll(
                PageRequest.of(page, size, Sort.by("id").descending())
        );
        return alumnos.map(a->modelMapper.map(a,CrearAlumnoResponse.class));
    }

    @Override
    public CrearAlumnoResponse consultarAlumno(Long id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new AlumnoNotFoundException(
                        "Alumno not found with id: " + id, HttpStatus.OK.name()
                ));

        CrearAlumnoResponse response = new CrearAlumnoResponse();
        response.setId(alumno.getId());
        response.setNombre(alumno.getNombre());
        response.setApellido(alumno.getApellido());
        response.setCorreo(alumno.getCorreo());
        response.setFechaNacimiento(alumno.getFechaNacimiento());

        Map<Materia, List<Nota>> notasPorMateria = alumno.getNotas()
                .stream()
                .collect(Collectors.groupingBy(Nota::getMateria));

        List<CrearMateriaResponse> materias = notasPorMateria.entrySet()
                .stream()
                .map(entry -> {
                    Materia materia = entry.getKey();
                    List<Nota> notas = entry.getValue();

                    CrearMateriaResponse materiaDTO = new CrearMateriaResponse();
                    materiaDTO.setId(materia.getId());
                    materiaDTO.setNombre(materia.getNombre());
                    materiaDTO.setCodigo(materia.getCodigo());

                    List<CrearNotaResponse> notaDTOs = notas.stream()
                            .map(nota -> {
                                CrearNotaResponse dto = new CrearNotaResponse();
                                dto.setId(nota.getId());
                                dto.setValor(nota.getValor());
                                dto.setFechaRegistro(nota.getFechaRegistro());
                                return dto;
                            })
                            .toList();

                    materiaDTO.setNotas(notaDTOs);
                    return materiaDTO;
                })
                .toList();

        response.setMaterias(materias);

        return response;
    }

    @Override
    public CrearAlumnoResponse actualizarAlumno(Long id, CrearAlumnoRequest request) {

        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new AlumnoNotFoundException(
                        "Alumno not found with id: " + id, HttpStatus.OK.name()
                ));

        alumno.setNombre(request.getNombre());
        alumno.setApellido(request.getApellido());
        alumno.setCorreo(request.getCorreo());
        alumno.setFechaNacimiento(request.getFechaNacimiento());

        return modelMapper.map( alumnoRepository.save(alumno), CrearAlumnoResponse.class);
    }

    @Override
    public void eliminarAlumno(Long id) {

        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new AlumnoNotFoundException(
                        "Alumno not found with id: " + id,
                        "ALUMNO_NOT_FOUND"
                ));

        alumnoRepository.delete(alumno);

    }
}