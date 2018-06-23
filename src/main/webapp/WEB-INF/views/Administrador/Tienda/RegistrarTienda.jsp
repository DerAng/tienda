
<!-- Modal -->
<div class="modal fade" id="largeModal" tabindex="-1" role="dialog" aria-labelledby="largeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
				<h5 class="modal-title" id="largeModalLabel">Registrar Tienda</h5>
			</div>
			
			<form:form id="formTienda" action="guardarTienda" method="post" class="form-horizontal" modelAttribute="tienda">
	        	<div class="modal-body">
								<c:if test="${not empty wrong}">		            
		                        	<div class="sufee-alert alert with-close alert-danger alert-dismissible fade show">				                   	
				                    		<c:out value='${wrong}' />
				                    	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
											<span aria-hidden="true">&times;</span>
				                    	</button>
				                   </div>
							    </c:if>
						<div class="row form-group">
			 				<div class="col col-md-3">
			 					<label for="email-input" class=" form-control-label">NIT</label>
			 				</div>
			    			<div class="col-12 col-md-9"> 
			    				<form:input id="nit" path="nit" class="form-control" placeholder="10302900" aria-invalid="false" required = "true"/>			    				
			    			</div>
						</div>
		
		
						 <div class="row form-group">
						    <div class="col col-md-3">
						    	<label for="email-input" class=" form-control-label">Nombre</label>
						    </div>
						    <div class="col-12 col-md-9">
						    	<form:input id="nombre" path="nombre" class="form-control" placeholder="Tienda la 22" aria-invalid="false" required = "true"/>						    
						    </div>
						 </div>
		
		
		
						<div class="row form-group">
						    <div class="col col-md-3"><label for="select" class=" form-control-label">Administrador</label></div>
						    <div class="col-12 col-md-9">
                        			  <form:select path="administrador" id="administrador" class="form-control">
				                        <form:option value="0" label="Seleccione el administrador" />
				                        <form:options items="${administradores}"/>
				                      </form:select>  
						    </div>
						</div>
		
						<div class="row form-group">
					    	<div class="col col-md-3">
					    		<label for="email-input" class=" form-control-label">Direccion</label>
					    	</div>
					    	<div class="col-12 col-md-9">					    		
					    		<form:input id="direccion" path="direccion" class="form-control" placeholder="Avenida 22 # 3-18" aria-invalid="false" required = "true"/>
					    	</div>
					  	</div>
		
		
		            
						<div class="row form-group">
						    <div class="col col-md-3">
						    	<label for="email-input" class=" form-control-label">Nombre Representante</label>
						    </div>
						    <div class="col-12 col-md-9">						 
						    	<form:input id="nombreRepresentante" path="nombreRepresentante" class="form-control" placeholder="Juan Luis" aria-invalid="false" required = "true"/>
						    </div>
						</div>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
					<button type="submit" class="btn btn-primary">Registrar</button>
			    </div>
		    </form:form> 
        </div>
    </div>
</div>

