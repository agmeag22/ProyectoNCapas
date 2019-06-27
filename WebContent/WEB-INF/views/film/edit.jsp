<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Pelicula</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="col-sm-10 col-md-8 col-lg-8 offset-sm-1 offset-md-2 offset-lg-2">
<h1>Editar Pelicula</h1>
<form action="${pageContext.request.contextPath}/film/store" modelAttribute="film" method="post">
<input hidden name="idfilm" value="${film.idfilm}"/>
  <div class="form-group">
    <label for="inputName">Nombre</label>
    <input type="text" class="form-control" id="inputName" name="filmname" aria-describedby="nameHelp" value="${film.filmname}" required>
    <small id="nameHelp" class="form-text text-muted">Ingresa el nombre de la pelicula.</small>
  </div>
  
   <div class="form-group">
    <label for="inputDesc">Descripcion</label>
    <input type="text" class="form-control" id="inputDesc" name="description" aria-describedby="descHelp" value="${film.description}" required>
    <small id="descHelp" class="form-text text-muted">Ingresa la descripcion de la pelicula.</small>
  </div>
  
  
    <div class="form-group">
    <label for="inputDuracion">Duracion</label>
    <input type="text" class="form-control" id="inputDuracion" name="duration" aria-describedby="durHelp" value="${film.duration}" required>
    <small id="durHelp" class="form-text text-muted">Ingresa la duracion de la pelicula.</small>
  </div>
 
  <div class="form-group">
    <label for="inputPoster">Poster (URL)</label>
    <input type="text" class="form-control" id="inputPoster" name="urlposter" aria-describedby="posterHelp" value="${film.urlposter}" required>
    <small id="posterHelp" class="form-text text-muted">Ingresa la duracion de la pelicula.</small>
  </div>
  <button type="submit" class="btn btn-primary">Guardar</button>
</form>
</div>
</body>
</html>