package com.bdba.gestion_notas.service.impl;

import com.bdba.gestion_notas.exception.AlumnoNotFoundException;
import com.bdba.gestion_notas.exception.MateriaNotFoundException;
import com.bdba.gestion_notas.model.Alumno;
import com.bdba.gestion_notas.model.Materia;
import com.bdba.gestion_notas.model.Nota;
import com.bdba.gestion_notas.model.request.CrearNotaRequest;
import com.bdba.gestion_notas.model.response.CrearAlumnoResponse;
import com.bdba.gestion_notas.model.response.CrearMateriaResponse;
import com.bdba.gestion_notas.model.response.CrearNotaResponse;
import com.bdba.gestion_notas.repository.AlumnoRepository;
import com.bdba.gestion_notas.repository.MateriaRepository;
import com.bdba.gestion_notas.repository.NotaRepository;
import com.bdba.gestion_notas.service.NotaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NotaServiceImpl implements NotaService {

    private final AlumnoRepository alumnoRepository;
    private final MateriaRepository materiaRepository;
    private final NotaRepository notaRepository;
    private final ModelMapper modelMapper;

    public NotaServiceImpl(AlumnoRepository alumnoRepository, MateriaRepository materiaRepository, NotaRepository notaRepository, ModelMapper modelMapper) {
        this.alumnoRepository = alumnoRepository;
        this.materiaRepository = materiaRepository;
        this.notaRepository = notaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CrearNotaResponse crearNota(CrearNotaRequest crearNotaRequest) {

        Alumno alumno = alumnoRepository.findById(crearNotaRequest.getAlumnoId())
                .orElseThrow(() -> new AlumnoNotFoundException(
                        "Alumno not found with id: " + crearNotaRequest.getAlumnoId(),"ALUMNO_NOT_FOUND"
                ));

        Materia materia = materiaRepository.findById(crearNotaRequest.getMateriaId())
                .orElseThrow(() -> new MateriaNotFoundException(
                        "Materia not found with id: " + crearNotaRequest.getMateriaId(),"MATRIA_NOT_FOUND"
                ));

        Nota nota = new Nota();
        nota.setAlumno(alumno);
        nota.setMateria(materia);
        nota.setValor(crearNotaRequest.getValor());
        nota.setFechaRegistro(new Date());

        return modelMapper.map(notaRepository.save(nota), CrearNotaResponse.class);
    }

    @Override
    public Page<CrearNotaResponse> listarNota(int page, int size) {

        Page<Nota> notas = notaRepository.findAll(
                PageRequest.of(page, size, Sort.by("id").ascending()));

        return notas.map(m->modelMapper.map(m, CrearNotaResponse.class));
    }

    @Override
    public CrearAlumnoResponse consultarNotasPorAlumno(Long id) throws JsonProcessingException {

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

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(
                mapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(materias)
        );


        return response;
    }


}
