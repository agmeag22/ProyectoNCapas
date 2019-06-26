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
<style type="text/css">
	.wraper{
		display:flex;
		align-content: center;
		justify-content: center;
	}
	.button{
		margin:20px;
	}

</style>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script> 
$(document).ready(function(){ 
$("#films").val("${function.film.idfilm}").attr('selected', 'selected'); 
$("#tickettype").val("${function.tickettype.idtype}").attr('selected', 'selected'); 
$("#activestateCheck").prop('checked', ${function.activestate}!=0);
document.getElementById("activestateCheck").disabled = true;
}); 
</script> 
<div class="col-sm-10 col-md-8 col-lg-8 offset-sm-1 offset-md-2 offset-lg-2">
<h1>Ver Funcion</h1>
<input hidden name="idfunction" value="${function.idfunction}"/>
    <label for="inputName">Hora de inicio</label>
    <input type="time" class="form-control" id="inputName" name="starttime" value="${function.starttime}" aria-describedby="nameHelp" readonly >
    <small id="nameHelp" class="form-text text-muted">Ingresa la hora de inicio.</small>
  
  
 
  
  
  <div class="form-group">
      <label  for="films">Pelicula</label>
    <select id="films" class="form-control" name="film" readonly>
	  
	  <c:forEach items="${films}" var="film">
	  <option value="${film.idfilm}">${film.filmname}</option>
	  </c:forEach>
	</select>

  </div>
  
    <div class="form-group">
     <label  for="tickettype">Tipo de Ticket</label>
    <select id="tickettype" class="form-control" name="tickettype" readonly >
      
	  <c:forEach items="${tickettypes}" var="tickettype">
	  <option value="${tickettype.idtype}">${tickettype.type}</option>
	  </c:forEach>
	</select>
   
  </div>
  
   <div class="form-check form-group">
    
    <input type="checkbox" class="form-check-input"  name="activestate" id="activestateCheck" readonly>
    <label class="form-check-label" for="activestateCheck">Publicar</label>
   
  </div>
   

</div>
</body>
</html>