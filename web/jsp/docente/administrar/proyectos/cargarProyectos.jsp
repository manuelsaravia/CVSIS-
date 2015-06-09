<%-- 
    Document   : cargarProyectos
    Created on : 8/06/2015, 07:16:50 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>
<%
    docente.setId(session.getAttribute("idDocente").toString());
    String retur = facade.cargarProyectos(docente);
    String ret = "";
    String art = "";
    String pro = facade.listarProductos(docente);
    if(!retur.equals("error")){
        ret = retur.split(";")[0];
        art = retur.split(";")[1];
    }
    session.setAttribute("productosProyecto", pro);
    session.setAttribute("proyectos", art);
    session.setAttribute("tablaProyectos", ret);
    response.sendRedirect("proyecto.jsp");
    %>
