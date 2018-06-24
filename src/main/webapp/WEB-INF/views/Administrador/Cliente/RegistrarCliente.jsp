<!-- Modal -->
                <div class="modal fade" id="largeModal" tabindex="-1" role="dialog" aria-labelledby="largeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="largeModalLabel">Registrar Cliente</h5>
                               
                                
                            </div>
                            
                             <form:form id="formCliente" action="guardarCliente" method="post" class="form-horizontal" modelAttribute="cliente">
                            <div class="modal-body">

                              
                                <div class="row form-group">
                                    <div class="col col-md-3"><label for="select" class=" form-control-label">Tipo de Documento</label></div>
                                    <div class="col-12 col-md-9">
                                      <form:select path="tipoDoc" id="tipoDoc" class="form-control">
                                        <option value="0" label="Seleccione tipo documento"></option>
                                        <option value="1">Cedula Ciudadania</option>
                                        <option value="2">Tarjeta de Identidad</option>
                                        
                                      </form:select> 
                                    </div>
                                 </div>


                                  <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Numero de Documento</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	
                                    	<form:input id="numeroDocumento" path="numeroDocumento" class="form-control" placeholder="1090480323" aria-invalid="false" required = "true"/>
                                    </div>
                                    	
                                  </div>



                                  <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Nombres</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	
                                    	<form:input id="nombre" path="nombre" class="form-control" placeholder="Juan Miguel" aria-invalid="false" required = "true"/>
                                    </div>
                                </div>
                                  


                                <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Apellidos</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	
                                    	<form:input id="apellido" path="apellido" class="form-control" placeholder="Angel Perez" aria-invalid="false" required = "true"/>
                                    	
                                    </div>
                                </div>


                                 <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Direccion</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	
                                    	<form:input id="direccion" path="direccion" class="form-control" placeholder="Avenida 5 # 4-22" aria-invalid="false" required = "true"/>
                                    	
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
                                    	<label for="email-input" class=" form-control-label">Correo electronico</label>
                                    </div>
                                    
                                    <div class="col-12 col-md-9">
                                    	
                                    	<form:input id="correoElectronico" path="correoElectronico" class="form-control" placeholder="juanm@gmail.com" aria-invalid="false" required = "true"/>
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
