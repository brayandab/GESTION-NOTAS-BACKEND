package com.bdba.gestion_notas.model.response;

import com.bdba.gestion_notas.model.Nota;

import java.util.List;

public class CrearMateriaResponse {

    private Long id;
    private String nombre;
    private String codigo;
    private int creditos;
    private List<CrearNotaResponse> notas;


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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public List<CrearNotaResponse> getNotas() {
        return notas;
    }

    public void setNotas(List<CrearNotaResponse> notas) {
        this.notas = notas;
    }
}
