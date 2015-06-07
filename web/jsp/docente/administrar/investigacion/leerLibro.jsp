<%-- 
    Document   : leerLibro
    Created on : 6/06/2015, 07:35:26 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="libro" class="com.cvsis.dto.Libro" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>
<%
    String btnn = request.getParameter("requerimiento");
    String btn = btnn.split("-")[0];
    if(btn.equals("agregarLibro")){
        String titulo = request.getParameter("titulo");
        String editorial = request.getParameter("editorial");
        String anio = request.getParameter("anio");
        String mes = request.getParameter("mes");
        String isbn = request.getParameter("isbn");
        String pais = request.getParameter("pais");
        String medio = request.getParameter("medio");
        String estilo = request.getParameter("estilo");
        
        if(!titulo.isEmpty() || !editorial.isEmpty() || !anio.isEmpty() || !mes.isEmpty() || !isbn.isEmpty() || !pais.isEmpty() || !medio.isEmpty() || !estilo.isEmpty()){
            libro.setAnio(anio);
            libro.setEstilo(estilo);
            libro.setIsbn(isbn);
            libro.setMedio(medio);
            libro.setMes(mes);
            libro.setPais(pais);
            libro.setTitulo(titulo);
            libro.setEditorial(editorial);
            docente.setId(session.getAttribute("idDocente").toString());
            
            String dele = facade.agregarLibro(libro,docente);
            
            if(!dele.equals("error")){
                session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">"+dele+"</div>");
                response.sendRedirect("cargarLibros.jsp");
            }
            else{
                session.setAttribute("Mensaje", "<div class=\"alert alert-warning\" role=\"alert\">Inconsistencias</div>");
                response.sendRedirect("libros.jsp");
            }
        }
    }
    else{
        if(btn.equals("eliminarLibro")){
            String pos = btnn.split("-")[1];
            String art[] = session.getAttribute("libros").toString().split(",");
            String arti = art[Integer.parseInt(pos)];
            libro.setId(arti);
            docente.setId(session.getAttribute("idDocente").toString());
            String dele = facade.eliminarLibro(libro,docente);
            session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">"+dele+"</div>");
            response.sendRedirect("cargarLibros.jsp");
        }
    }
    %>
