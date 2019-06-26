<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver Usuario - ${account.username}</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="col-sm-10 col-md-8 col-lg-8 offset-sm-1 offset-md-2 offset-lg-2">
<h1>Ver Usuario</h1>


   <div class="form-group">
    <label for="inputName">Nombre</label>
    <input type="text" class="form-control" id="inputName" name="uname" aria-describedby="nameHelp" value="${account.user.uname}" readonly>
    <small id="nameHelp" class="form-text text-muted">Nombre persona.</small>
  </div>
  
   <div class="form-group">
    <label for="inputLastName">Apellido</label>
    <input type="text" class="form-control" id="inputLastName" name="ulastname" aria-describedby="lastnameHelp" value="${account.user.ulastname}" readonly>
    <small id="lastnameHelp" class="form-text text-muted">Apellido persona.</small>
  </div>
    
    <div class="form-group">
    <label for="inputBirthdate">Fecha Nacimiento</label>
    <input type="text" class="form-control" id="inputBirthdate" name="ubirthdate" aria-describedby="birthdateHelp" value="${account.user.ubirthdate}" readonly>
    <small id="birthdateHelp" class="form-text text-muted">Fecha de Nacimiento.</small>
  </div>
 
  <div class="form-group">
    <label for="inputPoster">Pais</label>
    <input type="text" class="form-control" id="inputCountry" name="ucountry" aria-describedby="countryHelp" value="${account.user.ucountry}" readonly>
    <small id="countryHelp" class="form-text text-muted">Pais de la persona.</small>
  </div>
   <div class="form-group">
    <label for="inputMunicipality">Municipio</label>
    <input type="text" class="form-control" id="inputMunicipality" name="umunicipality" aria-describedby="municipalityHelp" value="${account.user.umunicipality}" readonly>
    <small id="municipalityHelp" class="form-text text-muted">Municipio de la persona.</small>
  </div>
  <div class="form-group">
    <label for="inputMunicipality">Dirección</label>
    <input type="text" class="form-control" id="inputAddress" name="uaddress" aria-describedby="addressHelp" value="${account.user.uaddress}" readonly>
    <small id="addressHelp" class="form-text text-muted"> Direccion de la persona.</small>
  </div>
  
  </div>
   <div class="form-group">
    <label for="inputUsername">Username</label>
    <input type="text" class="form-control" id="inputUsername" name="username" aria-describedby="usernameHelp" value="${account.username}" readonly>
    <small id="usernameHelp" class="form-text text-muted">Nombre de Usuario.</small>
  </div>
  <div class="form-group">
    <label for="inputPassword">Password</label>
    <input type="text" class="form-control" id="inputPassword" name="password" aria-describedby="passwordHelp" value="${account.password}" readonly>
    <small id="passwordHelp" class="form-text text-muted"> Contraseña de Usuario.</small>
  </div>
  
   <div class="form-group">
    <label for="inputState">Estado del usuario</label>
    <input type="text" class="form-control" id="inputState name="activestate" aria-describedby="activestateHelp" value="${account.activestate}" >
    <small id="activestateHelp" class="form-text text-muted">Estado activo o inactivo</small>
  </div>
  
  <div class="form-group">
    <label for="inputOnline">Online</label>
    <input type="text" class="form-control" id="inputOnline" name="onlinestatus" aria-describedby="OnlineHelp" value="${account.onlinestatus}" readonly>
    <small id="OnlineHelp" class="form-text text-muted"> Estado Online.</small>
  </div>
  
   <div class="form-group">
    <label for="inputComentario">Comentario</label>
    <input type="text" class="form-control" id="inputComentario" name="comment" aria-describedby="commentHelp" value="${account.comment}" readonly>
    <small id="commentHelp" class="form-text text-muted">Comentario en caso de ser desactivado.</small>
  </div>
  <div class="form-group">
    <label for="inputCredit">Credito</label>
    <input type="text" class="form-control" id="inputCredit" name="credit" aria-describedby="creditHelp" value="${account.credit}" readonly>
    <small id="creditHelp" class="form-text text-muted"> Credito disponible del usuario.</small>
  </div>
  
  <div class="form-group">
    <label for="inputRole">Rol</label>
    <input type="text" class="form-control" id="inputCredit" name="idrole" aria-describedby="roleHelp" value="${account.role.idrole}" readonly>
    <small id="roleHelp" class="form-text text-muted"> Rol del usuario.</small>
  </div>
</body>
</html>