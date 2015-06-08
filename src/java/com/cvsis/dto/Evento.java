/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvsis.dto;

/**
 *
 * @author Manuel
 */
public class Evento {
    
    private String id;
    private String ambito;
    private String nombre;
    private String fechaIni;
    private String fechaFin;
    private String institucion;
    private String lugar;
    private String tipo;
    private String vinculacion;
    
    public Evento (){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getVinculacion() {
        return vinculacion;
    }

    public void setVinculacion(String vinculacion) {
        this.vinculacion = vinculacion;
    }
    
    
    
}
