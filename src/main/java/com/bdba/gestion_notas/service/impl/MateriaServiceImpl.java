package com.bdba.gestion_notas.service.impl;

import com.bdba.gestion_notas.exception.AlumnoNotFoundException;
import com.bdba.gestion_notas.exception.MateriaNotFoundException;
import com.bdba.gestion_notas.model.Materia;
import com.bdba.gestion_notas.model.request.CrearMateriaRequest;
import com.bdba.gestion_notas.model.response.CrearMateriaResponse;
import com.bdba.gestion_notas.repository.MateriaRepository;
import com.bdba.gestion_notas.service.MateriaService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MateriaServiceImpl implements MateriaService {

    private final MateriaRepository materiaRepository;
    private final ModelMapper modelMapper;

    public MateriaServiceImpl(MateriaRepository materiaRepository, ModelMapper modelMapper) {
        this.materiaRepository = materiaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CrearMateriaResponse crearMataria(CrearMateriaRequest crearMateriaRequest) {
        Materia materia = new Materia();
        materia.setNombre(crearMateriaRequest.getNombre());
        materia.setCodigo(crearMateriaRequest.getCodigo());
        materia.setCreditos(crearMateriaRequest.getCreditos());
        Materia response =  materiaRepository.save(materia);

        return modelMapper.map(response, CrearMateriaResponse.class);
    }

    @Override
    public Page<CrearMateriaResponse> listarMatarias(int page, int size) {
       Page<Materia> materia = materiaRepository.findAll(
                PageRequest.of(page, size, Sort.by("id").ascending()));

        return materia.map(m->modelMapper.map(m, CrearMateriaResponse.class));
    }

    @Override
    public CrearMateriaResponse consultarMateria(Long id) {

        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new MateriaNotFoundException(  "Merchant not found with id: " + id,
                        "MATERIA_NOT_FOUND" ));

        return modelMapper.map(materia, CrearMateriaResponse.class);
    }

    @Override
    public CrearMateriaResponse actualizarMateria(Long id, CrearMateriaRequest crearMateriaRequest) {

        Materia materia = materiaRepository.findById(id).orElseThrow(() -> new MateriaNotFoundException(
                "No se encontró la Materia con id: " + id,
                "MATERIA_NOT_FOUND"
        ));

        materia.setCodigo(crearMateriaRequest.getCodigo());
        materia.setNombre(crearMateriaRequest.getNombre());
        materia.setCreditos(crearMateriaRequest.getCreditos());

        return modelMapper.map( materiaRepository.save(materia), CrearMateriaResponse.class);
    }

    @Override
    public void eliminarMateria(Long id) {
        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new MateriaNotFoundException(
                "No se encontró la Materia con id: " + id,
                "MATERIA_NOT_FOUND"
        ));
        materiaRepository.deleteById(id);
    }
}
