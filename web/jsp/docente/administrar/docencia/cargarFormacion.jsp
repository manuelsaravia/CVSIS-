<%-- 
    Document   : cargarFormacion
    Created on : 3/06/2015, 05:07:07 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>

<%
    docente.setId(session.getAttribute("idDocente").toString());
    String retur = facade.cargarFormacion(docente);
    String ret ="";
    String tes = "";
    if(!retur.equals("error")){
        ret = retur.split(";")[0];
        tes = retur.split(";")[1];
    }
    session.setAttribute("formacion", tes);
    session.setAttribute("tablaFormacion", ret);
    response.sendRedirect("formacion.jsp");
    %>
