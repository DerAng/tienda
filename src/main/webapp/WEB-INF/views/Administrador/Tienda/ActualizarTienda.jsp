<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
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

        
        <header id="header" class="header">

            <div class="header-menu">

            
                <div class="col-sm-7">
                
                    <a id="menuToggle" class="menutoggle pull-left"><i class="fa fa fa-tasks"></i></a>
                
                </div>
            </div>

        </header>
        <!-- Header-->





        <div class="content mt-3">
            <div class="animated fadeIn">
                <div class="row">

                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <strong class="card-title">Actualizar Iienda</strong>
                            </div>

                            <div class="card-body">
                                <form action="" method="post" enctype="multipart/form-data" class="form-horizontal">   
                     
                           


                                   
                               <div class="row form-group">
                                 <div class="col col-md-3"><label for="email-input" class=" form-control-label">NIT</label></div>
                                    <div class="col-12 col-md-9"><input type="email" id="email-input" name="email-input" placeholder="10302900" class="form-control"></div>
                                </div>


                                 <div class="row form-group">
                                    <div class="col col-md-3"><label for="email-input" class=" form-control-label">Nombre</label></div>
                                    <div class="col-12 col-md-9"><input type="email" id="email-input" name="email-input" placeholder="Tienda la 22" class="form-control"></div>
                                  </div>



                                <div class="row form-group">
                                    <div class="col col-md-3"><label for="select" class=" form-control-label">Administrador</label></div>
                                    <div class="col-12 col-md-9">
                                      <select name="select" id="select" class="form-control">
                                        <option value="0"></option>
                                        
                                      </select>
                                    </div>
                                 </div>


                                 


                                  <div class="row form-group">
                                    <div class="col col-md-3"><label for="email-input" class=" form-control-label">Direccion</label></div>
                                    <div class="col-12 col-md-9"><input type="email" id="email-input" name="email-input" placeholder="Avenida 22 # 3-18" class="form-control"></div>
                                </div>


                            
                                <div class="row form-group">
                                    <div class="col col-md-3"><label for="email-input" class=" form-control-label">Nombre Representante</label></div>
                                    <div class="col-12 col-md-9"><input type="email" id="email-input" name="email-input" placeholder="Juan Luis" class="form-control">
                                    </div>
                                </div>



                                 
                        
                                    <button type="button" class="btn btn-primary">Actualizar</button>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>

                                </form>                              
                            </div> <!--Card Body-->
                        </div>    
                    </div> <!-- Col-md -->
                </div> <!-- Row -->
            </div><!-- .animated -->
        </div><!-- .content -->
    </div><!-- /#right-panel -->


   

    <!-- Right Panel -->


 <%@ include file="../General/Scripts.jsp"%>

    <script type="text/javascript">
        $(document).ready(function() {
          $('#bootstrap-data-table-export').DataTable();
        } );
    </script>


</body>
</html>
