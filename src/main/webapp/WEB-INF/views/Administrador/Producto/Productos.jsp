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
                            <strong class="card-title">PRODUCTOS</strong>
                        </div>


                           <div class="row">
                              <div class="col text-right">
                              </br>
                                  <button type="button" class=" btn btn-primary" onclick="cargarArchivo()">IMPORTAR</button>

                                  <a href ="${contextPath}/descargarProductos"><button type="button" class=" btn btn-success">EXPORTAR</button></a>
                                  <button class=" btn btn-secondary" data-toggle="modal" data-target="#largeModal">CREAR NUEVO PRODUCTO</button>
                                  <div style="display: none;">
                                  	<input type="file" id="archivo" name="archivo" onchange="revisarArchivo(this);" accept=".xlsx,.xls">
                                  </div>       
                                  <input type="hidden" id="ruta" class="form-control" value = "${contextPath}" />      
                                    
                              </div>
                            </div>
                    <div class="card-body">
                    
                                        	<!-- Si hubo un registro exitoso muestra el mensaje-->
							    <c:if test="${not empty result}">
							    	<div class="sufee-alert alert with-close alert-success alert-dismissible fade show">
                                    	<c:out value='${result}' />
                                       	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        	<span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
							    </c:if>
							    <c:if test="${not empty wrong}">		            
		                        	<div class="sufee-alert alert with-close alert-danger alert-dismissible fade show">				                   	
				                    		<c:out value='${wrong}' />
				                    	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
											<span aria-hidden="true">&times;</span>
				                    	</button>
				                   </div>
							    </c:if>
							    
							    <!-- Si hubo un error en el registro muestra el mensaje-->
								<div id="exito">
                                </div>
								<div id="error">
                                </div>
                    
                  <table id="bootstrap-data-table" class="table table-striped table-bordered">
                    <thead>
                      <tr>
                      
                        <th>Proveedor</th>
                        <th>Nombre Producto </th>
                        <th>Categoria</th>
                        <th>Stock</th>
                        <th>Accion</th>
                      </tr>
                    </thead>
                    <tbody>    
                    	<c:forEach var="producto" items="${productos}">
		                      <tr>
		                        <td>${producto.nombreProveedor}</td>
		                        <td>${producto.nombre}</td>
		                        <td>${producto.nombreCategoria}</td>
		                        <td>${producto.stock}</td>   
		                        <td>
									<a href="${contextPath}/actualizarProducto?codigo=${producto.codigo}">
		                          		<button type="button" class="btn btn-success">
		                          			<i class="fa fa-pencil"></i>&nbsp;
		                          		</button>
		                         	</a>
		                         	<a href="${contextPath}/eliminarProducto?codigo=${producto.codigo}">
		                         		<button type="button" class="btn btn-danger">
		                         			<i class="fa fa-trash-o"></i>&nbsp;
		                         		</button>
									</a>
		                        </td>				                    
		                      </tr>
                     	</c:forEach>                    
                    
                     
                    </tbody>
                  </table>
                        </div>
                    </div>
                </div>


                </div>
            </div><!-- .animated -->
        </div><!-- .content -->



    </div><!-- /#right-panel -->

	<%@ include file="RegistrarProducto.jsp" %>
    
 
<%@ include file="../General/Scripts.jsp"%>
  
    <script type="text/javascript">
        $(document).ready(function() {
          $('#bootstrap-data-table-export').DataTable();
        } );
        
        function cargarArchivo(){
        	document.getElementById('archivo').click();
        }
        
        
        /**
         * Metodo que guarda un archivo en base de datos y luego pinta una imagen colocando
         * como direccionamiento el codigo del archivo en base de datos para que cuando le den
         * clic se descargue el archivo.
         * @param input Archivo.
         * @returns 
         */
        function revisarArchivo(input) {
      	  // Consulta si cargo algun archivo
          if (input.files && input.files[0]) {
              // Obtiene el archivo
          	var file = input.files[0];    	
              // Creo la url a consumir
      		var ruta = document.getElementById("ruta").value;

            var formData = new FormData();
            formData.append('archivo', file);
              // Aca guardo el archivo en base de datos y genero un ID
      		$.ajax({
      			type : "POST",
      			enctype: 'multipart/form-data',
      		    processData: false,
      		    contentType: false,
      		    cache: false,
      			url : ruta + "/servicios/registrarArchivo",
      			data: (formData),
      			success : function(result) {
      				
      				if(result.indexOf("ERROR") != -1){
      					pintarRegistroNoExitoso(result);
      				}else{
      					pintarRegistroExitoso();
      					
      				}
      				
      				console.log("RES --> <"+result+">");

      			},
      			error : function(e) {
      				pintarRegistroNoExitoso("Error en el sistema. Contacte al administrador.");
      				alert("Error! --> "+String(e));
      				console.log("ERROR: ", e);
      			}
      		}); 
              
              document.getElementById("archivo").value = "";
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
        
    </script>


</body>
</html>
