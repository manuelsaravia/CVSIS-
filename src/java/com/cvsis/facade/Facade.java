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
}
