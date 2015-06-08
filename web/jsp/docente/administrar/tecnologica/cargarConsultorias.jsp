<%-- 
    Document   : cargarConsultorias
    Created on : 8/06/2015, 06:48:59 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>
<%
    docente.setId(session.getAttribute("idDocente").toString());
    String retur = facade.cargarConsultorias(docente);
    String ret = "";
    String art = "";
    if(!retur.equals("error")){
        ret = retur.split(";")[0];
        art = retur.split(";")[1];
    }
    session.setAttribute("consultorias", art);
    session.setAttribute("tablaConsultorias", ret);
    response.sendRedirect("consultoria.jsp");
    %>
