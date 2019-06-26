<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado Funciones</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="col-sm-10 col-md-8 col-lg-8 offset-sm-1 offset-md-2 offset-lg-2">
<h1>Listado Funciones</h1>
<div class="btn-group" role="group" >
<a class="btn btn-secondary" href=" ${pageContext.request.contextPath}/function/new	">Crear Funcion</a>
<a class="btn btn-light" href=" ${pageContext.request.contextPath}/film/new	">Crear Pelicula</a>
<a class="btn btn-dark" href=" ${pageContext.request.contextPath}/film/list">Listado Peliculas</a>
</div>
	<table class="table">
	<thead>
	  <tr>
	    <th scope="col">Accion</th>
	    <th scope="col">Codigo</th>
	    <th scope="col">Nombre Pelicula</th>
	    <th scope="col">Descripcion Pelicula</th>
	    <th scope="col">Horario</th>
	    <th scope="col">Estado</th>
	  </tr>
	</thead>
	<tbody>
		<c:forEach items="${functions}" var="function">
			<tr>
				<td>
					<div class="btn-group">
					  <a href="${pageContext.request.contextPath}/function/view/${function.idfunction}" class="btn btn-dark">Ver</a>
					  <a href="${pageContext.request.contextPath}/function/edit/${function.idfunction}"  class="btn btn-secondary">Editar</a>
					</div>
				</td>
			<td>${function.idfunction}</td>
			<td>${function.film.filmname}</td>
			<td>${function.film.description}</td>
			<td>${function.starttime }</td>
			<td>${function.activestate }</td>
			
			</tr>	
		</c:forEach>
	</tbody>
	 
	  
	</table>
	  </div>
  
  	
 
</body>
</html>