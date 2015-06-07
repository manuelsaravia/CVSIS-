/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvsis.controller;
import com.cvsis.dto.*;
import com.cvsis.dao.DocenteDao;
/**
 *
 * @author Manuel
 */
public class AdministrarDocente {
    
    public AdministrarDocente(){}
    
    public String registrarMateria(Materia m, Docente d){
        DocenteDao dd = new DocenteDao();
        return dd.registrarMateria(m,d);
    }

    public String cargarMaterias(Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.cargarMaterias(d);
    }

    public String eliminarMateria(Materia m, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.eliminarMateria(m,d);
    }

    public String agregarTesis(Tesis t, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.agregarTesis(t,d);
    }

    public String cargarFormacion(Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.cargarFormacion(d);
    }

    public String eliminarTesis(Tesis t, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.eliminarTesis(t,d);
    }

    public String agregarGrupo(Grupo g, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.agregarGrupo(g,d);
    }

    public String cargarGrupos(Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.cargarGrupos(d);
    }

    public String eliminarGrupo(Grupo g, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.eliminarGrupo(g,d);
    }

    public String agregarArticulo(Articulo a, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.agregarArticulo(a,d);
    }

    public String cargarArticulos(Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.cargarArticulos(d);
    }

    public String eliminarArticulo(Articulo a, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.eliminarArticulo(a,d);
    }

    public String agregarLibro(Libro l, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.agregarLibro(l,d);
    }

    public String cargarLibros(Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.cargarLibros(d);
    }

    public String eliminarLibro(Libro l, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.eliminarLibro(l,d);
    }
    
    
}
