<%-- 
    Document   : spinOff
    Created on : 25/05/2015, 08:28:15 AM
    Author     : Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--Codificación de caracteres-->
        <meta charset="utf-8">
        <!--Titulo-->
        <title>CVSIS - Sistema de Información</title>
        <!--Visualización-->
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta content="width=device-width, heigth=device-height, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!--Información-->
        <meta content="CVSIS" name="description">
        <meta content="Megaterios" name="author">
        <meta content="index, follow" name="robots">
        <!--Normalizar estilos-->
        <link href="../../../../css/normalize.css" rel="stylesheet">
        <!--Bootstrap-->
        <link href="../../../../css/bootstrap.css" rel="stylesheet">
        <link href="../../../../css/bootstrap-theme.css" rel="stylesheet">
        <link href="../../../../css/bootstrap-formhelpers.css" rel="stylesheet">
        <!-- Core CSS - Include with every page -->
        <link href="../../../../css/bootstrap.min.css" rel="stylesheet">
        <link href="../../../../font-awesome/css/font-awesome.css" rel="stylesheet">

        <!-- Page-Level Plugin CSS - Dashboard -->
        <link href="../../../../css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
        <link href="../../../../css/plugins/timeline/timeline.css" rel="stylesheet">

        <!-- SB Admin CSS - Include with every page -->
        <link href="../../../../css/sb-admin.css" rel="stylesheet">

        <!--Hojas de estilo-->
        <link href="../../../../css/style.css" rel="stylesheet">
        <!--Iconos-->
        <link href="../../../../img/favicon.ico" rel="shortcut icon">
    </head>
    <body>
        <div  class="container">
        <header>
                <figure>
                    <img alt="CVSIS" class="img-responsive" id="banner_cursoft" src="../../../../img/banne_cursoft.png">
                </figure>
            </header>

            <br>
            
                <div class="row">
                    
                    <div class="col-xs-6 col-sm-4"></div>
                    <div class="col-xs-6 col-sm-4 hidden-xs"></div>
                    <div class="col-xs-6 col-sm-4">
                        <div class="well well-sm" align="right">
                            <% out.print(session.getAttribute("nombre") + " " + session.getAttribute("apellido"));%>
                            <a href="../../../usuario/iniciarSesion.jsp">  (Cerrar sesión)</a>
                        </div>
                            
                    </div>
                </div>
            
                            <div class="row">
                                <br>
                <%
                    if (session.getAttribute("Mensaje") == null) {
                        session.setAttribute("Mensaje", "");
                    }
                    out.print(session.getAttribute("Mensaje"));
                    session.setAttribute("MensajeRecuperar", "");
                    session.setAttribute("Mensaje", "");
                %>
                                <div class="col-md-3" id="menu">
                                    
                            
                                <ul class="nav nav-pills nav-stacked">
                                    <li role="presentation" class="active">
                                        <a href="#">Administrar</a>
                                        <ul class="nav nav-tabs-justified nav-second-level">
                                            <li class="dropdown">
                                               <a class="dropdown-toggle" data-toggle="dropdown" href="#">Docencía
                                               <span class="caret"></span></a>
                                               <ul class="dropdown-menu">
                                                   <li><a href="../docencia/cargarMaterias.jsp">Materias</a></li>
                                                   <li><a href="../docencia/cargarFormacion.jsp">Formación</a></li>
                                               </ul>
                                               
                                            </li>
                                            <li class="dropdown">
                                               <a class="dropdown-toggle" data-toggle="dropdown" href="#">Investigacion
                                               <span class="caret"></span></a>
                                               <ul class="dropdown-menu">
                                                   <li><a href="../investigacion/cargarGrupos.jsp">Grupos de Investigación</a></li>
                                                   <li><a href="../investigacion/cargarArticulos.jsp">Produccion Bibliografica</a></li>
                                                   <li><a href="../investigacion/cargarEventos.jsp">Eventos</a></li>
                                               </ul>
                                               
                                            </li>
                                            <li class="dropdown">
                                               <a class="dropdown-toggle" data-toggle="dropdown" href="#">Produccion Tecnologica
                                               <span class="caret"></span></a>
                                               <ul class="dropdown-menu">
                                                   <li><a href="../tecnologica/cargarConsultorias.jsp">Consultoria-Asesoria</a></li>
                                                   <li><a href="../tecnologica/cargarSoftwares">Software</a></li>
                                                   <li><a href="../tecnologica/cargarSpins">Spin Off</a></li>
                                               </ul>
                                               
                                            </li>
                                            <li>
                                                <a href="../proyectos/cargarProyectos.jsp">Proyectos</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            
                                
                            </div>
                                <!-- Aca esta todo el contenido de la pagina -->
                                
                                <div class="col-md-9">
                                    <ol class="breadcrumb">
                                        <li><a href="../../inicioDocente.jsp">Home</a></li>
                                        <li class="active">Spins Off</li>
                                        
                                    </ol>
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                         
                                            
                                                    <div class="row">
                                                        <form action="leerSpin.jsp" method="post" role="form" class="form-horizontal">
                                                                                                       <div align="center">
                                                                                                           <div class="col-md-12 col-md-offset-0">
                                                                                                               <div class="panel panel-default">
                                                                                                                   <!-- Default panel contents -->
                                                                                                                   <div class="panel-heading">Spins Off</div>
                                                                                                                   <div class="panel-body">
                                                                                                                       <!-- Table -->
                                                                                                                       <div class="table-responsive">
                                                                                                                           <div align="center">
                                                                                                                               <table class="table">
                                                                                                                                   <thead>
                                                                                                                                       <tr>
                                                                                                                                           <th>Empresa</th> 
                                                                                                                                           <th>Nit o Registro</th>
                                                                                                                                           <th>Fecha Registro</th>
                                                                                                                                           <th>Productos</th>
                                                                                                                                           <th>Registro Producto</th>
                                                                                                                                           <th>Representante Legal</th>
                                                                                                                                           <th>Cedula Representante</th>
                                                                                                                                           <th></th>
                                                                                                                                           
                                                                                                                                       </tr>
                                                                                                                                   </thead>
                                                                                                                                   <tbody class="tablas"> 
                                                                                                                                       <% out.println(session.getAttribute("tablaSpins").toString()); %>
                                                                                                                                       <tr>       
                                                                                                                                           
                                                                                                                                           <td>
                                                                                                                                               <div class="row">
                                                                                                                                                    <div class="col-lg-12">
                                                                                                                                                        <input class="form-control" id="empresa" name="empresa" placeholder="Tigo" type="text">
                                                                                                                                                    </div>
                                                                                                                                                </div>
                                                                                                                                           </td>
                                                                                                                                           <td>
                                                                                                                                               <div class="row">
                                                                                                                                                    <div class="col-lg-12">
                                                                                                                                                        <input class="form-control" id="nit" name="nit" placeholder="8473627129" type="number">
                                                                                                                                                    </div>
                                                                                                                                                </div>
                                                                                                                                           </td>
                                                                                                                                           <td>
                                                                                                                                               <div class="row">
                                                                                                                                                    <div class="col-lg-12">
                                                                                                                                                        <input class="form-control" id="fecha" name="fecha" placeholder="2/2015" type="text">
                                                                                                                                                    </div>
                                                                                                                                                </div>
                                                                                                                                           </td>
                                                                                                                                           <td>
                                                                                                                                               <select class="form-control" id="producto" name="producto">
                                                                                                                                                   <option value="Si">Si</option>
                                                                                                                                                   <option value="No">No</option>
                                                                                                                                               </select>
                                                                                                                                           </td>
                                                                                                                                           <td>
                                                                                                                                               <div class="row">
                                                                                                                                                    <div class="col-lg-12">
                                                                                                                                                        <input class="form-control" id="registro" name="registro" placeholder="445833" type="number">
                                                                                                                                                    </div>
                                                                                                                                                </div>
                                                                                                                                           </td>
                                                                                                                                           <td>
                                                                                                                                               <div class="row">
                                                                                                                                                    <div class="col-lg-12">
                                                                                                                                                        <input class="form-control" id="representante" name="representante" placeholder="Esteban Nuñez" type="text">
                                                                                                                                                    </div>
                                                                                                                                                </div>
                                                                                                                                           </td>
                                                                                                                                           <td>
                                                                                                                                               <div class="row">
                                                                                                                                                    <div class="col-lg-12">
                                                                                                                                                        <input class="form-control" id="cedula" name="cedula" placeholder="88214808" type="number">
                                                                                                                                                    </div>
                                                                                                                                                </div>
                                                                                                                                           </td>
                                                                                                                                           
                                                                                                                                           <td></td>
                                                                                                                                       </tr>
                                                                                                                                   </tbody>
                                                                                                                               </table>
                                                                                                                               <div class="btn-group">
                                                                                                                                   <button class="btn btn-success" id="agregar" name = "requerimiento" value="agregarSpin-0" type="submit">Agregar Spin
                                                                                                                                       <span class="glyphicon glyphicon-plus-sign"></span>
                                                                                                                                   </button>
                                                                                                                               </div>
                                                                                                                           </div>
                                                                                                                       </div>
                                                                                                                   </div>
                                                                                                               </div>
                                                                                                           </div>
                                                                                                       </div>
                                                        </form>
                                                                                                   
                                                    </div>
                                                </div>
                                            </div>
                                              
                                            
                                        </div>
                                    </div>
                                </div>
                                
                                
                                
                       
                            
                            
          
        
          
        
         <div id="footer" align="center">                
            <footer>
                <p><strong>Copyright © 2014. Programa de Ingeniería de Sistemas - UFPS</strong></p>
                <p>Desarrollado por: <span class="glyphicon glyphicon-user"></span><strong> Manuel Saravia</strong></p>
            </footer>
            </div>
        
        
        
        
        
       <script src="../../../../js/jquery.js"></script>
	<script src="../../../../js/bootstrap.min.js"></script>
                            
                            
                            
                            
    </body>
</html>
