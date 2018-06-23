 <!-- Modal -->
                 <div class="modal fade" id="largeModal" tabindex="-1" role="dialog" aria-labelledby="largeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="largeModalLabel">Registrar Proveedor</h5>
                               
                                
                            </div>
                            
                            <form:form id="formProveedor" action="guardarProveedor" method="post" class="form-horizontal" modelAttribute="proveedor">
                            <div class="modal-body">


                                <div class="row form-group">
                                        <div class="col col-md-3">
                                        	<label for="email-input" class=" form-control-label">NIT Empresa</label>
                                        </div>
                                         <div class="col-12 col-md-9">
                                         	
                                         	<form:input id="nit_Empresa" path="nit_Empresa" class="form-control" placeholder="35678923" aria-invalid="false" required = "true"/>
                                        </div>
                                </div>

                            
                                  <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Nombre Empresa</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	
                                    	<form:input id="nomEmpresa" path="nomEmpresa" class="form-control" placeholder="Colanta" aria-invalid="false" required = "true"/>
                                    </div>
                                    
                                  </div>



                                  <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Nombre del Contacto</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	
                                    	<form:input id="nombreContacto" path="nombreContacto" class="form-control" placeholder="Juan Luis" aria-invalid="false" required = "true"/>
                                    	
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
                                    	<label for="email-input" class=" form-control-label">Correo Electronico</label></div>
                                    <div class="col-12 col-md-9">
                                    	
                                    	<form:input type="email" id="correoElectronico" path="correoElectronico" class="form-control" placeholder="JuanLuis@gmail.com" aria-invalid="false" required = "true"/>
                                    </div>
                                </div>



                                <div class="row form-group">
                                    <div class="col col-md-3"><label for="select" class=" form-control-label">Forma de Pago</label></div>
                                    <div class="col-12 col-md-9">
                                     
                                       <form:select path="formaPago" id="formaPago" class="form-control">
                                        <option value="0">Efectivo</option>
                                        <option value="1">Cheque</option>
                                        <option value="2">Credito</option>
                                       
                                        
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