  <!-- Modal -->
                 <div class="modal fade" id="largeModal" tabindex="-1" role="dialog" aria-labelledby="largeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="largeModalLabel">Registrar Vendedor</h5>
                               
                                
                            </div>
                            
                            <form:form id="formVendedor" action="guardarVendedor" method="post" class="form-horizontal" modelAttribute="vendedor">
                            <div class="modal-body">

                              

                              
                                 

                                <div class="row form-group">
                                        <div class="col col-md-3">
                                        	<label for="email-input" class=" form-control-label">Nombres</label>
                                        </div>
                                           <div class="col-12 col-md-9">
                                                <form:input id="nombre" path="nombre" class="form-control" placeholder="Ana Maria" aria-invalid="false" required = "true"/>
                                         		
                                           </div>
                                </div>

                            
                                  <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Apellidos</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    
                                    	 <form:input id="apellido" path="apellido" class="form-control" placeholder="Garcia Duarte" aria-invalid="false" required = "true"/>
                                    </div>
                                  </div>



                                  <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Direccion</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	
                                    	 <form:input id="direccion" path="direccion" class="form-control" placeholder="Avenida 0 # 3-22" aria-invalid="false" required = "true"/>
                                    </div>
                                </div>
                                  


                                <div class="row form-group">
                                    <div class="col col-md-3">
                                	    <label for="email-input" class=" form-control-label">Telefono</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    
                                    	 <form:input id="telefono" path="telefono" class="form-control" placeholder="5825053" aria-invalid="false" required = "true"/>
                                    </div>
                                </div>


                                 <div class="row form-group">
                                    <div class="col col-md-3">
                                   		 <label for="email-input" class=" form-control-label">Fecha de Nacimiento</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	
                                    		 <form:input id="fechaNacimiento" path="fechaNacimiento" class="form-control" type="date" aria-invalid="false" required = "true"/>
                                    </div>
                                </div>
                                
                                

                                  <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Fecha de Ingreso</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	
                                    	 <form:input id="fechaIngreso" path="fechaIngreso" class="form-control" type="date" aria-invalid="false" required = "true"/>
                                    	
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

                                


                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                <button type="submit" class="btn btn-primary">Registrar</button>
                            </div>
                            </form:form> 
                        </div>
                    </div>
                </div>
