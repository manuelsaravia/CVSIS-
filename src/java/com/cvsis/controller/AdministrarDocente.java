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
    
    
}
