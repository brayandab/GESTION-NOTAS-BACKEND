package com.bdba.gestion_notas.model.response;

import com.bdba.gestion_notas.model.Materia;

import java.util.Date;
import java.util.List;

public class CrearAlumnoResponse {

    private  Long id;

    private String nombre;

    private String apellido;

    private String correo;

    private Date fechaNacimiento;

    private List<CrearMateriaResponse> materias;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public List<CrearMateriaResponse> getMaterias() {
        return materias;
    }

    public void setMaterias(List<CrearMateriaResponse> materias) {
        this.materias = materias;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }



}
