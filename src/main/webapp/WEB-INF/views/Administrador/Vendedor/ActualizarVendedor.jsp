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
                            <strong class="card-title">Actualizar Vendedor</strong>
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
                        		<form:form id="formActualizarVendedor" action="editarVendedor" method="post" modelAttribute="vendedor">
                        		                 			
                        		    <form:hidden id="codigo" path="codigo" class="form-control" aria-invalid="false" required = "true" value="${vendedor.codigo}"/>                            		
                            		
                           
							
							 
							  <div class="row form-group">
                                        <div class="col col-md-3">
                                        	<label for="email-input" class=" form-control-label">Nombres</label>
                                        </div>
                                           <div class="col-12 col-md-9">
                                                <form:input id="nombre" path="nombre" class="form-control" placeholder="Ana Maria" aria-invalid="false" required = "true" value="${vendedor.nombre}"/>
                                         		
                                         </div>
                                </div>

                            
                                 <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Apellidos</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    
                                    	 <form:input id="apellido" path="apellido" class="form-control" placeholder="Garcia Duarte" aria-invalid="false" required = "true" value="${vendedor.apellido}"/>
                                    </div>
                                  </div>



                                <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Direccion</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	
                                    	 <form:input id="direccion" path="direccion" class="form-control" placeholder="Avenida 0 # 3-22" aria-invalid="false" required = "true" value="${vendedor.direccion}"/>
                                    </div>
                                </div>
                                  


                                <div class="row form-group">
                                    <div class="col col-md-3">
                                	    <label for="email-input" class=" form-control-label">Telefono</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    
                                    	 <form:input id="telefono" path="telefono" class="form-control" placeholder="5825053" aria-invalid="false" required = "true" value="${vendedor.telefono}"/>
                                    </div>
                                </div>


                                 <div class="row form-group">
                                    <div class="col col-md-3">
                                   		 <label for="email-input" class=" form-control-label">Fecha de Nacimiento</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	
                                    		 <form:input id="fechaNacimiento" path="fechaNacimiento" class="form-control" type="date" aria-invalid="false" required = "true" value="${vendedor.fechaNacimiento}"/>
                                    </div>
                                </div>
                                
                                

                                <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Fecha de Ingreso</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	
                                    	 <form:input id="fechaIngreso" path="fechaIngreso" class="form-control" type="date" aria-invalid="false" required = "true" value="${vendedor.fechaIngreso}"/>
                                    	
                                    </div>
                                </div>



                                <div class="row form-group">
                                    <div class="col col-md-3"><label for="select" class=" form-control-label">Nombre Tienda</label></div>
                                    <div class="col-12 col-md-9">
                                     <form:select path="nombreTienda" id="nombreTienda" class="form-control">
				                        <form:option value="0" label="Seleccione la tienda" />
				                        <form:options items="${tiendas}"/>
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
        $(document).ready(function() {
          $('#bootstrap-data-table-export').DataTable();
        } );
    </script>


</body>
</html>
