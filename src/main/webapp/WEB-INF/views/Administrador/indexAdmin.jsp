<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>

<html>

  <head>

   <%@ include file="General/Css.jsp"%>

  </head>
  
  
  <body class="skin-blue">

<%@ include file="General/LeftPanel.jsp"%>

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

           

           <div class="col-sm-6 col-lg-4">
                <div class="card text-white bg-flat-color-1">
                    <div class="card-body pb-0">
                    
                       
                        
                        <h4 class="mb-0">
                            <span class="count">100</span>
                        </h4>
                        <p class="text-light">CANTIDAD DE VENTAS POR AÑO</p>

                        <div class="chart-wrapper px-0" style="height:100px;" height="100">
                            <canvas id="widgetChart1"></canvas>
                        </div>

                    </div>

                </div>
            </div>
            <!--/.col-->





            <div class="col-sm-6 col-lg-4">
                <div class="card text-white bg-flat-color-2">
                    <div class="card-body pb-0">
                    
                        <h4 class="mb-0">
                            <span class="count">10468</span>
                        </h4>
                        <p class="text-light">CANTIDAD DE CLIENTES POR AÑO</p>

                        <div class="chart-wrapper px-0" style="height:100px;" height="100">
                            <canvas id="widgetChart2"></canvas>
                        </div>

                    </div>
                </div>
            </div>


            <!--/.col-->

            <div class="col-sm-6 col-lg-4">
                <div class="card text-white bg-flat-color-3">
                    <div class="card-body pb-0">
                    
                       
                        <h4 class="mb-0">
                            <span class="count">10468</span>
                        </h4>
                        <p class="text-light">TOTAL VENDIDO POR AÑO</p>

                    </div>

                        <div class="chart-wrapper px-0" style="height:100px;" height="100">
                            <canvas id="widgetChart3"></canvas>
                        </div>
                </div>
            </div>
            <!--/.col-->




            <div class="col-sm-6 col-lg-4">
                <div class="card text-white bg-flat-color-4">
                    <div class="card-body pb-0">
                    
                    
                        <h4 class="mb-0">
                            <span class="count">10468</span>
                        </h4>
                        <p class="text-light"></p>

                        <div class="chart-wrapper px-3" style="height:100px;" height="100">
                            <canvas id="widgetChart4"></canvas>
                        </div>

                    </div>
                </div>
            </div>
            <!--/.col-->



        </div> <!-- .content -->
    </div><!-- /#right-panel -->



<%@ include file="General/Scripts.jsp"%>

 

  </body>
  
  
</html>
