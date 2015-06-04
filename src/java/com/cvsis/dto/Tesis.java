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
public class Tesis {
    
    private String id;
    private String tipoTesis;
    private String nomEstudiante;
    private int cedula;
    private String nomProyecto;
    private String tipoDeTesis;
    private String institucion;
    private String programa;
    private String estadoTesis;
    private String fechaIni;
    private String fechaFin;
    
    public Tesis(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoTesis() {
        return tipoTesis;
    }

    public void setTipoTesis(String tipoTesis) {
        this.tipoTesis = tipoTesis;
    }

    public String getNomEstudiante() {
        return nomEstudiante;
    }

    public void setNomEstudiante(String nomEstudiante) {
        this.nomEstudiante = nomEstudiante;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNomProyecto() {
        return nomProyecto;
    }

    public void setNomProyecto(String nomProyecto) {
        this.nomProyecto = nomProyecto;
    }

    public String getTipoDeTesis() {
        return tipoDeTesis;
    }

    public void setTipoDeTesis(String tipoDeTesis) {
        this.tipoDeTesis = tipoDeTesis;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getEstadoTesis() {
        return estadoTesis;
    }

    public void setEstadoTesis(String estadoTesis) {
        this.estadoTesis = estadoTesis;
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
    
    
}
