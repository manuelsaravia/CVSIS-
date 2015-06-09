/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvsis.facade;
import com.cvsis.dto.*;
import com.cvsis.controller.*;
/**
 *
 * @author Manuel
 */
public class Facade {
    
    public Facade(){}
    
    public boolean registrarUsuario(Usuario u, Docente d){
        AdministrarUsuario au = new AdministrarUsuario();
        return au.registrarUsuario(u,d);
    }
    
    public String validarSesion(Usuario u){
        AdministrarUsuario au = new AdministrarUsuario();
        return au.validarSesion(u);
    }
    
    public String validarSesionAdmin(Usuario u){
        AdministrarUsuario au = new AdministrarUsuario();
        return au.validarSesionAdmin(u);
    }
    
    public String registrarMateria(Materia m, Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.registrarMateria(m,d);
    }
    
    public String cargarMaterias(Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.cargarMaterias(d);
    }
    
    public String eliminarMateria(Materia m, Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.eliminarMateria(m,d);
    }
    
    public String agregarTesis(Tesis t, Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.agregarTesis(t,d);
    }
    
    public String cargarFormacion(Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.cargarFormacion(d);
    }
    
    public String eliminarTesis(Tesis t, Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.eliminarTesis(t,d);
    }
    
    public String agregarGrupo(Grupo g, Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.agregarGrupo(g,d);
    }
    
    public String cargarGrupos(Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.cargarGrupos(d);
    }
    
    public String eliminarGrupo(Grupo g, Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.eliminarGrupo(g,d);
    }
    
    public String agregarArticulo(Articulo a, Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.agregarArticulo(a,d);
    }
    
    public String cargarArticulos(Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.cargarArticulos(d);
    }
    
    public String eliminarArticulo(Articulo a, Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.eliminarArticulo(a,d);
    }
    
    public String agregarLibro(Libro l, Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.agregarLibro(l,d);
    }
    
    public String cargarLibros(Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.cargarLibros(d);
    }
    
    public String eliminarLibro(Libro l, Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.eliminarLibro(l,d);
    }
    
    public String agregarEvento(Evento e, Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.agregarEvento(e,d);
    }
    
    public String cargarEventos(Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.cargarEventos(d);
    }
    
    public String eliminarEvento(Evento e, Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.eliminarEvento(e,d);
    }
    
    public String agregarSoftware(Software s, Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.agregarSoftware(s,d);
    }
    
    public String cargarSoftwares(Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.cargarSoftwares(d);
    }
    
    public String eliminarSoftware(Software s, Docente d){
         AdministrarDocente ad = new AdministrarDocente();
        return ad.eliminarSoftware(s,d);
    }
    
    public String agregarSpin(SpinOff s, Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.agregarSpin(s,d);
    }
    
    public String cargarSpins(Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.cargarSpins(d);
    }
    
    public String eliminarSpin(SpinOff s, Docente d){
         AdministrarDocente ad = new AdministrarDocente();
        return ad.eliminarSpin(s,d);
    }
    
    public String agregarConsultoria(Consultoria c, Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.agregarConsultoria(c,d);
    }
    
    public String cargarConsultorias(Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.cargarConsultorias(d);
    }
    
    public String eliminarConsultoria(Consultoria c, Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.eliminarConsultoria(c,d);
    }
    
    public String cargarProyectos(Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.cargarProyectos(d);
    }
    
    public String listarProductos(Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.listarProductos(d);
    }
    
    public String agregarProyecto(Proyecto p, Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.agregarProyecto(p,d);
    }
    
    public String eliminarProyecto(Proyecto p, Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.eliminarProyecto(p,d);
    }
    
    public String generarListado(Docente d){
        AdministrarDocente ad = new AdministrarDocente();
        return ad.generarListado(d);
    }
}
