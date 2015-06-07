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
public class Articulo {
    
    private String id;
    private String titulo;
    private String año;
    private String pagInicio;
    private String pagFin;
    private String revista;
    private String issn;
    private String idioma;
    private String volumen;
    private String pais;
    private String medio;
    
    public Articulo(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getPagInicio() {
        return pagInicio;
    }

    public void setPagInicio(String pagInicio) {
        this.pagInicio = pagInicio;
    }

    public String getPagFin() {
        return pagFin;
    }

    public void setPagFin(String pagFin) {
        this.pagFin = pagFin;
    }

    public String getRevista() {
        return revista;
    }

    public void setRevista(String revista) {
        this.revista = revista;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }
    
    
}
