<%-- 
    Document   : generarListado
    Created on : 8/06/2015, 09:44:15 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>
<%
    docente.setId(session.getAttribute("idDocente").toString());
    /* retur = facade.generarListado(docente);
    
    String ret = "";
    String art = "";
    if(!retur.equals("error")){
        ret = retur.split(";")[0];
        art = retur.split(";")[1];
    }
    session.setAttribute("spins", art);
    session.setAttribute("tablaSpins", ret);
    response.sendRedirect("spinOff.jsp");*/
    %>
