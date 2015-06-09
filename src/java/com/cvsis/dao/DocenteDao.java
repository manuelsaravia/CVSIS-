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
import com.cvsis.dto.Proyecto;
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
            
            sql = "SELECT pagInicio,pagFin,revista,issn,idioma,volumen,pais,medio FROM articulo WHERE idProducto = '"+art[0]+"';";
            ArrayList tt = ConexionMysql.getConsultaSQL(sql);
            for(Object n: tt){
                arts += art[0] + ",";
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
        boolean b = ConexionMysql.ejecutarActualizacionSQL(sql);
        if(b){
            sql = "DELETE FROM producto WHERE idProducto = '"+a.getId()+"';";
            ConexionMysql.ejecutarActualizacionSQL(sql);
        }
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
            
            sql = "SELECT editorial,mes,isbn,pais,medio,estilo FROM libro WHERE idProducto = '"+lib[0]+"';";
            ArrayList tt = ConexionMysql.getConsultaSQL(sql);
            for(Object n: tt){
                libs += lib[0] + ",";
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
        System.out.println("el id es: "+l.getId());
        String sql = "DELETE FROM libro WHERE idProducto = '"+l.getId()+"';";
        ConexionMysql.conectar();
        boolean b = ConexionMysql.ejecutarActualizacionSQL(sql);
        System.out.println(b);
        if(b){
            sql = "DELETE FROM producto WHERE idProducto = '"+l.getId()+"';";
            ConexionMysql.ejecutarActualizacionSQL(sql);
        }
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
            
            sql = "SELECT nomComercial,numContrato,registro,sitioWeb,tipo,resumen FROM software WHERE idProducto = '"+lib[0]+"';";
            ArrayList tt = ConexionMysql.getConsultaSQL(sql);
            for(Object n: tt){
                libs += lib[0] + ",";
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
        boolean b = ConexionMysql.ejecutarActualizacionSQL(sql);
        if(b){
            sql = "DELETE FROM producto WHERE idProducto = '"+s.getId()+"';";
            ConexionMysql.ejecutarActualizacionSQL(sql);
        }
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

    public String cargarProyectos(Docente d) {
        String sql = "SELECT idProyecto,tipo,nombre,codActa,fechaIni,fechaFin,resumen,instFinanciera,producto FROM proyecto WHERE codDocente = '"+d.getId()+"';";
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
                   "<button class=\"btn btn-danger\" id=\"eliminar\" name = \"requerimiento\" value=\"eliminarProyecto-"+i+"\" type=\"submit\">"+
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

    public String listarPrductos(Docente d) {
        String sql = "SELECT nombre FROM producto WHERE codDocente = '"+d.getId()+"';";
        ConexionMysql.conectar();
        ArrayList ar = ConexionMysql.getConsultaSQL(sql);
        String tab= "<option value=\"Sin Producto\">--</option>";
        
      
        for(Object m: ar){
            String evt[] = m.toString().split("-");
            
            tab += "<option value=\""+evt[0]+"\">"+evt[0]+"</option>";
            
        }
        ConexionMysql.desconectar();
        
        return tab;
    }

    public String agregarProyecto(Proyecto p, Docente d) {
        String sql = "INSERT INTO proyecto (codDocente,tipo,nombre,codActa,fechaIni,fechaFin,resumen,instFinanciera,producto) VALUES ('"+d.getId()+"','"+
                p.getTipo()+"','"+p.getNombre()+"','"+p.getCodigo()+"','"+p.getFechaIni()+"','"+p.getFechafin()+"','"+p.getResumen()
                +"','"+p.getInstitucion()+"','"+p.getProducto()+"');";
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

    public String eliminarProyecto(Proyecto p, Docente d) {
        String sql = "DELETE FROM proyecto WHERE codDocente = '"+d.getId()+"' AND idProyecto = '"+p.getId()+"';";
        ConexionMysql.conectar();
        ConexionMysql.ejecutarActualizacionSQL(sql);
        ConexionMysql.desconectar();
        return "Eliminación Exitosa";
    }

    public String generarListado(Docente d) {
        String sql = "SELECT idDocencia,codMateria,nomMateria,semestre FROM docencia WHERE codDocente = '"+d.getId()+"';";
        ArrayList ar = ConexionMysql.getConsultaSQL(sql);
        String tab1 ="<div align=\"center\">" +
"                                                                   <div class=\"col-md-8 col-md-offset-2\">" +
"                                                                   <div class=\"panel panel-default\">" +
"                                                                       <!-- Default panel contents -->" +
"                                                                       <div class=\"panel-heading\">Materias Dictadas</div>" +
"                                                                       <div class=\"panel-body\">" +
"                                                                           <!-- Table -->" +
"                                                                           <div class=\"table-responsive\">" +
"                                                                               <div align=\"center\">\n" +
"                                                                                   <table class=\"table\">" +
"                                                                                       <thead>" +
"                                                                                           <tr>" +
"                                                                                               <th>Codigo Curso</th>" +
"                                                                                               <th>Nombre Asignatura</th>" +
"                                                                                               <th>Semestre</th>" +
"                                                                                               " +
"                                                                                           </tr>\n" +
"                                                                                       </thead><tbody>";
        
        for(Object m: ar){
            String mat[] = m.toString().split("-");
            tab1 += "<tr><td>"+mat[1]+"</td>";
            tab1 += "<td>"+mat[2]+"</td>";
            tab1 += "<td>"+mat[3]+"</td></tr>";
        }
        tab1 +="</tbody></table></div></div></div></div></div></div>";
        
        
        sql = "SELECT idFormacion,tipoFormacion,nomEstudiante,docEstudiante,nomProyecto,tipoProyecto,institucion,programa,estadoProyecto,fechaInicio,fechaFin FROM formacion WHERE codDocente = '"+d.getId()+"';";
        ar = ConexionMysql.getConsultaSQL(sql);
        String tab2 ="<div align=\"center\">" +
"                                                                   <div class=\"col-md-12 col-md-offset-0\">" +
"                                                                   <div class=\"panel panel-default\">" +
"                                                                       <!-- Default panel contents -->" +"<div class=\"panel-heading\">Tesis Dirigidas</div>" +
"                                                                       <div class=\"panel-body\">" +
"                                                                           <!-- Table -->" +
"                                                                           <div class=\"table-responsive\">" +
"                                                                               <div align=\"center\">" +
"                                                                                   <table class=\"table\">" +
"                                                                                       <thead>" +
"                                                                                           <tr>" +
"                                                                                               <th>Tipo Tesis</th>" +
"                                                                                               <th>Nombre Estudiante</th>" +
"                                                                                               <th>Cedula</th>" +
"                                                                                               <th>Nombre Proyecto</th>" +
"                                                                                               <th>Tipo</th>" +
"                                                                                               <th>Institucion</th>" +
"                                                                                               <th>Programa</th>" +
"                                                                                               <th>Estado</th>" +
"                                                                                               <th>Fecha Inicio</th>" +
"                                                                                               <th>Fecha Fin</th>" +
"                                                                                               " +
"                                                                                               " +
"                                                                                           </tr>" +
"                                                                                       </thead>" +
"                                                                                       <tbody>";
        
        for(Object m: ar){
            String tes[] = m.toString().split("-");
            tab2 += "<tr><td>"+tes[1]+"</td>";
            tab2 += "<td>"+tes[2]+"</td>";
            tab2 += "<td>"+tes[3]+"</td>";
            tab2 += "<td>"+tes[4]+"</td>";
            tab2 += "<td>"+tes[5]+"</td>";
            tab2 += "<td>"+tes[6]+"</td>";
            tab2 += "<td>"+tes[7]+"</td>";
            tab2 += "<td>"+tes[8]+"</td>";
            tab2 += "<td>"+tes[9]+"</td>";
            tab2 += "<td>"+tes[10]+"</td></tr>";
        }
        tab2+="</tbody></table></div></div></div></div></div></div>";
        
        sql = "SELECT idInvestigacion,nomGrupo,semillero,clasificacion FROM investigacion WHERE codDocente = '"+d.getId()+"';";
        ar = ConexionMysql.getConsultaSQL(sql);
        String tab3 ="<div align=\"center\">\n" +
"                                                                   <div class=\"col-md-10 col-md-offset-1\">\n" +
"                                                                   <div class=\"panel panel-default\">\n" +
"                                                                       <!-- Default panel contents -->\n" +
"                                                                       <div class=\"panel-heading\">Grupos de Investigación</div>\n" +
"                                                                       <div class=\"panel-body\" style=\"text-align:center;\">\n" +
"                                                                           <!-- Table -->\n" +
"                                                                           <div class=\"table-responsive\">\n" +
"                                                                               <div align=\"center\">\n" +
"                                                                                   <table class=\"table\">\n" +
"                                                                                       <thead>\n" +
"                                                                                           <tr>\n" +
"                                                                                               <th>Nombre</th> \n" +
"                                                                                               <th>Semillero</th>\n" +
"                                                                                               <th>Clasificación</th>\n" +
"                                                                                               " +
"                                                                                               \n" +
"                                                                                           </tr>\n" +
"                                                                                       </thead><tbody>";
        
        for(Object m: ar){
            String tes[] = m.toString().split("-");
            
            tab3 += "<tr><td>"+tes[1]+"</td>";
            tab3 += "<td>"+tes[2]+"</td>";
            tab3 += "<td>"+tes[3]+"</td></tr>";
        }
        tab3+= "</tbody></table></div></div></div></div></div></div>";

        sql = "SELECT idProducto,nombre,fecha FROM producto WHERE codDocente = '"+d.getId()+"';";
        ar = ConexionMysql.getConsultaSQL(sql);
        String tab4 ="<div align=\"center\">\n" +
"                                                                                                           <div class=\"col-md-12\">\n" +
"                                                                                                               <div class=\"panel panel-default\">\n" +
"                                                                                                                   <!-- Default panel contents -->\n" +
"                                                                                                                   <div class=\"panel-heading\">Articulos</div>\n" +
"                                                                                                                   <div class=\"panel-body\">\n" +
"                                                                                                                       <!-- Table -->\n" +
"                                                                                                                       <div class=\"table-responsive\">\n" +
"                                                                                                                           <div align=\"center\">\n" +
"                                                                                                                               <table class=\"table\">\n" +
"                                                                                                                                   <thead>\n" +
"                                                                                                                                       <tr>\n" +
"                                                                                                                                           <th>Titulo</th> \n" +
"                                                                                                                                           <th>Año Publicacion</th>\n" +
"                                                                                                                                           <th>Pagina Inicio</th>\n" +
"                                                                                                                                           <th>Pagina Fin</th>\n" +
"                                                                                                                                           <th>Revista</th>\n" +
"                                                                                                                                           <th>Clasificacion ISSN</th>\n" +
"                                                                                                                                           <th>Idioma</th>\n" +
"                                                                                                                                           <th># Volumen</th>\n" +
"                                                                                                                                           <th>Pais</th>\n" +
"                                                                                                                                           <th>Medio</th>\n" +
"                                                                                                                                           " +
"                                                                                                                                       </tr>\n" +
"                                                                                                                                   </thead><tbody>";
        
        for(Object m: ar){
            String art[] = m.toString().split("-");
            
            sql = "SELECT pagInicio,pagFin,revista,issn,idioma,volumen,pais,medio FROM articulo WHERE idProducto = '"+art[0]+"';";
            ArrayList tt = ConexionMysql.getConsultaSQL(sql);
            for(Object n: tt){
                String arar[] = n.toString().split("-");
                tab4 += "<tr><td>"+art[1]+"</td>";
                tab4 += "<td>"+art[2]+"</td>";
                tab4 += "<td>"+arar[0]+"</td>";
                tab4 += "<td>"+arar[1]+"</td>";
                tab4 += "<td>"+arar[2]+"</td>";
                tab4 += "<td>"+arar[3]+"</td>";
                tab4 += "<td>"+arar[4]+"</td>";
                tab4 += "<td>"+arar[5]+"</td>";
                tab4 += "<td>"+arar[6]+"</td>";
                tab4 += "<td>"+arar[7]+"</td></tr>";
            }
        }
        tab4 +="</tbody></table></div></div></div></div></div></div>";
    
        sql = "SELECT idProducto,nombre,fecha FROM producto WHERE codDocente = '"+d.getId()+"';";
        ar = ConexionMysql.getConsultaSQL(sql);
        String tab5 ="<div align=\"center\">\n" +
"                                                                                                           <div class=\"col-md-12 col-md-offset-0\">\n" +
"                                                                                                               <div class=\"panel panel-default\">\n" +
"                                                                                                                   <!-- Default panel contents -->\n" +
"                                                                                                                   <div class=\"panel-heading\">Libros de Investigación</div>\n" +
"                                                                                                                   <div class=\"panel-body\">\n" +
"                                                                                                                       <!-- Table -->\n" +
"                                                                                                                       <div class=\"table-responsive\">\n" +
"                                                                                                                           <div align=\"center\">\n" +
"                                                                                                                               <table class=\"table\">\n" +
"                                                                                                                                   <thead>\n" +
"                                                                                                                                       <tr>\n" +
"                                                                                                                                           <th>Titulo</th> \n" +
"                                                                                                                                           <th>Editorial</th>\n" +
"                                                                                                                                           <th>Año</th>\n" +
"                                                                                                                                           <th>Mes Publicacion</th>\n" +
"                                                                                                                                           <th>ISBN</th>\n" +
"                                                                                                                                           <th>Pais</th>\n" +
"                                                                                                                                           <th>Medio</th>\n" +
"                                                                                                                                           <th>Estilo</th>\n" +
"                                                                                                                                           " +
"                                                                                                                                           \n" +
"                                                                                                                                       </tr>\n" +
"                                                                                                                                   </thead><tbody>";
        
        for(Object m: ar){
            String lib[] = m.toString().split("-");
            
            sql = "SELECT editorial,mes,isbn,pais,medio,estilo FROM libro WHERE idProducto = '"+lib[0]+"';";
            ArrayList tt = ConexionMysql.getConsultaSQL(sql);
            for(Object n: tt){
                String arar[] = n.toString().split("-");
                tab5 += "<tr><td>"+lib[1]+"</td>";
                tab5 += "<td>"+arar[0]+"</td>";
                tab5 += "<td>"+lib[2]+"</td>";
                tab5 += "<td>"+arar[1]+"</td>";
                tab5 += "<td>"+arar[2]+"</td>";
                tab5 += "<td>"+arar[3]+"</td>";
                tab5 += "<td>"+arar[4]+"</td>";
                tab5 += "<td>"+arar[5]+"</td></tr>";
            }
        }
        tab5 += "</tbody></table></div></div></div></div></div></div>";

        sql = "SELECT idEvento,nombre,tipo,ambito,lugar,fechaIni,fechaFin,vinculacion,institucion FROM evento WHERE codDocente = '"+d.getId()+"';";
        ar = ConexionMysql.getConsultaSQL(sql);
        String tab6 ="<div align=\"center\">\n" +
"                                                                   <div class=\"col-md-12 col-md-offset-0\">\n" +
"                                                                   <div class=\"panel panel-default\">\n" +
"                                                                       <!-- Default panel contents -->\n" +
"                                                                       <div class=\"panel-heading\">Eventos Participados</div>\n" +
"                                                                       <div class=\"panel-body\">\n" +
"                                                                           <!-- Table -->\n" +
"                                                                           <div class=\"table-responsive\">\n" +
"                                                                               <div align=\"center\">\n" +
"                                                                                   <table class=\"table\">\n" +
"                                                                                       <thead>\n" +
"                                                                                           <tr>\n" +
"                                                                                               <th>Nombre</th> \n" +
"                                                                                               <th>Tipo Evento</th>\n" +
"                                                                                               <th>Ambito</th>\n" +
"                                                                                               <th>Lugar (Institucion)</th>\n" +
"                                                                                               <th>Fecha Inicio</th>\n" +
"                                                                                               <th>Fecha Finalizacion</th>\n" +
"                                                                                               <th>Tipo Vinculacion</th>\n" +
"                                                                                               <th>Institucion</th>\n" +
"                                                                                               " +
"                                                                                           </tr>\n" +
"                                                                                       </thead><tbody>";
        
        for(Object m: ar){
            String evt[] = m.toString().split("-");
            
            tab6 += "<tr><td>"+evt[1]+"</td>";
            tab6 += "<td>"+evt[2]+"</td>";
            tab6 += "<td>"+evt[3]+"</td>";
            tab6 += "<td>"+evt[4]+"</td>";
            tab6 += "<td>"+evt[5]+"</td>";
            tab6 += "<td>"+evt[6]+"</td>";
            tab6 += "<td>"+evt[7]+"</td>";
            tab6 += "<td>"+evt[8]+"</td></tr>";
        }
        tab6+="</tbody></table></div></div></div></div></div></div>";

        sql = "SELECT idProducto,nombre,fecha FROM producto WHERE codDocente = '"+d.getId()+"';";
        ar = ConexionMysql.getConsultaSQL(sql);
        String tab7 ="<div align=\"center\">\n" +
"                                                                                                           <div class=\"col-md-12 col-md-offset-0\">\n" +
"                                                                                                               <div class=\"panel panel-default\">\n" +
"                                                                                                                   <!-- Default panel contents -->\n" +
"                                                                                                                   <div class=\"panel-heading\">Softwares</div>\n" +
"                                                                                                                   <div class=\"panel-body\">\n" +
"                                                                                                                       <!-- Table -->\n" +
"                                                                                                                       <div class=\"table-responsive\">\n" +
"                                                                                                                           <div align=\"center\">\n" +
"                                                                                                                               <table class=\"table\">\n" +
"                                                                                                                                   <thead>\n" +
"                                                                                                                                       <tr>\n" +
"                                                                                                                                           <th>Tipo</th> \n" +
"                                                                                                                                           <th>Nombre Real</th>\n" +
"                                                                                                                                           <th>Año de Entrega</th>\n" +
"                                                                                                                                           <th>Sitio Web</th>\n" +
"                                                                                                                                           <th>Nombre Comercial</th>\n" +
"                                                                                                                                           <th>Nº de Contrato</th>\n" +
"                                                                                                                                           <th>Registro</th>\n" +
"                                                                                                                                           <th>Breve Resumen</th>\n" +
"                                                                                                                                           " +
"                                                                                                                                           \n" +
"                                                                                                                                       </tr>\n" +
"                                                                                                                                   </thead><tbody>";
        
        for(Object m: ar){
            String lib[] = m.toString().split("-");
            
            sql = "SELECT nomComercial,numContrato,registro,sitioWeb,tipo,resumen FROM software WHERE idProducto = '"+lib[0]+"';";
            ArrayList tt = ConexionMysql.getConsultaSQL(sql);
            for(Object n: tt){
                String arar[] = n.toString().split("-");
                tab7 += "<tr><td>"+arar[4]+"</td>";
                tab7 += "<td>"+lib[1]+"</td>";
                tab7 += "<td>"+lib[2]+"</td>";
                tab7 += "<td><a href=\""+arar[3]+"\">"+arar[3]+"</a></td>";
                tab7 += "<td>"+arar[0]+"</td>";
                tab7 += "<td>"+arar[1]+"</td>";
                tab7 += "<td>"+arar[2]+"</td>";
                tab7 += "<td>"+arar[5]+"</td></tr>";
            }
        }
        tab7+="</tbody></table></div></div></div></div></div></div>";
        

        sql = "SELECT idSpinOff,empresa,nit,fecha,producto,registro,representante,cedula FROM spinOff WHERE codDocente = '"+d.getId()+"';";
        ar = ConexionMysql.getConsultaSQL(sql);
        String tab8 ="<div align=\"center\">\n" +
"                                                                                                           <div class=\"col-md-12 col-md-offset-0\">\n" +
"                                                                                                               <div class=\"panel panel-default\">\n" +
"                                                                                                                   <!-- Default panel contents -->\n" +
"                                                                                                                   <div class=\"panel-heading\">Spins Off</div>\n" +
"                                                                                                                   <div class=\"panel-body\">\n" +
"                                                                                                                       <!-- Table -->\n" +
"                                                                                                                       <div class=\"table-responsive\">\n" +
"                                                                                                                           <div align=\"center\">\n" +
"                                                                                                                               <table class=\"table\">\n" +
"                                                                                                                                   <thead>\n" +
"                                                                                                                                       <tr>\n" +
"                                                                                                                                           <th>Empresa</th> \n" +
"                                                                                                                                           <th>Nit o Registro</th>\n" +
"                                                                                                                                           <th>Fecha Registro</th>\n" +
"                                                                                                                                           <th>Productos</th>\n" +
"                                                                                                                                           <th>Registro Producto</th>\n" +
"                                                                                                                                           <th>Representante Legal</th>\n" +
"                                                                                                                                           <th>Cedula Representante</th>\n" +
"                                                                                                                                           " +
"                                                                                                                                           \n" +
"                                                                                                                                       </tr>\n" +
"                                                                                                                                   </thead><tbody>";
        
        for(Object m: ar){
            String evt[] = m.toString().split("-");
            
            tab8 += "<tr><td>"+evt[1]+"</td>";
            tab8 += "<td>"+evt[2]+"</td>";
            tab8 += "<td>"+evt[3]+"</td>";
            tab8 += "<td>"+evt[4]+"</td>";
            tab8 += "<td>"+evt[5]+"</td>";
            tab8 += "<td>"+evt[6]+"</td>";
            tab8 += "<td>"+evt[7]+"</td></tr>";
        }
        tab8+="</tbody></table></div></div></div></div></div></div>";

        sql = "SELECT idConsulta,tipo,nombre,pais,numContrato,institucion,duracion,fechaIni,sector FROM consulta WHERE codDocente = '"+d.getId()+"';";
        ar = ConexionMysql.getConsultaSQL(sql);
        String tab9 ="<div align=\"center\">\n" +
"                                                                                                           <div class=\"col-md-12 col-md-offset-0\">\n" +
"                                                                                                               <div class=\"panel panel-default\">\n" +
"                                                                                                                   <!-- Default panel contents -->\n" +
"                                                                                                                   <div class=\"panel-heading\">Consultoria-Asesoria</div>\n" +
"                                                                                                                   <div class=\"panel-body\">\n" +
"                                                                                                                       <!-- Table -->\n" +
"                                                                                                                       <div class=\"table-responsive\">\n" +
"                                                                                                                           <div align=\"center\">\n" +
"                                                                                                                               <table class=\"table\">\n" +
"                                                                                                                                   <thead>\n" +
"                                                                                                                                       <tr>\n" +
"                                                                                                                                           <th>Tipo</th> \n" +
"                                                                                                                                           <th>Nombre</th>\n" +
"                                                                                                                                           <th>Pais</th>\n" +
"                                                                                                                                           <th># de Contrato</th>\n" +
"                                                                                                                                           <th>Institucion</th>\n" +
"                                                                                                                                           <th>Duracion (en dias)</th>\n" +
"                                                                                                                                           <th>Fecha</th>\n" +
"                                                                                                                                           <th>Sector Aplicacion</th>\n" +
"                                                                                                                                           " +
"                                                                                                                                           \n" +
"                                                                                                                                       </tr>\n" +
"                                                                                                                                   </thead>";
        
        for(Object m: ar){
            String evt[] = m.toString().split("-");
            
            tab9 += "<tr><td>"+evt[1]+"</td>";
            tab9 += "<td>"+evt[2]+"</td>";
            tab9 += "<td>"+evt[3]+"</td>";
            tab9 += "<td>"+evt[4]+"</td>";
            tab9 += "<td>"+evt[5]+"</td>";
            tab9 += "<td>"+evt[6]+"</td>";
            tab9 += "<td>"+evt[7]+"</td>";
            tab9 += "<td>"+evt[8]+"</td></tr>";
        }
        tab9+="</tbody></table></div></div></div></div></div></div>";

        sql = "SELECT idProyecto,tipo,nombre,codActa,fechaIni,fechaFin,resumen,instFinanciera,producto FROM proyecto WHERE codDocente = '"+d.getId()+"';";
        ar = ConexionMysql.getConsultaSQL(sql);
        String tab10 ="<div align=\"center\">\n" +
"                                                                                                           <div class=\"col-md-12 col-md-offset-0\">\n" +
"                                                                                                               <div class=\"panel panel-default\">\n" +
"                                                                                                                   <!-- Default panel contents -->\n" +
"                                                                                                                   <div class=\"panel-heading\">Proyectos</div>\n" +
"                                                                                                                   <div class=\"panel-body\">\n" +
"                                                                                                                       <!-- Table -->\n" +
"                                                                                                                       <div class=\"table-responsive\">\n" +
"                                                                                                                           <div align=\"center\">\n" +
"                                                                                                                               <table class=\"table\">\n" +
"                                                                                                                                   <thead>\n" +
"                                                                                                                                       <tr>\n" +
"                                                                                                                                           <th>Tipo</th> \n" +
"                                                                                                                                           <th>Nombre</th>\n" +
"                                                                                                                                           <th>Codigo</th>\n" +
"                                                                                                                                           <th>Fecha Inicio</th>\n" +
"                                                                                                                                           <th>Fecha Fin</th>\n" +
"                                                                                                                                           <th>Resumen</th>\n" +
"                                                                                                                                           <th>Institucion Financiera</th>\n" +
"                                                                                                                                           <th>Producto</th>\n" +
"                                                                                                                                           " +
"                                                                                                                                       </tr>\n" +
"                                                                                                                                   </thead>";
        
        for(Object m: ar){
            String evt[] = m.toString().split("-");
            
            tab10 += "<tr><td>"+evt[1]+"</td>";
            tab10 += "<td>"+evt[2]+"</td>";
            tab10 += "<td>"+evt[3]+"</td>";
            tab10 += "<td>"+evt[4]+"</td>";
            tab10 += "<td>"+evt[5]+"</td>";
            tab10 += "<td>"+evt[6]+"</td>";
            tab10 += "<td>"+evt[7]+"</td>";
            tab10 += "<td>"+evt[8]+"</td></tr>";
        }
        tab10+="</tbody></table></div></div></div></div></div></div>";
        
        String tab = tab1 + "<br><br>" + tab2+ "<br><br>" + tab3+ "<br><br>" + tab4+ "<br><br>" + tab5+ "<br><br>" + tab6+ "<br><br>" + tab7+ "<br><br>" + tab8+ "<br><br>" + tab9+ "<br><br>" + tab10;
          
        
        return tab;
    }

    public String consultarDatos(Docente d) {
        String sql = "SELECT d.codigo,u.correo,u.contrasenia,d.nombre,d.apellido,d.documento,sexo,estadoCivil,escolaridad,fechaNac,direccion,telefono,telefonoMovil FROM docente d, usuario u WHERE d.idDocente = '"+d.getId()+"' AND u.codDocente = '"+d.getId()+"';";
        ConexionMysql.conectar();
        ArrayList r = ConexionMysql.getConsultaSQL(sql);
        ConexionMysql.desconectar();
        return r.get(0).toString();
    }
}
