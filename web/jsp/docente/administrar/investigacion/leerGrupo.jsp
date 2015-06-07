<%-- 
    Document   : leerGrupo
    Created on : 4/06/2015, 08:39:19 AM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="grupo" class="com.cvsis.dto.Grupo" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>

<%
    String btnn =request.getParameter("requerimiento");
    String btn = btnn.split("-")[0];
    if(btn.equals("agregarGrupo")){
        String nombre = request.getParameter("nombre");
        String semillero = request.getParameter("semillero");
        String clasificacion = request.getParameter("clasificacion");
        
        if(!nombre.isEmpty() || !semillero.isEmpty() || !clasificacion.isEmpty()){
            grupo.setNomGrupo(nombre);
            grupo.setSemillero(semillero);
            grupo.setClasificacion(clasificacion);
            docente.setId(session.getAttribute("idDocente").toString());
            String msg = facade.agregarGrupo(grupo,docente);
            
            if(!msg.equals("error")){
                session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">"+msg+"</div>");
                    response.sendRedirect("cargarGrupos.jsp");
                }
                else{
                    session.setAttribute("Mensaje", "<div class=\"alert alert-warning\" role=\"alert\">Inconsistencias</div>");
                    response.sendRedirect("grupos.jsp");
                }
        }
        else{
            session.setAttribute("Mensaje", "<div class=\"alert alert-warning\" role=\"alert\">Inconsistencias</div>");
            response.sendRedirect("grupos.jsp");
        }
    }
    else{
        if(btn.equals("eliminarGrupo")){
            String pos = btnn.split("-")[1];
            System.out.println("la posicion es: "+pos);
            String gru[] = session.getAttribute("grupos").toString().split(",");
            String grup = gru[Integer.parseInt(pos)];
            System.out.println("la materia es: "+grup);
            grupo.setId(grup);
            docente.setId(session.getAttribute("idDocente").toString());
            String dele = facade.eliminarGrupo(grupo,docente);
            session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">"+dele+"</div>");
            response.sendRedirect("cargarGrupos.jsp");
        }
    }
    
    %>
