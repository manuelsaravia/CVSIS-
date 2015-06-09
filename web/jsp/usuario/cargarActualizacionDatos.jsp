<%-- 
    Document   : cargarActualizacionDatos
    Created on : 9/06/2015, 12:22:37 AM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>
<%
    docente.setId(session.getAttribute("idDocente").toString());
    String retur = facade.consultarDatos(docente);
    String datos[] = retur.split("-");
    session.setAttribute("codigo","\""+ datos[0]+"\"");
    session.setAttribute("correo","\""+ datos[1]+"\"");
    session.setAttribute("contrasenia", "\""+datos[2]+"\"");
    session.setAttribute("nombre", "\""+datos[3]+"\"");
    session.setAttribute("apellido", "\""+datos[4]+"\"");
    session.setAttribute("documento", "\""+datos[5]+"\"");
    session.setAttribute("sexo", "\""+datos[6]+"\"");
    session.setAttribute("estadoCivil","\""+ datos[7]+"\"");
    session.setAttribute("escolaridad","\""+ datos[8]+"\"");
    session.setAttribute("fechaNac","\""+ datos[9]+"\"");
    session.setAttribute("direccion","\""+ datos[10]+"\"");
    session.setAttribute("telefono","\""+ datos[11]+"\"");
    session.setAttribute("movil", "\""+datos[12]+"\"");
    
    
    response.sendRedirect("actualizarse.jsp");
    %>
