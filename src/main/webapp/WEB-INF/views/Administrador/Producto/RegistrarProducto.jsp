 <!-- Modal -->
                <div class="modal fade" id="largeModal" tabindex="-1" role="dialog" aria-labelledby="largeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="largeModalLabel">Registrar Producto</h5>
                                
                            </div>
                            <form:form id="formProducto" action="guardarProducto" method="post" class="form-horizontal" modelAttribute="producto">
                            
                            <div class="modal-body">
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
                                    	<form:input id="nombre" path="nombre" class="form-control" placeholder="Yogurt" aria-invalid="false" required = "true"/>
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
                                    	<form:input type="number" min="1" id="stock" path="stock" class="form-control" placeholder="100" aria-invalid="false" required = "true"/>
                                    </div>
                                </div>


                                 <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Precio Venta</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	<form:input type="number" min="50" id="precioVenta" path="precioVenta" class="form-control" placeholder="3500" aria-invalid="false" required = "true"/>                                    
                                    </div>
                                </div>


                                

                                 <div class="row form-group">
                                    <div class="col col-md-3">
                                        <label for="email-input" class=" form-control-label">Costo</label>
                                    </div>
                                    <div class="col-12 col-md-9">                                        
                                        <form:input type="number" min="50" id="costo" path="costo" class="form-control" placeholder="2200" aria-invalid="false" required = "true"/>
                                    </div>
                                </div>


                                 <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Fecha de Vencimiento</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                    	<form:input type="date" id="fechaVencimiento" path="fechaVencimiento" class="form-control" aria-invalid="false" required = "true"/>                                    	
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