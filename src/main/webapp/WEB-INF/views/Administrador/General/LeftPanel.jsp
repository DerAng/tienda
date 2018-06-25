   
    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
   
   
   
    <aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">


            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
               
               <!-- <a class="navbar-brand" href="${contextPath}/admin"><img src="resources/images/logo.png" alt="Logo"></a> !-->
               <h1  style="color:white;"> SGV </h1>

            </div>


            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">

                    <li>
                        <a href="${contextPath}/admin"> <i class="menu-icon fa fa-dashboard"></i>Panel De Control</a>
                    </li>

                     <h3 class="menu-title"> Negocio</h3>


                    <li>
                        <a href="${contextPath}/tiendas"> <i class="menu-icon fa fa-map-marker"></i>Gestionar Tiendas</a>
                    </li>


                    <li>
                        <a href="${contextPath}/proveedores"> <i class="menu-icon fa fa-truck"></i>Gestionar Proveedores</a>
                    </li>


                    <li>
                        <a href="${contextPath}/productos"> <i class="menu-icon fa fa-product-hunt"></i>Gestionar Productos</a>
                    </li>

                    <li>
                        <a href="${contextPath}/vendedores"> <i class="menu-icon fa fa-user-circle-o"></i>Gestionar Vendedores</a>
                    </li>


                    <li>
                        <a href="${contextPath}/clientes"> <i class="menu-icon fa fa-users"></i>Gestionar Clientes</a>
                    </li>


                    <li>
                        <a href="${contextPath}/ventas"> <i class="menu-icon fa fa-shopping-cart"></i>Gestionar Ventas</a>
                    </li>


                    <li>
                        <a href="${contextPath}/categorias"> <i class="menu-icon fa fa-bars"></i>Gestionar Categorias</a>
                    </li>

                      
                      
                      
                    <li>
                        <a href="${contextPath}/ayuda"> <i class="menu-icon fa fa-graduation-cap""></i>Mesa De Ayuda</a>
                    </li>
                      
                     
            
                </ul>
            </div><!-- /.navbar-collapse -->


        </nav>
    </aside><!-- /#left-panel -->
    
    
    


   
   