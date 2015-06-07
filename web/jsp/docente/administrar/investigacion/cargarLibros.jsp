<%-- 
    Document   : cargarLibros
    Created on : 6/06/2015, 08:19:05 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>
<%
    docente.setId(session.getAttribute("idDocente").toString());
    String retur = facade.cargarLibros(docente);
    String ret = "";
    String art = "";
    if(!retur.equals("error")){
        ret = retur.split(";")[0];
        art = retur.split(";")[1];
    }
    session.setAttribute("libros", art);
    session.setAttribute("tablaLibros", ret);
    response.sendRedirect("libros.jsp");
    %>
