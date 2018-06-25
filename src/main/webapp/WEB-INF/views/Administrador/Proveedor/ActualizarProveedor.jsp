<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>

<%@ include file="../General/Css.jsp"%>


</head>
<body>

<!-- Left Panel -->

	<%@ include file="../General/LeftPanel.jsp"%>

    <!-- Right Panel -->

    <div id="right-panel" class="right-panel">
        <!-- Header-->
        <header id="header" class="header">
            <div class="header-menu">
                <div class="col-sm-7">
                    <a id="menuToggle" class="menutoggle pull-left"><i class="fa fa fa-tasks"></i></a>
                </div>                 
            </div>
        </header><!-- /header -->
        <!-- Header-->
        <div class="content mt-3">
            <div class="animated fadeIn">
                <div class="row">

                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">Actualizar Proveedor</strong>
                        </div>

                    	<div class="card-body">
                    
                    
               					<!-- Si hubo un error en el registro muestra el mensaje-->						
								<c:if test="${not empty wrong}">		            
		                        	<div class="sufee-alert alert with-close alert-danger alert-dismissible fade show">				                   	
				                    		<c:out value='${wrong}' />
				                    	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
											<span aria-hidden="true">&times;</span>
				                    	</button>
				                   </div>
							    </c:if>              
                        	                                               	
                        		<!-- Formulario -->
                        		<form:form id="formActualizarProveedor" action="editarProveedor" method="post" modelAttribute="proveedor">
                        		                 			
                        		    <form:hidden id="codigo" path="codigo" class="form-control" aria-invalid="false" required = "true" value="${proveedor.codigo}"/>   
                        		    
                        		    <input type="hidden" id="forma" class="form-control" aria-invalid="false" required = "true" value="${proveedor.formaPago}"/>
                        		                             		
                            		
                            		
                            		
                            		<div class="row form-group">
                                        <div class="col col-md-3">
                                        	<label for="email-input" class=" form-control-label">NIT Empresa</label>
                                        </div>
                                         <div class="col-12 col-md-9">
                                         	
                                         	<form:input id="nit_Empresa" path="nit_Empresa" class="form-control" placeholder="35678923" aria-invalid="false" required = "true"  value="${proveedor.nit_Empresa}"/>
                                        </div>
                                   </div>

                            
                                 <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Nombre Empresa</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	
                                    	<form:input id="nomEmpresa" path="nomEmpresa" class="form-control" placeholder="Colanta" aria-invalid="false" required = "true" value="${proveedor.nomEmpresa}"/>
                                    </div>
                                    
                                 </div>



                                  <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Nombre del Contacto</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	
                                    	<form:input id="nombreContacto" path="nombreContacto" class="form-control" placeholder="Juan Luis" aria-invalid="false" required = "true" value="${proveedor.nombreContacto}" />
                                    	
                                    </div>
                                </div>
                                  


                                <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Telefono</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	
                                    	<form:input id="telefono" path="telefono" class="form-control" placeholder="5825053" aria-invalid="false" required = "true" value="${proveedor.telefono}"/>
                                    </div>
                                </div>


                                 <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Correo Electronico</label></div>
                                    <div class="col-12 col-md-9">
                                    	
                                    	<form:input type="email" id="correoElectronico" path="correoElectronico" class="form-control" placeholder="JuanLuis@gmail.com" aria-invalid="false" required = "true" value="${correoElectronico}"/>
                                    </div>
                                </div>



                                <div class="row form-group">
                                    <div class="col col-md-3"><label for="select" class=" form-control-label">Forma de Pago</label></div>
                                    <div class="col-12 col-md-9">
                                     
                                       <form:select path="formaPago" id="formaPago" class="form-control">
				                        <form:option value="" label="Seleccione la forma de pago" />
				                        <form:options items="${formas}"/>
                                       
                                        
                                       </form:select>
                                    </div>
                                 </div>


                                	<!-- Boton para Eliminar los datos -->
                                	<button type="submit" class="btn btn-success">Actualizar</button>                                 
                            	 </form:form>                          
                        	</div>
                        </div>
                    </div>
                </div>


                </div>
            </div><!-- .animated -->
        </div><!-- .content -->
 
 
<%@ include file="../General/Scripts.jsp"%>
  
    <script type="text/javascript">
       cambiarSeleccion();
       
       function cambiarSeleccion(){
    	   var forma = document.getElementById("forma").value;
    	   
    	   document.getElementById("formaPago").value = forma;
       }
    </script>


</body>
</html>