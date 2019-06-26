<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver Todos</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="col-sm-10 col-md-8 col-lg-8 offset-sm-1 offset-md-2 offset-lg-2">
<h1>Ver Todos</h1>
<button class="btn btn-secondary">Crear Pelicula</button>
<br/>
	<table class="table">
	<thead>
	  <tr>
	    <th scope="col">Accion</th>
	    <th scope="col">Codigo</th>
	    <th scope="col">Nombre</th>
	    <th scope="col">Contrasena</th>
	    <th scope="col">Online</th>
	     <th scope="col">Estado</th>
	    <th scope="col"></th>
	  </tr>
	</thead>
	<tbody>
		<c:forEach items="${accounts}" var="account">
			<tr>
				<td>
					<div class="btn-group">
					  <a href="${pageContext.request.contextPath}/account/view/${account.idaccount}" class="btn btn-primary">Ver</a>
					  <a href="${pageContext.request.contextPath}/account/edit/${account.idaccount}" type="button" class="btn btn-secondary">Editar</a>
					</div>
				</td>
			<td>${account.idaccount}</td>
			<td>${account.username}</td>
			<td>${account.password}</td>
			<td>${account.onlinestatus}</td>
			<td>${account.activestate}</td>
			</tr>	
		</c:forEach>
	</tbody>
	 
	  
	</table>
	</div>
	  
  
  	
 
</body>
</html>