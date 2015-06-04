<%-- 
    Document   : leerFormacion
    Created on : 2/06/2015, 09:43:13 PM
    Author     : Manuel
--%>
<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>
<jsp:useBean id="tesis" class="com.cvsis.dto.Tesis" scope="session"></jsp:useBean>
<%
    String btnn = request.getParameter("requerimiento");
    String btn = btnn.split("-")[0];
    
    if(btn.equals("agregarTesis")){
        try{
            String tipoTesis = request.getParameter("tipoTesis");
            String nomEstudiante = request.getParameter("nomEstudiante");
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            String nomProyecto = request.getParameter("nomProyecto");
            String tipoDeTesis = request.getParameter("tipoDeTesis");
            String institucion = request.getParameter("institucion");
            String programa = request.getParameter("programa");
            String estadoTesis = request.getParameter("estadoTesis");
            String fechaIni = request.getParameter("fechaIni");
            String fechaFin = request.getParameter("fechaFin");
            
            if(!tipoTesis.isEmpty() || !nomEstudiante.isEmpty() || !tipoDeTesis.isEmpty() || !institucion.isEmpty() || !programa.isEmpty() || !estadoTesis.isEmpty() || !fechaIni.isEmpty() || !fechaFin.isEmpty()){
                tesis.setCedula(cedula);
                tesis.setEstadoTesis(estadoTesis);
                tesis.setFechaFin(fechaFin);
                tesis.setFechaIni(fechaIni);
                tesis.setInstitucion(institucion);
                tesis.setNomEstudiante(nomEstudiante);
                tesis.setNomProyecto(nomProyecto);
                tesis.setPrograma(programa);
                tesis.setTipoDeTesis(tipoDeTesis);
                tesis.setTipoTesis(tipoTesis);
            
                docente.setId(session.getAttribute("idDocente").toString());
                
                String resp = facade.agregarTesis(tesis, docente);
                if(!resp.equals("error")){
                    session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">"+resp+"</div>");
                    response.sendRedirect("cargarFormacion.jsp");
                }
                else{
                    session.setAttribute("Mensaje", "<div class=\"alert alert-warning\" role=\"alert\">Inconsistencias</div>");
                    response.sendRedirect("formacion.jsp");
                }
            }
             else{
                    session.setAttribute("Mensaje", "<div class=\"alert alert-warning\" role=\"alert\">Inconsistencias, datos vacios</div>");
                    response.sendRedirect("formacion.jsp");
                }
                
            
            
        }catch(Exception e){
            session.setAttribute("Mensaje", "<div class=\"alert alert-danger\" role=\"alert\">Error en los datos</div>");
            response.sendRedirect("formacion.jsp");
        }
    }
    else{
        if(btn.equals("eliminarTesis")){
            String pos = btnn.split("-")[1];
            System.out.println("la posicion es: "+pos);
            String mat[] = session.getAttribute("formacion").toString().split(",");
            String mate = mat[Integer.parseInt(pos)];
            System.out.println("la tesis es: "+mate);
            tesis.setId(mate);
            docente.setId(session.getAttribute("idDocente").toString());
            String dele = facade.eliminarTesis(tesis,docente);
            session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">"+dele+"</div>");
            response.sendRedirect("cargarFormacion.jsp");
        }
    }
    %>
