<%-- 
    Document   : leerSoftware
    Created on : 8/06/2015, 12:34:46 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="sw" class="com.cvsis.dto.Software" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>
<%
    String btnn = request.getParameter("requerimiento");
    String btn = btnn.split("-")[0];
    if(btn.equals("agregarSoftware")){
        
        String tipo = request.getParameter("tipo");
        String nomReal = request.getParameter("nomReal");
        String anio = request.getParameter("anio");
        String sitio = request.getParameter("sitio");
        String nomCom = request.getParameter("nomCom");
        String contrato = request.getParameter("contrato");
        String registro = request.getParameter("registro");
        String resumen = request.getParameter("resumen");
        
        if(!tipo.isEmpty() || !anio.isEmpty() || !nomReal.isEmpty() || !sitio.isEmpty() || !nomCom.isEmpty() || !contrato.isEmpty()
                || !registro.isEmpty() || !resumen.isEmpty()){
            sw.setAnio(anio);
            sw.setContrato(contrato);
            sw.setNomCom(nomCom);
            sw.setNomReal(nomReal);
            sw.setRegistro(registro);
            sw.setResumen(resumen);
            sw.setSitio(sitio);
            sw.setTipo(tipo);
            
            docente.setId(session.getAttribute("idDocente").toString());
            
            String dele = facade.agregarSoftware(sw,docente);
            
            if(!dele.equals("error")){
                session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">"+dele+"</div>");
                response.sendRedirect("cargarSoftwares.jsp");
            }
            else{
                session.setAttribute("Mensaje", "<div class=\"alert alert-warning\" role=\"alert\">Inconsistencias</div>");
                response.sendRedirect("software.jsp");
            }
        }
    }
    else{
        if(btn.equals("eliminarSoftware")){
            String pos = btnn.split("-")[1];
            String art[] = session.getAttribute("softwares").toString().split(",");
            String arti = art[Integer.parseInt(pos)];
            sw.setId(arti);
            docente.setId(session.getAttribute("idDocente").toString());
            String dele = facade.eliminarSoftware(sw,docente);
            session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">"+dele+"</div>");
            response.sendRedirect("cargarSoftwares.jsp");
        }
    }
    %>
