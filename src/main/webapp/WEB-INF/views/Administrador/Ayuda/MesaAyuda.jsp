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
        
        
        <div class="content">

            <!-- BEGIN PAGE TITLE -->

            <div class="page-title">

                <h3 align="justify"">Mesa de ayuda</h3>
                <br/>

                
        <div class="col-md-7">
        <div class=" tiles white col-md-12 no-padding">
            <div class="tiles green cover-pic-wrapper">
            
             

               <img class="align-content" src="resources/images/atencion.jpg" alt="Derly Angel Desarrollador backend" width="100%"> 
               
               
            </div>
            
            <!--
            <div class="tiles white">
                <div class="row">
                  
                    <div class="col-md-3 col-sm-3">
                    
                      
                         <div class="user-profile-pic">
                            <img width="69" height="69" src="resources/images/atencion.jpg" alt="">
                        </div>
                      

                    </div>
                      -->
                    <div class="col-md-7 user-description-box  col-sm-7">
                    <br/>
                        <div align="right"><h2 style="font-size: 24px !important;" class="semi-bold no-margin">Derly Zuley Angel</h2></div>

                        <h6 class="no-margin"></h6>
                        <br>
                        <p style="font-size: 14px !important;"><i class="fa fa-phone-square"></i>3186230860</p>
                        <p style="font-size: 14px !important;"><i class="fa fa-envelope"></i>derlyzuley@gmail.com</p>
                       
                    </div>

                </div>

            </div>
        </div>
        
        
        
       

      
        
        
        
    </div>

  
       </div>


            </div>

            <!-- END PAGE TITLE -->

            <!-- BEGIN PlACE PAGE CONTENT HERE -->

            <!-- END PLACE PAGE CONTENT HERE -->

        </div>

    </div><!-- /#right-panel -->


    
 
<%@ include file="../General/Scripts.jsp"%>
  
    <script type="text/javascript">
        $(document).ready(function() {
          $('#bootstrap-data-table-export').DataTable();
        } );
    </script>


</body>
</html>