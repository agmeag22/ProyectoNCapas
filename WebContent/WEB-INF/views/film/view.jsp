<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver Pelicula - ${film.filmname}</title>
 <!-- Custom fonts for this template-->
  <link href="./../../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="./../../resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="./../../resources/css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body id="page-top">

  <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" >Dashboard</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
      <i class="fas fa-bars"></i>
    </button>

    <!-- Navbar -->
    <ul class="navbar-nav ml-auto ml-md-0">
          <a class="nav-link " href="${pageContext.request.contextPath}/logout">
          <button class="btn btn-outline-danger btn-sm btn-block" >Logout</button>
        </a>  
    </ul>

  </nav>

  <div id="wrapper">

    <!-- Sidebar -->
      <ul class="sidebar navbar-nav">
      <li class="nav-item">
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
       <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/film/list">
          <i class="fas fa-fw fa-film"></i>
          <span>Peliculas</span></a>
      </li>
    </ul>

    <div id="content-wrapper">

      <div class="container-fluid">        
        <!-- DataTables Example -->
        <div class="col-sm-10 col-md-8 col-lg-8 offset-sm-1 offset-md-2 offset-lg-2">
<h1>Ver Pelicula</h1>


   <div class="form-group">
    <label for="inputName">Nombre</label>
    <input type="text" class="form-control" id="inputName" name="filmname" aria-describedby="nameHelp" value="${film.filmname}" readonly>
    <small id="nameHelp" class="form-text text-muted">Ingresa el nombre de la pelicula.</small>
  </div>
  
   <div class="form-group">
    <label for="inputDesc">Descripcion</label>
    <input type="text" class="form-control" id="inputDesc" name="description" aria-describedby="descHelp" value="${film.description}" readonly>
    <small id="descHelp" class="form-text text-muted">Ingresa la descripcion de la pelicula.</small>
  </div>
  
  
    <div class="form-group">
    <label for="inputDuracion">Duracion</label>
    <input type="text" class="form-control" id="inputDuracion" name="duration" aria-describedby="durHelp" value="${film.duration}" readonly>
    <small id="durHelp" class="form-text text-muted">Ingresa la duracion de la pelicula.</small>
  </div>
 
  <div class="form-group">
    <label for="inputPoster">Poster (URL)</label>
    <input type="text" class="form-control" id="inputPoster" name="urlposter" aria-describedby="posterHelp" value="${film.urlposter}" readonly>
    <small id="posterHelp" class="form-text text-muted">Ingresa la duracion de la pelicula.</small>
  </div>
  <img src="${film.urlposter}"/>
  

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