<%-- 
    Document   : cargarEvento
    Created on : 8/06/2015, 10:47:57 AM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>
<%
    docente.setId(session.getAttribute("idDocente").toString());
    String retur = facade.cargarEventos(docente);
    String ret = "";
    String evt = "";
    if(!retur.equals("error")){
        ret = retur.split(";")[0];
        evt = retur.split(";")[1];
    }
    session.setAttribute("eventos", evt);
    session.setAttribute("tablaEventos", ret);
    response.sendRedirect("eventos.jsp");
    %>
