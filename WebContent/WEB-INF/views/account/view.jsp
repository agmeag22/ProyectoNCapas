<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver Usuario - ${account.username}</title>

  <!-- Custom fonts for this template-->
  <link href="./../../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="./../../resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="./../../resources/css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" >Dashboard</a>

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

  <div id="wrapper">

    <!-- Sidebar -->
     <ul class="sidebar navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/account/list">
          <i class="fas fa-fw fa-users"></i>
          <span>Usuarios</span>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/function/list">
          <i class="fas fa-fw fa-film"></i>
          <span>Cartelera</span></a>
      </li>
       <li class="nav-item ">
        <a class="nav-link" href="${pageContext.request.contextPath}/film/list">
          <i class="fas fa-fw fa-film"></i>
          <span>Peliculas</span></a>
      </li>
    </ul>

    <div id="content-wrapper">

      <div class="container-fluid">        
        <!-- DataTables Example -->
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
    <input type="text" class="form-control" id="inputCredit" name="idrole" aria-describedby="roleHelp" value="${account.role.role}" readonly>
    <small id="roleHelp" class="form-text text-muted"> Rol del usuario.</small>
  </div>
          </div>
          </div>
          <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
        </div>

      </div>
      <!-- /.container-fluid -->

      <!-- Sticky Footer -->
      <footer class="sticky-footer">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright © N-Capas 2019</span>
          </div>
        </div>
      </footer>

    </div>
    <!-- /.content-wrapper -->

  </div>
  <!-- /#wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>



  <!-- Custom scripts for all pages-->
<script src="js/sb-admin.min.js"></script>

 

</body>
</html>