<%-- 
    Document   : validarSesion
    Created on : 24/05/2015, 08:38:55 PM
    Author     : Manuel
--%>
<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="user" class="com.cvsis.dto.Usuario" scope="session"></jsp:useBean>

<%
    String tipo = request.getParameter("tipo");
    String correo = request.getParameter("correo");
    String contrasenia = request.getParameter("contrasenia");
    
    if(tipo.equals("1")){
        if(!correo.isEmpty() || !contrasenia.isEmpty()){
        user.setCorreo(correo);
        user.setContrasenia(contrasenia);
        String datos = facade.validarSesion(user);
        
        if(!datos.equals("error")){
            String id = datos.split("-")[0];
            String nom = datos.split("-")[1];
            String apell = datos.split("-")[2];
        
            session.setAttribute("idDocente", id);
            session.setAttribute("nombre", nom);
            session.setAttribute("apellido", apell);
            
            //Creacion de Sesiones que se necesitaran a lo largo de la ejecucion
            session.setAttribute("tablaMaterias", "");
            session.setAttribute("tablaFormacion", "");
            session.setAttribute("tablaGrupos", "");
            session.setAttribute("tablaArticulos", "");
            session.setAttribute("tablaLibros", "");
            session.setAttribute("tablaEventos", "");
            session.setAttribute("tablaSoftwares", "");
            session.setAttribute("tablaSpins", "");
            session.setAttribute("tablaConsultorias", "");
            session.setAttribute("tablaProyectos", "");
            session.setAttribute("tablaListados", "");
            //Fin de sesiones
            
            
            response.sendRedirect("../docente/inicioDocente.jsp");
        }
        else{
            session.setAttribute("Mensaje", "<div class=\"alert alert-warning\" role=\"alert\">Datos Incorrectos</div>");
            response.sendRedirect("iniciarSesion.jsp");
        }
        }
        else{
            session.setAttribute("Mensaje", "<div class=\"alert alert-warning\" role=\"alert\">Inconsistencias</div>");
            response.sendRedirect("iniciarSesion.jsp");
        }
        
    }
    else{
        if(tipo.equals("2")){
            System.out.println("llego a tipo 2");
            if(!correo.isEmpty() || !contrasenia.isEmpty()){
            user.setCorreo(correo);
            user.setContrasenia(contrasenia);
            String datos = facade.validarSesionAdmin(user);
            System.out.println("datosss = "+datos);
            if(!datos.equals("error")){
                response.sendRedirect("inicioAdmin.jsp");
            }
            else{
                session.setAttribute("Mensaje", "<div class=\"alert alert-danger\" role=\"alert\">Datos Incorrectos</div>");
                response.sendRedirect("iniciarSesion.jsp");
            }
            }
            else{
                session.setAttribute("Mensaje", "<div class=\"alert alert-warning\" role=\"alert\">Inconsistencias</div>");
                response.sendRedirect("iniciarSesion.jsp");
            }
        }
    }
    
    %>
