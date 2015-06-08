/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvsis.dao;
import com.cvsis.dto.Articulo;
import com.cvsis.dto.Consultoria;
import com.cvsis.dto.Docente;
import com.cvsis.dto.Evento;
import com.cvsis.dto.Grupo;
import com.cvsis.dto.Libro;
import com.cvsis.dto.Materia;
import com.cvsis.dto.Software;
import com.cvsis.dto.SpinOff;
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
            boolean b =ConexionMysql.ejecutarActualizacionSQL(sql);
            ConexionMysql.desconectar();
            if(b){
                return "Registro Exitoso";
            }
            return "error";
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

    public String agregarGrupo(Grupo g, Docente d) {
        String sql = "INSERT INTO investigacion (codDocente, nomGrupo, semillero, clasificacion) VALUES ('"+d.getId()+"','"+
                g.getNomGrupo()+"','"+g.getSemillero()+"','"+g.getClasificacion()+"');";
        try{
            ConexionMysql.conectar();
            boolean b =ConexionMysql.ejecutarActualizacionSQL(sql);
            ConexionMysql.desconectar();
            if(b){
                return "Registro Exitoso";
            }
            return "error";
        }catch(Exception e){
            return "error";
        }
    }

    public String cargarGrupos(Docente d) {
        String sql = "SELECT idInvestigacion,nomGrupo,semillero,clasificacion FROM investigacion WHERE codDocente = '"+d.getId()+"';";
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
            
            
            tab += "<td>"+
                   "<div class=\"btn-group\">"+
                   "<button class=\"btn btn-danger\" id=\"eliminar\" name = \"requerimiento\" value=\"eliminarGrupo-"+i+"\" type=\"submit\">"+
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

    public String eliminarGrupo(Grupo g, Docente d) {
        String sql = "DELETE FROM investigacion WHERE codDocente = '"+d.getId()+"' AND idInvestigacion = '"+g.getId()+"';";
        ConexionMysql.conectar();
        ConexionMysql.ejecutarActualizacionSQL(sql);
        ConexionMysql.desconectar();
        return "Eliminación Exitosa";
    }

    public String agregarArticulo(Articulo a, Docente d) {
        String sql = "INSERT INTO producto (codDocente,nombre,fecha) VALUES ('"+d.getId()+"','"+
                a.getTitulo()+"','"+a.getAño()+"');";
        try{
            ConexionMysql.conectar();
            boolean b,n=false;
            b = ConexionMysql.ejecutarActualizacionSQL(sql);
            sql = "SELECT idProducto FROM producto WHERE codDocente = '"+d.getId()+"' AND nombre = '"+a.getTitulo()+"' AND fecha = '"+a.getAño()+"';";
            ArrayList ids = ConexionMysql.getConsultaSQL(sql);
            for(Object m: ids){
                sql = "INSERT INTO articulo (idProducto,pagInicio,pagFin,revista,issn,idioma,volumen,pais,medio) VALUES ("+
                        "'"+m.toString().split("-")[0]+"','"+a.getPagInicio()+"','"+a.getPagFin()+"','"+a.getRevista()+"','"+a.getIssn()+"','"+
                        a.getIdioma()+"','"+a.getVolumen()+"','"+a.getPais()+"','"+a.getMedio()+"');";
                n = ConexionMysql.ejecutarActualizacionSQL(sql);
            }
            ConexionMysql.desconectar();
            if(b&&n){
                return "Registro Exitoso";
            }
            return "error";
        }catch(Exception e){
            return "error";
        }
        
    }
    
    public String cargarArticulos(Docente d){
        String sql = "SELECT idProducto,nombre,fecha FROM producto WHERE codDocente = '"+d.getId()+"';";
        ConexionMysql.conectar();
        ArrayList ar = ConexionMysql.getConsultaSQL(sql);
        String tab ="";
        int i=0;
        String arts = "";
        for(Object m: ar){
            String art[] = m.toString().split("-");
            arts += art[0] + ",";
            sql = "SELECT pagInicio,pagFin,revista,issn,idioma,volumen,pais,medio FROM articulo WHERE idProducto = '"+art[0]+"';";
            ArrayList tt = ConexionMysql.getConsultaSQL(sql);
            for(Object n: tt){
                String arar[] = n.toString().split("-");
                tab += "<tr><td>"+art[1]+"</td>";
                tab += "<td>"+art[2]+"</td>";
                tab += "<td>"+arar[0]+"</td>";
                tab += "<td>"+arar[1]+"</td>";
                tab += "<td>"+arar[2]+"</td>";
                tab += "<td>"+arar[3]+"</td>";
                tab += "<td>"+arar[4]+"</td>";
                tab += "<td>"+arar[5]+"</td>";
                tab += "<td>"+arar[6]+"</td>";
                tab += "<td>"+arar[7]+"</td>";
                
                tab += "<td>"+
                   "<div class=\"btn-group\">"+
                   "<button class=\"btn btn-danger\" id=\"eliminar\" name = \"requerimiento\" value=\"eliminarArticulo-"+i+"\" type=\"submit\">"+
                   "<span class=\"glyphicon glyphicon-remove\"></span>"+
                   "</button>"+
                   "</div>"+
                   "</td>"+"</tr>";
                i++;
            }
        }
        ConexionMysql.desconectar();
        if(tab.isEmpty()){
            return "error";
        }
        return tab+";"+arts;
    }

    public String eliminarArticulo(Articulo a, Docente d) {
        String sql = "DELETE FROM articulo WHERE idProducto = '"+a.getId()+"';";
        ConexionMysql.conectar();
        ConexionMysql.ejecutarActualizacionSQL(sql);
        sql = "DELETE FROM producto WHERE idProducto = '"+a.getId()+"';";
        ConexionMysql.ejecutarActualizacionSQL(sql);
        ConexionMysql.desconectar();
        return "Eliminación Exitosa";
    }

    public String agregarLibro(Libro l, Docente d) {
        String sql = "INSERT INTO producto (codDocente,nombre,fecha) VALUES ('"+d.getId()+"','"+
                l.getTitulo()+"','"+l.getAnio()+"');";
        try{
            ConexionMysql.conectar();
            boolean b,n=false;
            b = ConexionMysql.ejecutarActualizacionSQL(sql);
            sql = "SELECT idProducto FROM producto WHERE codDocente = '"+d.getId()+"' AND nombre = '"+l.getTitulo()+"' AND fecha = '"+l.getAnio()+"';";
            ArrayList ids = ConexionMysql.getConsultaSQL(sql);
            for(Object m: ids){
                sql = "INSERT INTO libro (idProducto,editorial,mes,isbn,pais,medio,estilo) VALUES ("+
                        "'"+m.toString().split("-")[0]+"','"+l.getEditorial()+"','"+l.getMes()+"','"+l.getIsbn()+"','"+l.getPais()+"','"+
                        l.getMedio()+"','"+l.getEstilo()+"');";
                n = ConexionMysql.ejecutarActualizacionSQL(sql);
            }
            ConexionMysql.desconectar();
            if(b&&n){
                return "Registro Exitoso";
            }
            return "error";
        }catch(Exception e){
            return "error";
        }
    }

    public String cargarLibros(Docente d) {
        String sql = "SELECT idProducto,nombre,fecha FROM producto WHERE codDocente = '"+d.getId()+"';";
        ConexionMysql.conectar();
        ArrayList ar = ConexionMysql.getConsultaSQL(sql);
        String tab ="";
        int i=0;
        String libs = "";
        for(Object m: ar){
            String lib[] = m.toString().split("-");
            libs += lib[0] + ",";
            sql = "SELECT editorial,mes,isbn,pais,medio,estilo FROM libro WHERE idProducto = '"+lib[0]+"';";
            ArrayList tt = ConexionMysql.getConsultaSQL(sql);
            for(Object n: tt){
                String arar[] = n.toString().split("-");
                tab += "<tr><td>"+lib[1]+"</td>";
                tab += "<td>"+arar[0]+"</td>";
                tab += "<td>"+lib[2]+"</td>";
                tab += "<td>"+arar[1]+"</td>";
                tab += "<td>"+arar[2]+"</td>";
                tab += "<td>"+arar[3]+"</td>";
                tab += "<td>"+arar[4]+"</td>";
                tab += "<td>"+arar[5]+"</td>";
                
                tab += "<td>"+
                   "<div class=\"btn-group\">"+
                   "<button class=\"btn btn-danger\" id=\"eliminar\" name = \"requerimiento\" value=\"eliminarLibro-"+i+"\" type=\"submit\">"+
                   "<span class=\"glyphicon glyphicon-remove\"></span>"+
                   "</button>"+
                   "</div>"+
                   "</td>"+"</tr>";
                i++;
            }
        }
        ConexionMysql.desconectar();
        if(tab.isEmpty()){
            return "error";
        }
        return tab+";"+libs;
    }

    public String eliminarLibro(Libro l, Docente d) {
        String sql = "DELETE FROM libro WHERE idProducto = '"+l.getId()+"';";
        ConexionMysql.conectar();
        ConexionMysql.ejecutarActualizacionSQL(sql);
        sql = "DELETE FROM producto WHERE idProducto = '"+l.getId()+"';";
        ConexionMysql.ejecutarActualizacionSQL(sql);
        ConexionMysql.desconectar();
        return "Eliminación Exitosa";
    }

    public String agregarEvento(Evento e, Docente d) {
        String sql = "INSERT INTO evento (codDocente, ambito,nombre,fechaIni,fechaFin,institucion,lugar,tipo,vinculacion) VALUES ('"+d.getId()+"','"+
                e.getAmbito()+"','"+e.getNombre()+"','"+e.getFechaIni()+"','"+e.getFechaFin()+"','"+e.getInstitucion()+"','"+e.getLugar()+"','"+e.getTipo()+"','"+e.getVinculacion()+"');";
        try{
            ConexionMysql.conectar();
            boolean b = ConexionMysql.ejecutarActualizacionSQL(sql);
            ConexionMysql.desconectar();
            if(b){
                return "Registro Exitoso";
            }
            return "error";
        }catch(Exception f){
            return "error";
        }
    }

    public String cargarEventos(Docente d) {
        String sql = "SELECT idEvento,nombre,tipo,ambito,lugar,fechaIni,fechaFin,vinculacion,institucion FROM evento WHERE codDocente = '"+d.getId()+"';";
        ConexionMysql.conectar();
        ArrayList ar = ConexionMysql.getConsultaSQL(sql);
        String tab ="";
        int i=0;
        String eventos = "";
        for(Object m: ar){
            String evt[] = m.toString().split("-");
            eventos += evt[0] + ",";
            tab += "<tr><td>"+evt[1]+"</td>";
            tab += "<td>"+evt[2]+"</td>";
            tab += "<td>"+evt[3]+"</td>";
            tab += "<td>"+evt[4]+"</td>";
            tab += "<td>"+evt[5]+"</td>";
            tab += "<td>"+evt[6]+"</td>";
            tab += "<td>"+evt[7]+"</td>";
            tab += "<td>"+evt[8]+"</td>";
            
            
            tab += "<td>"+
                   "<div class=\"btn-group\">"+
                   "<button class=\"btn btn-danger\" id=\"eliminar\" name = \"requerimiento\" value=\"eliminarEvento-"+i+"\" type=\"submit\">"+
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
        return tab+";"+eventos;
    }
    
    public String eliminarEvento(Evento e,Docente d){
        String sql = "DELETE FROM evento WHERE codDocente = '"+d.getId()+"' AND idEvento = '"+e.getId()+"';";
        ConexionMysql.conectar();
        ConexionMysql.ejecutarActualizacionSQL(sql);
        ConexionMysql.desconectar();
        return "Eliminación Exitosa";
    }

    public String agregarSoftware(Software s, Docente d) {
        String sql = "INSERT INTO producto (codDocente,nombre,fecha) VALUES ('"+d.getId()+"','"+
                s.getNomReal()+"','"+s.getAnio()+"');";
        try{
            ConexionMysql.conectar();
            boolean b,n=false;
            b = ConexionMysql.ejecutarActualizacionSQL(sql);
            sql = "SELECT idProducto FROM producto WHERE codDocente = '"+d.getId()+"' AND nombre = '"+s.getNomReal()+"' AND fecha = '"+s.getAnio()+"';";
            ArrayList ids = ConexionMysql.getConsultaSQL(sql);
            for(Object m: ids){
                sql = "INSERT INTO software (idProducto,nomComercial,numContrato,registro,sitioWeb,tipo,resumen) VALUES ("+
                        "'"+m.toString().split("-")[0]+"','"+s.getNomCom()+"','"+s.getContrato()+"','"+s.getRegistro()+"','"+s.getSitio()+"','"+
                        s.getTipo()+"','"+s.getResumen()+"');";
                n = ConexionMysql.ejecutarActualizacionSQL(sql);
            }
            ConexionMysql.desconectar();
            if(b&&n){
                return "Registro Exitoso";
            }
            return "error";
        }catch(Exception e){
            return "error";
        }
    }

    public String cargarSoftwares(Docente d) {
        String sql = "SELECT idProducto,nombre,fecha FROM producto WHERE codDocente = '"+d.getId()+"';";
        ConexionMysql.conectar();
        ArrayList ar = ConexionMysql.getConsultaSQL(sql);
        String tab ="";
        int i=0;
        String libs = "";
        for(Object m: ar){
            String lib[] = m.toString().split("-");
            libs += lib[0] + ",";
            sql = "SELECT nomComercial,numContrato,registro,sitioWeb,tipo,resumen FROM software WHERE idProducto = '"+lib[0]+"';";
            ArrayList tt = ConexionMysql.getConsultaSQL(sql);
            for(Object n: tt){
                String arar[] = n.toString().split("-");
                tab += "<tr><td>"+arar[4]+"</td>";
                tab += "<td>"+lib[1]+"</td>";
                tab += "<td>"+lib[2]+"</td>";
                tab += "<td><a href=\""+arar[3]+"\">"+arar[3]+"</a></td>";
                tab += "<td>"+arar[0]+"</td>";
                tab += "<td>"+arar[1]+"</td>";
                tab += "<td>"+arar[2]+"</td>";
                tab += "<td>"+arar[5]+"</td>";
                
                tab += "<td>"+
                   "<div class=\"btn-group\">"+
                   "<button class=\"btn btn-danger\" id=\"eliminar\" name = \"requerimiento\" value=\"eliminarSoftware-"+i+"\" type=\"submit\">"+
                   "<span class=\"glyphicon glyphicon-remove\"></span>"+
                   "</button>"+
                   "</div>"+
                   "</td>"+"</tr>";
                i++;
            }
        }
        ConexionMysql.desconectar();
        if(tab.isEmpty()){
            return "error";
        }
        return tab+";"+libs;
    }
 
    public String eliminarSoftware(Software s, Docente d){
        String sql = "DELETE FROM software WHERE idProducto = '"+s.getId()+"';";
        ConexionMysql.conectar();
        ConexionMysql.ejecutarActualizacionSQL(sql);
        sql = "DELETE FROM producto WHERE idProducto = '"+s.getId()+"';";
        ConexionMysql.ejecutarActualizacionSQL(sql);
        ConexionMysql.desconectar();
        return "Eliminación Exitosa";
    }

    public String agregarSpin(SpinOff s, Docente d) {
        String sql = "INSERT INTO spinOff (codDocente,empresa,nit,fecha,producto,registro,representante,cedula) VALUES ('"+d.getId()+"','"+
                s.getEmpresa()+"','"+s.getNit()+"','"+s.getFecha()+"','"+s.getProducto()+"','"+s.getRegistro()+"','"+s.getRepresentante()
                +"','"+s.getCedula()+"');";
        try{
            ConexionMysql.conectar();
            boolean b = ConexionMysql.ejecutarActualizacionSQL(sql);
            ConexionMysql.desconectar();
            if(b){
                return "Registro Exitoso";
            }
            return "error";
        }catch(Exception f){
            return "error";
        }
    }

    public String cargarSpins(Docente d) {
        String sql = "SELECT idSpinOff,empresa,nit,fecha,producto,registro,representante,cedula FROM spinOff WHERE codDocente = '"+d.getId()+"';";
        ConexionMysql.conectar();
        ArrayList ar = ConexionMysql.getConsultaSQL(sql);
        String tab ="";
        int i=0;
        String eventos = "";
        for(Object m: ar){
            String evt[] = m.toString().split("-");
            eventos += evt[0] + ",";
            tab += "<tr><td>"+evt[1]+"</td>";
            tab += "<td>"+evt[2]+"</td>";
            tab += "<td>"+evt[3]+"</td>";
            tab += "<td>"+evt[4]+"</td>";
            tab += "<td>"+evt[5]+"</td>";
            tab += "<td>"+evt[6]+"</td>";
            tab += "<td>"+evt[7]+"</td>";
            
            
            tab += "<td>"+
                   "<div class=\"btn-group\">"+
                   "<button class=\"btn btn-danger\" id=\"eliminar\" name = \"requerimiento\" value=\"eliminarSpin-"+i+"\" type=\"submit\">"+
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
        return tab+";"+eventos;
    }

    public String eliminarSpin(SpinOff s, Docente d) {
        String sql = "DELETE FROM spinOff WHERE codDocente = '"+d.getId()+"' AND idSpinOff = '"+s.getId()+"';";
        ConexionMysql.conectar();
        ConexionMysql.ejecutarActualizacionSQL(sql);
        ConexionMysql.desconectar();
        return "Eliminación Exitosa";
    }

    public String agregarConsultoria(Consultoria c, Docente d) {
        String sql = "INSERT INTO consulta (codDocente,tipo,duracion,fechaIni,institucion,nombre,numContrato,pais,sector) VALUES ('"+d.getId()+"','"+
                c.getTipo()+"','"+c.getDuracion()+"','"+c.getFecha()+"','"+c.getInstitucion()+"','"+c.getNombre()+"','"+c.getContrato()
                +"','"+c.getPais()+"','"+c.getSector()+"');";
        try{
            ConexionMysql.conectar();
            boolean b = ConexionMysql.ejecutarActualizacionSQL(sql);
            ConexionMysql.desconectar();
            if(b){
                return "Registro Exitoso";
            }
            return "error";
        }catch(Exception f){
            return "error";
        }
    }

    public String cargarConsultorias(Docente d) {
        String sql = "SELECT idConsulta,tipo,nombre,pais,numContrato,institucion,duracion,fechaIni,sector FROM consulta WHERE codDocente = '"+d.getId()+"';";
        ConexionMysql.conectar();
        ArrayList ar = ConexionMysql.getConsultaSQL(sql);
        String tab ="";
        int i=0;
        String eventos = "";
        for(Object m: ar){
            String evt[] = m.toString().split("-");
            eventos += evt[0] + ",";
            tab += "<tr><td>"+evt[1]+"</td>";
            tab += "<td>"+evt[2]+"</td>";
            tab += "<td>"+evt[3]+"</td>";
            tab += "<td>"+evt[4]+"</td>";
            tab += "<td>"+evt[5]+"</td>";
            tab += "<td>"+evt[6]+"</td>";
            tab += "<td>"+evt[7]+"</td>";
            tab += "<td>"+evt[8]+"</td>";
            
            tab += "<td>"+
                   "<div class=\"btn-group\">"+
                   "<button class=\"btn btn-danger\" id=\"eliminar\" name = \"requerimiento\" value=\"eliminarConsultoria-"+i+"\" type=\"submit\">"+
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
        return tab+";"+eventos;
    }

    public String eliminarConsultoria(Consultoria c, Docente d) {
        String sql = "DELETE FROM consulta WHERE codDocente = '"+d.getId()+"' AND idConsulta = '"+c.getId()+"';";
        ConexionMysql.conectar();
        ConexionMysql.ejecutarActualizacionSQL(sql);
        ConexionMysql.desconectar();
        return "Eliminación Exitosa";
    }
}
