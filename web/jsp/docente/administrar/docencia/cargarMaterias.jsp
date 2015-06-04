<%-- 
    Document   : cargarMaterias
    Created on : 1/06/2015, 09:04:38 PM
    Author     : Manuel
--%>
<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>
<%
    docente.setId(session.getAttribute("idDocente").toString());
    String retur = facade.cargarMaterias(docente);
    String ret = "";
    String mat = "";
    if(!retur.equals("error")){
        ret = retur.split(";")[0];
        mat = retur.split(";")[1];
    }
    session.setAttribute("materias", mat);
    session.setAttribute("tablaMaterias", ret);
    response.sendRedirect("materias.jsp");
    %>
