<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Funcion</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<form>
  <div class="form-group">
    <label for="inputName">Hora de inicio</label>
    <input type="text" class="form-control" id="inputName" name="starttime" aria-describedby="nameHelp" placeholder="Enter email">
    <small id="nameHelp" class="form-text text-muted">Ingresa el nombre de la pelicula.</small>
  </div>
  
  <div class="form-check">
    <input type="checkbox" class="form-check-input"  name="activestate" id="activestateCheck">
    <label class="form-check-label" for="activestateCheck">Publicar</label>
  </div>
  
  
  <div class="form-check">
    <select id="films" class="form-control" name="film">
	  <option value="0">Selecciona una opcion</option>
	  <c:forEach items="${film}" var="films">
	  <option value="${film.idfilm }">${film.filmname}</option>
	  </c:forEach>
	</select>
    <label  for="films">Pelicula</label>
  </div>
  
    <div class="form-check">
    <select id="tickettype" class="form-control" name="tickettype">
      <option value="0">Selecciona una opcion</option>
	  <c:forEach items="${tickettype}" var="tickettypes">
	  <option value="${tickettype.idtype }">${film.type}</option>
	  </c:forEach>
	</select>
    <label  for="tickettype">Tipo de Ticket</label>
  </div>
  
  
   
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>