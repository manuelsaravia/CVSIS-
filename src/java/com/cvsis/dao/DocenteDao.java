/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvsis.dao;
import com.cvsis.dto.Docente;
import com.cvsis.dto.Materia;
import com.cvsis.dto.Tesis;
import com.cvsis.util.ConexionMysql;
import java.util.ArrayList;
/**
 *
 * @author Manuel
 */
public class DocenteDao {

    public String registrarMateria(Materia m, Docente d) {
        String sql = "INSERT INTO docencia (codMateria,nomMateria,semestre,codDocente) VALUES ('"+m.getCodigo()+"','"+m.getNombre()+"','"+m.getSemestre()+"','"+d.getId()+"');";
        String tab ="";
        try{
            ConexionMysql.conectar();
            ConexionMysql.ejecutarActualizacionSQL(sql);
            tab += "<tr><td>"+m.getCodigo()+"</td>";
            tab += "<td>"+m.getNombre()+"</td>";
            tab += "<td>"+m.getSemestre()+"</td></tr>";
            ConexionMysql.desconectar();
            return tab+"-Registro Exitoso";
        }catch(Exception e){
            return "error";
        }
    }
    
    /*
    public static void main(String arg []){
        String sql = "INSERT INTO usuario (correo, contrasenia, codDocente) VALUES ('manuel.saravia.bulla@gmail.com','1234','0');";
        ConexionMysql.conectar();
        System.out.println("conexion? "+ConexionMysql.hayConexion());
        ConexionMysql.ejecutarActualizacionSQL(sql);
        ConexionMysql.desconectar();
        
    }*/

    public String cargarMaterias(Docente d) {
        String sql = "SELECT idDocencia,codMateria,nomMateria,semestre FROM docencia WHERE codDocente = '"+d.getId()+"';";
        ConexionMysql.conectar();
        ArrayList ar = ConexionMysql.getConsultaSQL(sql);
        String tab ="";
        int i=0;
        String materias = "";
        for(Object m: ar){
            String mat[] = m.toString().split("-");
            materias += mat[0] + ",";
            tab += "<tr><td>"+mat[1]+"</td>";
            tab += "<td>"+mat[2]+"</td>";
            tab += "<td>"+mat[3]+"</td>";
            tab += "<td>"+
                   "<div class=\"btn-group\">"+
                   "<button class=\"btn btn-danger\" id=\"eliminar\" name = \"requerimiento\" value=\"eliminarMateria-"+i+"\" type=\"submit\">"+
                   "<span class=\"glyphicon glyphicon-remove\"></span>"+
                   "</button>"+
                   "</div>"+
                   "</td>"+"</tr>";
            i++;
        }
        ConexionMysql.desconectar();
        if(tab.isEmpty()){
            return "error";
        }
        return tab+";"+materias;
    }

    public String eliminarMateria(Materia m, Docente d) {
        String sql = "DELETE FROM docencia WHERE codDocente = '"+d.getId()+"' AND idDocencia = '"+m.getId()+"';";
        ConexionMysql.conectar();
        ConexionMysql.ejecutarActualizacionSQL(sql);
        ConexionMysql.desconectar();
        return "Eliminación Exitosa";
    }

    public String agregarTesis(Tesis t, Docente d) {
        String sql = "INSERT INTO formacion (codDocente,tipoFormacion,nomEstudiante,docEstudiante,nomProyecto,tipoProyecto,institucion,programa,estadoProyecto,fechaInicio,fechaFin)"+
                " VALUES('"+d.getId()+"','"+t.getTipoTesis()+"','"+t.getNomEstudiante()+"','"+t.getCedula()+"','"+t.getNomProyecto()+"','"+t.getTipoDeTesis()+"','"+t.getInstitucion()+"','"+
                t.getPrograma()+"','"+t.getEstadoTesis()+"','"+t.getFechaIni()+"','"+t.getFechaFin()+"');";
        try{
            ConexionMysql.conectar();
            ConexionMysql.ejecutarActualizacionSQL(sql);
            ConexionMysql.desconectar();
            return "Registro Exitoso";
        }catch(Exception e){
            return "error";
        }
    }

    public String cargarFormacion(Docente d) {
        String sql = "SELECT idFormacion,tipoFormacion,nomEstudiante,docEstudiante,nomProyecto,tipoProyecto,institucion,programa,estadoProyecto,fechaInicio,fechaFin FROM formacion WHERE codDocente = '"+d.getId()+"';";
        ConexionMysql.conectar();
        ArrayList ar = ConexionMysql.getConsultaSQL(sql);
        String tab ="";
        int i=0;
        String tesis = "";
        for(Object m: ar){
            String tes[] = m.toString().split("-");
            tesis += tes[0] + ",";
            tab += "<tr><td>"+tes[1]+"</td>";
            tab += "<td>"+tes[2]+"</td>";
            tab += "<td>"+tes[3]+"</td>";
            tab += "<td>"+tes[4]+"</td>";
            tab += "<td>"+tes[5]+"</td>";
            tab += "<td>"+tes[6]+"</td>";
            tab += "<td>"+tes[7]+"</td>";
            tab += "<td>"+tes[8]+"</td>";
            tab += "<td>"+tes[9]+"</td>";
            tab += "<td>"+tes[10]+"</td>";
            
            tab += "<td>"+
                   "<div class=\"btn-group\">"+
                   "<button class=\"btn btn-danger\" id=\"eliminar\" name = \"requerimiento\" value=\"eliminarTesis-"+i+"\" type=\"submit\">"+
                   "<span class=\"glyphicon glyphicon-remove\"></span>"+
                   "</button>"+
                   "</div>"+
                   "</td>"+"</tr>";
            i++;
        }
        ConexionMysql.desconectar();
        if(tab.isEmpty()){
            return "error";
        }
        return tab+";"+tesis;
    }

    public String eliminarTesis(Tesis t, Docente d) {
        String sql = "DELETE FROM formacion WHERE codDocente = '"+d.getId()+"' AND idFormacion = '"+t.getId()+"';";
        ConexionMysql.conectar();
        ConexionMysql.ejecutarActualizacionSQL(sql);
        ConexionMysql.desconectar();
        return "Eliminación Exitosa";
    }
    
    
    
}
