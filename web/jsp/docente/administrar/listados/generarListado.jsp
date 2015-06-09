<%-- 
    Document   : generarListado
    Created on : 8/06/2015, 09:44:15 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>
<%
    docente.setId(session.getAttribute("idDocente").toString());
    String retur = facade.generarListado(docente);
     
    session.setAttribute("tablaListados", retur);
    response.sendRedirect("listados.jsp");
    %>
