<%-- 
    Document   : leerActualizacion
    Created on : 9/06/2015, 12:52:00 AM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="usuario" class="com.cvsis.dto.Usuario" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>

<%
    String btn = request.getParameter("requerimiento");
    if(btn.equals("actualizarse")){
        try{
            String codigo = request.getParameter("codigo");
            String correo = request.getParameter("correo");
            String contrasenia = request.getParameter("contrasenia");
            String nombre = request.getParameter("nombre").toUpperCase();
            String apellido= request.getParameter("apellido").toUpperCase();
            String documento= request.getParameter("documento");
            String sexo= request.getParameter("sexo");
            String estadoCivil= request.getParameter("estadoCivil");
            String escolaridad= request.getParameter("escolaridad");
            String fechaNac= request.getParameter("fechaNacimiento");
            String direccion= request.getParameter("direccion");
            String telefono= request.getParameter("telefono");
            String telefonoMovil= request.getParameter("telefonoMovil");
            
            int cod= Integer.parseInt(codigo);
            int doc= Integer.parseInt(documento);
            int tel= Integer.parseInt(telefono);
            int mov= Integer.parseInt(telefonoMovil);
            
            usuario.setCorreo(correo);
            usuario.setContrasenia(contrasenia);
            docente.setId(session.getAttribute("idDocente").toString());
            docente.setCodigo(codigo);
            docente.setNombre(nombre);
            docente.setApellido(apellido);
            docente.setDocumento(documento);
            docente.setDireccion(direccion);
            docente.setEscolaridad(escolaridad);
            docente.setEstadoCivil(estadoCivil);
            docente.setFechaNac(fechaNac);
            docente.setSexo(sexo);
            docente.setTelefono(telefono);
            docente.setTelefonoMovil(telefonoMovil);
            
            boolean b = facade.actualizarUsuario(usuario, docente);
            
            //Revisar cuando se hace un registro. revisar conexion. 
            if(b){
                session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">Actualizacion Exitosa</div>");
                session.setAttribute("nombre", docente.getNombre());
                session.setAttribute("apellido", docente.getApellido());
                response.sendRedirect("../docente/inicioDocente.jsp");
            }
            else{
                session.setAttribute("Mensaje", "<div class=\"alert alert-warning\" role=\"alert\">Inconsistencia en sus Datos</div>");
                response.sendRedirect("actualizarse.jsp");
            }
            
        }catch(Exception e){
            session.setAttribute("Mensaje", "<div class=\"alert alert-danger\" role=\"alert\">Verifique sus Datos</div>");
            response.sendRedirect("actualizarse.jsp");
        }
    }
    else{
        response.sendRedirect("../docente/inicioDocente.jsp");
    }
    
    
    %>
