<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Usuario</title>

  <!-- Custom fonts for this template-->
  <link href="./resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="./resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="./resources/css/sb-admin.css" rel="stylesheet">

<style type="text/css">
	.wraper{
		display:flex;
		align-content: center;
		justify-content: center;
	}

</style>
</head>

<body id="page-top">
<div class="wraper">
<form action="${pageContext.request.contextPath}/client/store" method="post">
   <div class="form-group">
    <label for="inputName">Nombre</label>
    <input type="text" class="form-control" id="inputName" name="uname" aria-describedby="nameHelp" required>
    <small id="nameHelp" class="form-text text-muted">Nombre persona.</small>
  </div>
  
   <div class="form-group">
    <label for="inputLastName">Apellido</label>
    <input type="text" class="form-control" id="inputLastName" name="ulastname" aria-describedby="lastnameHelp"  required>
    <small id="lastnameHelp" class="form-text text-muted">Apellido persona.</small>
  </div>
    
    <div class="form-group">
    <label for="inputBirthdate">Fecha Nacimiento</label>
    <input type="date" class="form-control" id="inputBirthdate" name="ubirthdate" aria-describedby="birthdateHelp"  required>
    <small id="birthdateHelp" class="form-text text-muted">Fecha de Nacimiento.</small>
  </div>
 
  <div class="form-group">
    <label for="inputPoster">Pais</label>
     <div class="input-group mb-3">
		  <div class="input-group-prepend">
		  <select class="custom-select" id="inputPais" name="ucountry" aria-describedby="countryHelp" required> 
		  	<c:forEach items="${countries}" var="country">
		    <option value="${country.name}">${country.name}</option>
		    </c:forEach>
		  </select>
		</div> 
   
  </div>
  </div> 
   <small id="countryHelp" class="form-text text-muted">Pais de la persona.</small> 
    <div class="input-group mb-3">
		  <div class="input-group-prepend">
		  <select class="custom-select" id="inputMunicipality" name="umunicipality" aria-describedby="municipalityHelp" required> 
		  	<c:forEach items="${municipalities}" var="municipality">
		    <option value="${municipality.municipio}">${municipality.municipio}</option>
		    </c:forEach>
		  </select> 
		</div> 
  </div>
   <small id="municipalityHelp" class="form-text text-muted">Municipio de la persona.</small>

<div class="form-group">
    <label for="inputAddress">Dirección</label>
    <input type="text" class="form-control" id="inputAddress" name="uaddress" aria-describedby="addressHelp"  required>
    <small id="addressHelp" class="form-text text-muted">Dirección fisica de la persona (Domicilio).</small>
  </div>
  
   <div class="form-group">
    <label for="inputUsername">Username</label>
    <input type="text" class="form-control" id="inputUsername" name="username" aria-describedby="usernameHelp"  required>
    <small id="usernameHelp" class="form-text text-muted">Nombre de Usuario.</small>
  </div>
  <div class="form-group">
    <label for="inputPassword">Password</label>
    <input type="text" class="form-control" id="inputPassword" name="password" aria-describedby="passwordHelp"  required>
    <small id="passwordHelp" class="form-text text-muted"> Contraseña de Usuario.</small>
  </div>
  <button type="submit" class="btn btn-primary">Guardar</button>
  </form>
  </div>
  
</body>
</html>