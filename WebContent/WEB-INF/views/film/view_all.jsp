<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado Pelicula</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="col-sm-10 col-md-8 col-lg-8 offset-sm-1 offset-md-2 offset-lg-2">
<h1>Listado Peliculas</h1>
<a class="btn btn-secondary" href=" ${pageContext.request.contextPath}/film/new	">Crear Pelicula	</a>
<a class="btn btn-secondary" href=" ${pageContext.request.contextPath}/function/list">Listado Funciones</a>
<br/>
	<table class="table">
	<thead>
	  <tr>
	    <th scope="col">Accion</th>
	    <th scope="col">Codigo</th>
	    <th scope="col">Nombre</th>
	    <th scope="col">Descripcion</th>
	    <th scope="col">Du	racion</th>
	  </tr>
	</thead>
	<tbody>
		<c:forEach items="${films}" var="film">
			<tr>
				<td>
					<div class="btn-group">
					  <a href="${pageContext.request.contextPath}/film/view/${film.idfilm}" class="btn btn-primary">Ver</a>
					  <a href="${pageContext.request.contextPath}/film/edit/${film.idfilm}" type="button" class="btn btn-secondary">Editar</a>
					</div>
				</td>
			<td>${film.idfilm}</td>
			<td>${film.filmname}</td>
			<td>${film.description}</td>
			<td>${film.duration}</td>
			</tr>	
		</c:forEach>
	</tbody>
	 
	  
	</table>
	</div>
	  
  
  	
 
</body>
</html>