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
public class Grupo {
    
    private String id;
    private String nomGrupo;
    private String semillero;
    private String clasificacion;
    
    public Grupo (){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomGrupo() {
        return nomGrupo;
    }

    public void setNomGrupo(String nomGrupo) {
        this.nomGrupo = nomGrupo;
    }

    public String getSemillero() {
        return semillero;
    }

    public void setSemillero(String semillero) {
        this.semillero = semillero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    
    
    
}
