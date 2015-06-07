<%-- 
    Document   : cargarArticulos
    Created on : 6/06/2015, 06:26:49 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>
<%
    docente.setId(session.getAttribute("idDocente").toString());
    String retur = facade.cargarArticulos(docente);
    String ret = "";
    String art = "";
    if(!retur.equals("error")){
        ret = retur.split(";")[0];
        art = retur.split(";")[1];
    }
    session.setAttribute("articulos", art);
    session.setAttribute("tablaArticulos", ret);
    response.sendRedirect("articulos.jsp");
    %>
