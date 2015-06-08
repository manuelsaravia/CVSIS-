<%-- 
    Document   : leerSpin
    Created on : 8/06/2015, 04:15:23 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="com.cvsis.facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="spin" class="com.cvsis.dto.SpinOff" scope="session"></jsp:useBean>
<jsp:useBean id="docente" class="com.cvsis.dto.Docente" scope="session"></jsp:useBean>
<%
    String btnn = request.getParameter("requerimiento");
    String btn = btnn.split("-")[0];
    if(btn.equals("agregarSpin")){
        String empresa = request.getParameter("empresa");
        String nit = request.getParameter("nit");
        String producto = request.getParameter("producto");
        String registro = request.getParameter("registro");
        String representante = request.getParameter("representante");
        String cedula = request.getParameter("cedula");
        String fecha = request.getParameter("fecha");
        
        if(!empresa.isEmpty() || !nit.isEmpty() || !producto.isEmpty() || !representante.isEmpty() || !cedula.isEmpty() || !fecha.isEmpty()){
            
            if(registro.isEmpty()){
                registro = "-";
            }
            spin.setCedula(cedula);
            spin.setEmpresa(empresa);
            spin.setNit(nit);
            spin.setProducto(producto);
            spin.setRegistro(registro);
            spin.setRepresentante(representante);
            spin.setFecha(fecha);
            docente.setId(session.getAttribute("idDocente").toString());
            
            String dele = facade.agregarSpin(spin,docente);
            
            if(!dele.equals("error")){
                session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">"+dele+"</div>");
                response.sendRedirect("cargarSpins.jsp");
            }
            else{
                session.setAttribute("Mensaje", "<div class=\"alert alert-warning\" role=\"alert\">Inconsistencias</div>");
                response.sendRedirect("spinOff.jsp");
            }
        }
    }
    else{
        if(btn.equals("eliminarSpin")){
            String pos = btnn.split("-")[1];
            String art[] = session.getAttribute("spins").toString().split(",");
            String arti = art[Integer.parseInt(pos)];
            spin.setId(arti);
            docente.setId(session.getAttribute("idDocente").toString());
            String dele = facade.eliminarSpin(spin,docente);
            session.setAttribute("Mensaje", "<div class=\"alert alert-success\" role=\"alert\">"+dele+"</div>");
            response.sendRedirect("cargarSpins.jsp");
        }
    }
    %>
