<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
  <head>
   
   <%@ include file="Administrador/General/Css.jsp"%>
   
  </head>
  
   <body class="bg-white" > 
 
  
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
   
     
     </br> 
     </br>
     </br> 

    <div class="sufee-login d-flex align-content-center flex-wrap">
        <div class="container">
            <div class="login-content">
            
	            <c:if test="${not empty wrong}">
	                  <div class="alert alert-warning alert-dismissable">
	                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
	                    <h4><i class="icon fa fa-warning"></i> Error</h4>
	                    <c:out value='${wrong}' />
	                  </div>
	              </c:if>
              
                <div class="col-sm-9 col-lg-11">
                
                <div class="login-form">
                     <form:form action="autenticar" method="post" modelAttribute="login">

                     <div class="login-logo">
                        <a href="index.html">
                       
                             <img class="align-content" src="resources/images/imagen.png" alt="">
                             <br/>
                             <br/>
                              <br/>
                             <img class="align-content" src="resources/images/icon.png" alt="">
                             
                               
                             
                        </a>
                       
                     </div>
                     
                     <br/>

                      <div class="form-group">
                            <div class="input-group">
                              <div class="input-group-addon"><i class="fa fa-envelope"></i></div>
                              <form:input path="correoElectronico" type="text" class="form-control" placeholder="user@gmail.com"/>                       
                            </div>
                     </div>


                        <div class="form-group">
                            <div class="input-group">
                              <div class="input-group-addon"><i class="fa fa-asterisk"></i></div>
                              <form:input path="contraseña" type="password" class="form-control" placeholder="pass1234"/>  
                              
                            </div>
                        </div>


                        <button type="submit" class="btn btn-success btn-flat m-b-50 m-t-50">LOGIN</button>

                   </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
     



<%@ include file="Administrador/General/Scripts.jsp"%>
  </body>
</html>