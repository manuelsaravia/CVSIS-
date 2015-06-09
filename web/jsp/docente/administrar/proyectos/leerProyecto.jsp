<%-- 
    Document   : leerProyecto
    Created on : 8/06/2015, 07:37:01 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="proyecto" class="com.cvsis.dto.Proyecto" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>
<%
    String btnn = request.getParameter("requerimiento");
    String btn = btnn.split("-")[0];
    if(btn.equals("agregarProyecto")){
        String tipo = request.getParameter("tipo");
        String nombre = request.getParameter("nombre");
        String codigo = request.getParameter("codigo");
        String fechaIni = request.getParameter("fechaIni");
        String fechaFin = request.getParameter("fechaFin");
        String resumen = request.getParameter("resumen");
        String institucion = request.getParameter("institucion");
        String producto = request.getParameter("producto");
        
        if(!tipo.isEmpty() || !nombre.isEmpty() || !codigo.isEmpty() || !fechaIni.isEmpty() || !fechaFin.isEmpty() || !resumen.isEmpty()
                || !institucion.isEmpty() || !producto.isEmpty()){
            
            proyecto.setCodigo(codigo);
            proyecto.setFechaIni(fechaIni);
            proyecto.setFechafin(fechaFin);
            proyecto.setInstitucion(institucion);
            proyecto.setNombre(nombre);
            proyecto.setProducto(producto);
            proyecto.setResumen(resumen);
            proyecto.setTipo(tipo);
            docente.setId(session.getAttribute("idDocente").toString());
            
            String dele = facade.agregarProyecto(proyecto,docente);
            
            if(!dele.equals("error")){
                session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">"+dele+"</div>");
                response.sendRedirect("cargarProyectos.jsp");
            }
            else{
                session.setAttribute("Mensaje", "<div class=\"alert alert-warning\" role=\"alert\">Inconsistencias</div>");
                response.sendRedirect("proyecto.jsp");
            }
        }
    }
    else{
        if(btn.equals("eliminarProyecto")){
            String pos = btnn.split("-")[1];
            String art[] = session.getAttribute("proyectos").toString().split(",");
            String arti = art[Integer.parseInt(pos)];
            proyecto.setId(arti);
            docente.setId(session.getAttribute("idDocente").toString());
            String dele = facade.eliminarProyecto(proyecto,docente);
            session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">"+dele+"</div>");
            response.sendRedirect("cargarProyectos.jsp");
        }
    }
    %>
