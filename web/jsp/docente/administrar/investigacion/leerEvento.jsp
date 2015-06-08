<%-- 
    Document   : leerEvento
    Created on : 6/06/2015, 10:34:15 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="evento" class="com.cvsis.dto.Evento" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>
<%
    String btnn = request.getParameter("requerimiento");
    String btn = btnn.split("-")[0];
    if(btn.equals("agregarEvento")){
        String nombre = request.getParameter("nombreEvento");
        String tipo = request.getParameter("tipo");
        String ambito = request.getParameter("ambito");
        String lugar = request.getParameter("lugar");
        String fechaIni = request.getParameter("fechaIni");
        String fechaFin = request.getParameter("fechaFin");
        String vinculacion = request.getParameter("vinculacion");
        String institucion = request.getParameter("institucion");
        
        if(!nombre.isEmpty() || !tipo.isEmpty() || !ambito.isEmpty() || !lugar.isEmpty() || !fechaIni.isEmpty() || !fechaFin.isEmpty() || !vinculacion.isEmpty() || !institucion.isEmpty()){
            
            evento.setAmbito(ambito);
            evento.setFechaFin(fechaFin);
            evento.setFechaIni(fechaIni);
            evento.setInstitucion(institucion);
            evento.setLugar(lugar);
            evento.setNombre(nombre);
            evento.setTipo(tipo);
            evento.setVinculacion(vinculacion);
            docente.setId(session.getAttribute("idDocente").toString());
            
            String dele = facade.agregarEvento(evento,docente);
            
            if(!dele.equals("error")){
                session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">"+dele+"</div>");
                response.sendRedirect("cargarEventos.jsp");
            }
            else{
                session.setAttribute("Mensaje", "<div class=\"alert alert-warning\" role=\"alert\">Inconsistencias</div>");
                response.sendRedirect("eventos.jsp");
            }
        }
    }
    else{
        
        if(btn.equals("eliminarEvento")){
            String pos = btnn.split("-")[1];
            String evt[] = session.getAttribute("eventos").toString().split(",");
            String evnt = evt[Integer.parseInt(pos)];
            evento.setId(evnt);
            docente.setId(session.getAttribute("idDocente").toString());
            String dele = facade.eliminarEvento(evento,docente);
            session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">"+dele+"</div>");
            response.sendRedirect("cargarEventos.jsp");
        }
    }
    %>
