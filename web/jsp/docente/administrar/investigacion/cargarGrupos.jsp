<%-- 
    Document   : cargarGrupos
    Created on : 4/06/2015, 09:31:14 AM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>

<%
    docente.setId(session.getAttribute("idDocente").toString());
    String retur = facade.cargarGrupos(docente);
    String ret = "";
    String gru = "";
    if(!retur.equals("error")){
        ret = retur.split(";")[0];
        gru = retur.split(";")[1];
    }
    session.setAttribute("grupos", gru);
    session.setAttribute("tablaGrupos", ret);
    response.sendRedirect("grupos.jsp");
    %>
