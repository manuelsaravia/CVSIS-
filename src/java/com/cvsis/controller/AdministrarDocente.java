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

    public String agregarEvento(Evento e, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.agregarEvento(e,d);
    }

    public String cargarEventos(Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.cargarEventos(d);
    }

    public String eliminarEvento(Evento e, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.eliminarEvento(e,d);
    }

    public String agregarSoftware(Software s, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.agregarSoftware(s,d);
    }

    public String cargarSoftwares(Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.cargarSoftwares(d);
    }

    public String eliminarSoftware(Software s, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.eliminarSoftware(s,d);
    }

    public String agregarSpin(SpinOff s, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.agregarSpin(s,d);
    }

    public String cargarSpins(Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.cargarSpins(d);
    }

    public String eliminarSpin(SpinOff s, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.eliminarSpin(s,d);
    }

    public String agregarConsultoria(Consultoria c, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.agregarConsultoria(c,d);
    }

    public String cargarConsultorias(Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.cargarConsultorias(d);
    }

    public String eliminarConsultoria(Consultoria c, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.eliminarConsultoria(c,d);
    }

    public String cargarProyectos(Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.cargarProyectos(d);
    }

    public String listarProductos(Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.listarPrductos(d);
    }

    public String agregarProyecto(Proyecto p, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.agregarProyecto(p,d);
    }

    public String eliminarProyecto(Proyecto p, Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.eliminarProyecto(p,d);
    }

    public String generarListado(Docente d) {
        DocenteDao dd = new DocenteDao();
        return dd.generarListado(d);
    }
    
    
}
