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

	<table class="table">
	<thead>
	  <tr>
	    <th scope="col">Accion</th>
	    <th scope="col">Codigo</th>
	    <th scope="col">Descripcion</th>
	    <th scope="col">Estado</th>
	  </tr>
	</thead>
	<tbody>
		<c:forEach items="${film}" var="films">
			<tr>
				<td>
					
				</td>
			<td>${film.id_film}</td>
			<td>${film.description}</td>
			<td>film.store_location</td>
			</tr>	
		</c:forEach>
	</tbody>
	 
	  
	</table>
	  
  
  	
 
</body>
</html>