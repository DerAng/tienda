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
                                  <button class=" btn btn-primary">IMPORTAR</button>
                                  <button class="btn btn-success">EXPORTAR</button>
                                  <button class=" btn btn-secondary" data-toggle="modal" data-target="#largeModal">CREAR NUEVO PRODUCTO</button>
                               
                                    
                              </div>
                            </div>



                           

                    <div class="card-body">
                  <table id="bootstrap-data-table" class="table table-striped table-bordered">
                    <thead>
                      <tr>
                      
                        <th>Proveedor</th>
                        <th>Codigo Producto</th>
                        <th>Nombre Producto </th>
                        <th>Categoria</th>
                        <th>Stock</th>
                        <th>Accion</th>
                        

                     
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                       
                       
                        <td>Juan Esteban</td>
                        <td>126488</td>
                        <td>Yogurt Alpina</td>
                        <td>Lacteos</td>
                        <td>10</td>
                        
                        
                        <td>

                          <button type="button" class="btn btn-success"><i class="fa fa-pencil"></i>&nbsp;</button>
                         
                         <button type="button" class="btn btn-danger"><i class="fa fa-trash-o"></i>&nbsp;</button>

                        </td>

                        
                      </tr>
                     
                     
                     
                    </tbody>
                  </table>
                        </div>
                    </div>
                </div>


                </div>
            </div><!-- .animated -->
        </div><!-- .content -->



    </div><!-- /#right-panel -->


    
 
<%@ include file="../General/Scripts.jsp"%>
  
    <script type="text/javascript">
        $(document).ready(function() {
          $('#bootstrap-data-table-export').DataTable();
        } );
    </script>


</body>
</html>
