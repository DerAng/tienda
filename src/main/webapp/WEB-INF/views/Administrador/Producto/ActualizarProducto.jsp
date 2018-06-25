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
                            <strong class="card-title">Actualizar Producto</strong>
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
                        		<form:form id="formActualizarProducto" action="editarProducto" method="post" modelAttribute="producto">
                        		                 			
                        		    <form:hidden id="codigo" path="codigo" class="form-control" aria-invalid="false" required = "true" value="${producto.codigo}"/>                            		
                            		
                            		
                                  	
                                <div class="row form-group">
                                    <div class="col col-md-3"><label for="select" class=" form-control-label">Proveedor</label></div>
                                    <div class="col-12 col-md-9">
                        			  <form:select path="proveedor" id="proveedor" class="form-control">
				                        <form:option value="0" label="Seleccione el proveedor" />
				                        <form:options items="${proveedores}"/>
				                      </form:select>  
                                    </div>
                                 </div>



                                  <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Nombre</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	<form:input id="nombre" path="nombre" class="form-control" placeholder="Yogurt" aria-invalid="false" required = "true" value="${producto.nombre}"/>
                                    </div>
                                </div>


                                 <div class="row form-group">
                                    <div class="col col-md-3"><label for="select" class=" form-control-label">Categoria</label></div>
                                    <div class="col-12 col-md-9">
                        			  <form:select path="categoria" id="categoria" class="form-control">
				                        <form:option value="0" label="Seleccione la categoria" />
				                        <form:options items="${categorias}"/>
				                      </form:select> 
                                    </div>
                                 </div>

                                  


                                <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Stock</label>
                                    </div>
                                    <div class="col-12 col-md-9">                                    
                                    	<form:input type="number" min="1" id="stock" path="stock" class="form-control" placeholder="100" aria-invalid="false" required = "true" value="${producto.stock}"/>
                                    </div>
                                </div>


                                 <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Precio Venta</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	<form:input type="number" min="50" id="precioVenta" path="precioVenta" class="form-control" placeholder="3500" aria-invalid="false" required = "true" value="${producto.precioVenta}"/>                                    
                                    </div>
                                </div>


                                

                                 <div class="row form-group">
                                    <div class="col col-md-3">
                                        <label for="email-input" class=" form-control-label">Costo</label>
                                    </div>
                                    <div class="col-12 col-md-9">                                        
                                        <form:input type="number" min="50" id="costo" path="costo" class="form-control" placeholder="2200" aria-invalid="false" required = "true" value="${producto.costo}"/>
                                    </div>
                                </div>


                                 <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Fecha de Vencimiento</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	<form:input type="date" id="fechaVencimiento" path="fechaVencimiento" class="form-control" aria-invalid="false" required = "true" value="${producto.fechaVencimiento}"/>                                    	
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
