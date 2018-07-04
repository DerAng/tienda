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
                	<!-- Formulario -->
                    <form:form id="formRealizarVenta" action="guardarVenta" method="post" modelAttribute="venta">
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">Datos generales de la venta</strong>
                        </div>

                    	<div class="card-body">
                   					 <input type="hidden" id="ruta" class="form-control" value = "${contextPath}" />
                    			<!-- Si hubo un error en el registro muestra el mensaje-->
								<div id="exito">
                                </div>
								<div id="error">
                                </div>
                                 		                                		
                            		<div class="form-group">
	                            		<!-- Vendedor -->
	                            		<label for="email-input" class=" form-control-label">Seleccione el vendedor</label>
										<form:select path="vendedor" id="vendedor" class="form-control">
					                    	<form:option value="0" label="Seleccione el vendedor" />
					                    	<form:options items="${vendedores}"/>
					                    </form:select>  
                            		</div>
                            		
                            		<!-- Cliente -->
                            		<div class="form-group">                            		
                            		<label for="email-input" class=" form-control-label">Seleccione el cliente</label>
										<form:select path="cliente" id="cliente" class="form-control">
					                    	<form:option value="0" label="Seleccione el cliente" />
					                    	<form:options items="${clientes}"/>
					                    </form:select>  
					                </div>
                            </div>
                     </div>
                     	<div class="card">
                            <div class="card-header">
                            	<strong class="card-title">Productos</strong>
                        	</div>

                    		<div class="card-body">
                            		
                            		<!-- ////////////////////////////////////////////////////////////////////////////////////////// -->
                            		<input type="hidden" id="precios" value="${precioproductos}">
                            		
                            		<!-- Insertar producto -->
                            		<div class="form-group">
	                            		<label for="email-input" class=" form-control-label">Seleccione el producto a agregar</label>
	                            		<form:select path="producto" id="producto" class="form-control">
					                    	<form:option value="0" label="Seleccione el producto" />
					                    	<form:options items="${productos}"/>
					                    </form:select>  
                            		</div>
                            		<div class="form-group">
	                                    <label for="email-input" class=" form-control-label">Cantidad</label>	                                    	
	                                    <input type="number" min="1" id="cantidad" class="form-control" placeholder="3" aria-invalid="false" required = "true" />	                                   
                                  	</div>
                                  	
                                  	<!-- Boton para Eliminar los datos -->
                                	<button type="button" class="btn btn-success" onclick="agregarProducto()">Agregar producto</button>     
                            		</br>
                            		</br>
                            		<!--  Productos -->
                            		
 									<table id="bootstrap-data-table" class="table table-striped table-bordered">
                    					<thead>
                      						<tr>     
                      						 	<th>Codigo</th>                   
						                        <th>Proudcto</th>
						                        <th>Cantidad</th>
						                        <th>Precio unitario</th>
						                        <th>precio total</th>      
						                        <th>acción</th>                 
                     			 			</tr>
                    					</thead>
                    						
                    					<tbody id="bodyproductos">
                     						
                     						
                     								
                    					</tbody>                            		
                            		</table>
                            	</div>
                            </div>
                            <div class="card">
	                            <div class="card-header">
	                            	<strong class="card-title">Total</strong>
	                        	</div>
	
	                    		<div class="card-body">
                            		<!-- Total  -->

				                <div class="row">
				                    <div class="col-lg-3">
				                       
				                         <div class="form-group">
	                                    	<label for="email-input" style ="display: block;text-align: center;" class=" form-control-label">Total sin impuesto</label>	                                    	
	                                    	<input id="totalsi" class="form-control" placeholder="0" aria-invalid="false" required = "true" value="${categoria.nombre}" readonly/>	                                   
                                  		</div>
				                
				                    </div>
				                    <div class="col-lg-3">
				                 
						                    <div class="form-group">
			                                    <label for="email-input" style ="display: block;text-align: center;" class=" form-control-label">Iva (19%)</label>	                                    	
			                                    <input id="iva" class="form-control" placeholder="0" aria-invalid="false" required ="true" value="${categoria.descripcion}" readonly/>	                                   
		                                  	</div>
				                     
				                    </div>
				                    <div class="col-lg-3">
				                        
					                    <div class="form-group">
		                                    <label for="email-input" style ="display: block;text-align: center;" class=" form-control-label">Impuestos extras</label>	                                    	
		                                    <input id="impuestos" placeholder="0"  class="form-control" aria-invalid="false" required = "true" value="${categoria.descripcion}" readonly/>	                                   
	                                  	</div>
				                        
				                    </div>
				                    <div class="col-lg-3">
				                        
				                            <div class="form-group">
	                                    		<label for="email-input" style ="display: block;text-align: center;">Total</label>	                                    	
	                                    		<input id="total" class="form-control" placeholder="0" aria-invalid="false" required = "true" value="${categoria.descripcion}" readonly/>	                                   
                                  			</div>
				                        
				                    </div>
				                </div>
                            		
                                	<!-- Boton para Eliminar los datos -->
                                	<button type="button" class="btn btn-success" onclick="registrarVenta()">Realizar venta</button>                                 
                            	                        
                        	</div>
                        </div>
                       </form:form> 
                    </div>
                </div>
				  

                </div>
            </div><!-- .animated -->
        </div><!-- .content -->
 
 
<%@ include file="../General/Scripts.jsp"%>
  
    <script type="text/javascript">

    	var productos = [];
    	
    	cargarPrecios();
    	
    	function cargarPrecios(){
    		var pre = document.getElementById("precios").value;
    		pre = pre.substring(1,pre.length-1);
    		if(pre != ""){
    			var pres = pre.split(",");
    			for (i = 0; i < pres.length; i++) { 
    				var cod = pres[i].split("=")[0].trim();
    				var pr = pres[i].split("=")[1].trim();
    				var producto = {codigo:cod, precio:pr};
    				productos.push(producto);
    			}
    		}
    		console.log(productos);
    		document.getElementById("bootstrap-data-table").deleteRow(1);
    	}
    
		function agregarProducto(){
			var e = document.getElementById("producto");
			var productoId = e.options[e.selectedIndex].value;
			var nombre = e.options[e.selectedIndex].text;
			var cantidad = document.getElementById("cantidad").value;
									
			
			
			if(productoId > 0 && cantidad > 0){
				
				var result = $.grep(productos, function(e){ return e.codigo == productoId; });
				crearItemEnTablaDeProductos(result[0].codigo,result[0].precio, cantidad,nombre);				
			}
			
		}
		
		function crearItemEnTablaDeProductos(codigo, precio, cantidad,nombre){
		    var table = document.getElementById("bootstrap-data-table");
		    var random =  Math.floor(Math.random() * (10000 - 1000) + 1000);
 			var row = table.insertRow(table.rows.length);
		    
		    var cell0 = row.insertCell(0);
		    var cell1 = row.insertCell(1);
		    var cell2 = row.insertCell(2);
		    var cell3 = row.insertCell(3);
		    var cell4 = row.insertCell(4);
		    var cell5 = row.insertCell(5);
		    cell0.innerHTML = random;
		    cell1.innerHTML = nombre;
		    cell2.innerHTML = cantidad;
		    cell3.innerHTML = precio;
		    cell4.innerHTML = (precio*cantidad);
		    cell5.innerHTML = "<button type=\"button\" onclick=\"eliminarItem("+random+")\" class=\"btn btn-danger\"><i class=\"fa fa-trash-o\"></i>&nbsp;</button>";
		    
		    modificarTotal();
		}
		
		function eliminarItem(indice){
		    var table = document.getElementById('bootstrap-data-table');
		    for (var r = 0, n = table.rows.length; r < n; r++) {
		    	if(table.rows[r].cells[0].innerHTML == indice){
		    		document.getElementById("bootstrap-data-table").deleteRow(r);
		    		modificarTotal();
		    		break;
		    	}	
		    }
		}
		
		function modificarTotal(){
			var table = document.getElementById('bootstrap-data-table');
			var valor = 0;
		    for (var r = 1, n = table.rows.length; r < n; r++) {		    	
		    	valor = valor + Number(table.rows[r].cells[4].innerHTML.trim());		    		
		    }
		    
		    document.getElementById("totalsi").value =	(valor);
		    document.getElementById("iva").value = (valor*19/100);		    
		    document.getElementById("impuestos").value = (valor*2/100);
		    document.getElementById("total").value = ((valor) + (valor*19/100) + ((valor*2)/100));
		}
		
		function registrarVenta(){
			console.log("entro");
			var vendedor = document.getElementById("vendedor").value;
			var cliente = document.getElementById("cliente").value;
			
			
			var totalsi = document.getElementById("totalsi").value;
			var iva = document.getElementById("iva").value;
			var impuestos = document.getElementById("impuestos").value;
			var total = document.getElementById("total").value;
			
			if(vendedor > 0 && cliente > 0){
			
						var ruta = document.getElementById("ruta").value;
						var formData = {

								vendedor: 				vendedor,
								
						          cliente: 				cliente,
						          totalSinImpuesto:		totalsi,
						          iva:					iva,
						          impuestos:			impuestos,
						          total:				total				
						};
						
						$.ajax({
							type : "POST",
							contentType : "application/json",
							url : ruta + "/servicios/guardarVenta",
							data: JSON.stringify(formData),
							success : function(result) {
								
								if(result.trim() == 'REGISTRO EXITOSO'){
									
									$('#formRealizarVenta').trigger("reset");
								    var table = document.getElementById('bootstrap-data-table');
								    for (var r = 1, n = table.rows.length; n > 1;) {
								    	
								    		document.getElementById("bootstrap-data-table").deleteRow(r);
								    		n = table.rows.length;
								    		
								    		
								    }
									pintarRegistroExitoso();	
									
									
								}else{
									pintarRegistroNoExitoso(result.trim());
								}
							},
							error : function(e) {
								pintarRegistroNoExitoso("Error en el sistema. Contacte al administrador.");
								console.log("ERROR: ", e);
							}
						});	
				
			}else{
				pintarRegistroNoExitoso("Campos invalidos.");
			}
			
			
			
			
		}
		
		function pintarRegistroExitoso(){
			var exito = document.getElementById("exito");
			
			var div = document.createElement("DIV");
			div.setAttribute("class","sufee-alert alert with-close alert-success alert-dismissible fade show");
			var texto = document.createTextNode("Registro exitoso");       
			div.appendChild(texto);
			
			var boton = document.createElement("BUTTON");
			boton.setAttribute("type","button");
			boton.setAttribute("class","close");
			boton.setAttribute("data-dismiss","alert");
			boton.setAttribute("aria-label","Close");
			
			var span = document.createElement("span");
			span.setAttribute("aria-hidden","true");
			var textos = document.createTextNode("X");       
			span.appendChild(textos);
			
			boton.appendChild(span);
			div.appendChild(boton);
			exito.appendChild(div);
		}
		
		function pintarRegistroNoExitoso(mensaje){
			var error = document.getElementById("error");
			
			var div = document.createElement("DIV");
			div.setAttribute("class","sufee-alert alert with-close alert-danger alert-dismissible fade show");
			var texto = document.createTextNode(mensaje);       
			div.appendChild(texto);
			
			var boton = document.createElement("BUTTON");
			boton.setAttribute("type","button");
			boton.setAttribute("class","close");
			boton.setAttribute("data-dismiss","alert");
			boton.setAttribute("aria-label","Close");
			
			var span = document.createElement("span");
			span.setAttribute("aria-hidden","true");
			var textos = document.createTextNode("X");       
			span.appendChild(textos);
			
			boton.appendChild(span);
			div.appendChild(boton);
			error.appendChild(div);
		}
		
		function getProductos(){
			
		}
		
    </script>


</body>
</html>
