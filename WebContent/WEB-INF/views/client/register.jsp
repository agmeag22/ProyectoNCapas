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
  <link href="./../../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="./../../resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="./../../resources/css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="index.html">Dashboard</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
      <i class="fas fa-bars"></i>
    </button>

    <!-- Navbar -->
    <ul class="navbar-nav ml-auto ml-md-0">
        <a class="nav-link ">
          <button class="btn btn-outline-danger btn-sm btn-block" >Logout</button>
        </a>  
      </li>
    </ul>

  </nav>

      <div class="container-fluid">        
        <!-- DataTables Example -->
        <div class="col-sm-10 col-md-8 col-lg-8 offset-sm-1 offset-md-2 offset-lg-2">
	<h1>Ver Usuario</h1>


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
    <input type="text" class="form-control" id="inputBirthdate" name="ubirthdate" aria-describedby="birthdateHelp"  required>
    <small id="birthdateHelp" class="form-text text-muted">Fecha de Nacimiento.</small>
  </div>
 
  <div class="form-group">
    <label for="inputPoster">Pais</label>
    <input type="text" class="form-control" id="inputCountry" name="ucountry" aria-describedby="countryHelp"  required>
    <small id="countryHelp" class="form-text text-muted">Pais de la persona.</small>
  </div>
   <div class="form-group">
    <label for="inputMunicipality">Municipio</label>
    <input type="text" class="form-control" id="inputMunicipality" name="umunicipality" aria-describedby="municipalityHelp"  required>
    <small id="municipalityHelp" class="form-text text-muted">Municipio de la persona.</small>
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
  
   <div class="form-group">
    <label for="inputState">Estado del usuario</label>
    <input type="text" class="form-control" id="inputState name="activestate" aria-describedby="activestateHelp" required >
    <small id="activestateHelp" class="form-text text-muted">Estado activo o inactivo</small>
  </div>
  
  <div class="form-group">
    <label for="inputOnline">Online</label>
    <input type="text" class="form-control" id="inputOnline" name="onlinestatus" aria-describedby="OnlineHelp"  required>
    <small id="OnlineHelp" class="form-text text-muted"> Estado Online.</small>
  </div>
  
   <div class="form-group">
    <label for="inputComentario">Comentario</label>
    <input type="text" class="form-control" id="inputComentario" name="comment" aria-describedby="commentHelp" required>
    <small id="commentHelp" class="form-text text-muted">Comentario en caso de ser desactivado.</small>
  </div>
  <div class="form-group">
    <label for="inputCredit">Credito</label>
    <input type="text" class="form-control" id="inputCredit" name="credit" aria-describedby="creditHelp"  required>
    <small id="creditHelp" class="form-text text-muted"> Credito disponible del usuario.</small>
  </div>
  
  <div class="form-group">
    <label for="inputRole">Rol</label>
    <input type="text" class="form-control" id="inputCredit" name="idrole" aria-describedby="roleHelp"  required>
    <small id="roleHelp" class="form-text text-muted"> Rol del usuario.</small>
  </div>
          
 

</body>
</html>