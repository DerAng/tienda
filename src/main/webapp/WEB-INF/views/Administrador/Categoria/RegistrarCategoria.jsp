 <div class="modal fade" id="largeModal" tabindex="-1" role="dialog" aria-labelledby="largeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                    
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="largeModalLabel">Registrar Categorias</h5>
                               
                            </div>
                            
                              <form:form id="formCategoria" action="guardarCategoria" method="post" class="form-horizontal" modelAttribute="categoria">
                            
                            <div class="modal-body">

                                



                                  <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Nombre</label></div>
                                    <div class="col-12 col-md-9">
                                    	
                                    	 <form:input id="nombre" path="nombre" class="form-control" placeholder="Lacteos" aria-invalid="false" required = "true"/>
                                    </div>
                                  </div>


                                <div class="row form-group">
                                    <div class="col col-md-3">
                                    	<label for="email-input" class=" form-control-label">Descripcion</label></div>
                                    <div class="col-12 col-md-9">
                                    	
                                    	 <form:input id="descripcion" path="descripcion" class="form-control" placeholder="Los lácteos son productos altamente perecederos.." aria-invalid="false" required = "true"/>
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
