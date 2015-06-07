<%-- 
    Document   : leerArticulo
    Created on : 4/06/2015, 09:20:00 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="articulo" class="com.cvsis.dto.Articulo" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>
<%
    String btnn = request.getParameter("requerimiento");
    String btn = btnn.split("-")[0];
    if(btn.equals("agregarArticulo")){
        String titulo = request.getParameter("titulo");
        String año= request.getParameter("anio");
        String pagInicio= request.getParameter("pagIni");
        String pagFin= request.getParameter("pagFin");
        String revista= request.getParameter("revista");
        String issn= request.getParameter("issn");
        String idioma= request.getParameter("idioma");
        String volumen= request.getParameter("volumen");
        String pais= request.getParameter("pais");
        String medio= request.getParameter("medio");
        
        if(!titulo.isEmpty() || !año.isEmpty() || !pagInicio.isEmpty() || !pagFin.isEmpty() || !revista.isEmpty() || !issn.isEmpty()
                || !idioma.isEmpty() || !volumen.isEmpty() || !pais.isEmpty() || !medio.isEmpty()){
            articulo.setAño(año);
            articulo.setIdioma(idioma);
            articulo.setIssn(issn);
            articulo.setMedio(medio);
            articulo.setPagFin(pagFin);
            articulo.setPagInicio(pagInicio);
            articulo.setPais(pais);
            articulo.setRevista(revista);
            articulo.setTitulo(titulo);
            articulo.setVolumen(volumen);
            
            docente.setId(session.getAttribute("idDocente").toString());
            
            String dele = facade.agregarArticulo(articulo,docente);
            
            if(!dele.equals("error")){
                session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">"+dele+"</div>");
                response.sendRedirect("cargarArticulos.jsp");
            }
            else{
                session.setAttribute("Mensaje", "<div class=\"alert alert-warning\" role=\"alert\">Inconsistencias</div>");
                response.sendRedirect("articulos.jsp");
            }
        }
    }
    else{
        if(btn.equals("eliminarArticulo")){
            String pos = btnn.split("-")[1];
            String art[] = session.getAttribute("articulos").toString().split(",");
            String arti = art[Integer.parseInt(pos)];
            articulo.setId(arti);
            docente.setId(session.getAttribute("idDocente").toString());
            String dele = facade.eliminarArticulo(articulo,docente);
            session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">"+dele+"</div>");
            response.sendRedirect("cargarArticulos.jsp");
        }
    }
    %>