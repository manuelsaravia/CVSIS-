<%-- 
    Document   : leerConsultoria
    Created on : 8/06/2015, 06:19:30 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="consultoria" class="com.cvsis.dto.Consultoria" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>
<%
    String btnn = request.getParameter("requerimiento");
    String btn = btnn.split("-")[0];
    if(btn.equals("agregarConsultoria")){
        String tipo = request.getParameter("tipo");
        String nombre = request.getParameter("nombre");
        String pais = request.getParameter("pais");
        String contrato = request.getParameter("contrato");
        String institucion = request.getParameter("institucion");
        String duracion = request.getParameter("duracion");
        String fecha = request.getParameter("fecha");
        String sector = request.getParameter("sector");
        
        if(!tipo.isEmpty() || !nombre.isEmpty() || !pais.isEmpty() || !contrato.isEmpty() || !institucion.isEmpty() || !fecha.isEmpty()
                || !duracion.isEmpty() || !sector.isEmpty()){
            
            consultoria.setContrato(contrato);
            consultoria.setDuracion(duracion);
            consultoria.setFecha(fecha);
            consultoria.setInstitucion(institucion);
            consultoria.setNombre(nombre);
            consultoria.setPais(pais);
            consultoria.setSector(sector);
            consultoria.setTipo(tipo);
            docente.setId(session.getAttribute("idDocente").toString());
            
            String dele = facade.agregarConsultoria(consultoria,docente);
            
            if(!dele.equals("error")){
                session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">"+dele+"</div>");
                response.sendRedirect("cargarConsultorias.jsp");
            }
            else{
                session.setAttribute("Mensaje", "<div class=\"alert alert-warning\" role=\"alert\">Inconsistencias</div>");
                response.sendRedirect("consultoria.jsp");
            }
        }
    }
    else{
        if(btn.equals("eliminarConsultoria")){
            String pos = btnn.split("-")[1];
            String art[] = session.getAttribute("consultorias").toString().split(",");
            String arti = art[Integer.parseInt(pos)];
            consultoria.setId(arti); 
            docente.setId(session.getAttribute("idDocente").toString());
            String dele = facade.eliminarConsultoria(consultoria,docente);
            session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">"+dele+"</div>");
            response.sendRedirect("cargarConsultorias.jsp");
        }
    }
    %>
