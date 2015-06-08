<%-- 
    Document   : cargarSoftwares
    Created on : 8/06/2015, 12:59:41 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>
<%
    docente.setId(session.getAttribute("idDocente").toString());
    String retur = facade.cargarSoftwares(docente);
    String ret = "";
    String sw = "";
    if(!retur.equals("error")){
        ret = retur.split(";")[0];
        sw = retur.split(";")[1];
    }
    session.setAttribute("softwares", sw);
    session.setAttribute("tablaSoftwares", ret);
    response.sendRedirect("software.jsp");
    %>