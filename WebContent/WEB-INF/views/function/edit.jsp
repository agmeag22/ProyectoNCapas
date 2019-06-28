<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Funcion</title>
<!-- Custom fonts for this template-->
  <link href="./../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="./../resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="./../resources/css/sb-admin.css" rel="stylesheet">
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
<body id="page-top">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script> 
		$(document).ready(function(){ 
		$("#films").val("${function.film.idfilm}").attr('selected', 'selected'); 
		$("#tickettype").val("${function.tickettype.idtype}").attr('selected', 'selected'); 
		$("#activestateCheck").prop('checked', ${function.activestate}!=0);
		}); 
		</script> 
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

  <div id="wrapper">

    <!-- Sidebar -->
      <ul class="sidebar navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/account/list">
          <i class="fas fa-fw fa-users"></i>
          <span>Usuarios</span>
        </a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/function/list">
          <i class="fas fa-fw fa-film"></i>
          <span>Cartelera</span></a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/film/list">
          <i class="fas fa-fw fa-film"></i>
          <span>Peliculas</span></a>
      </li>
    </ul>

    <div id="content-wrapper">

      <div class="container-fluid">        
        <!-- DataTables Example -->

<div class="col-sm-10 col-md-8 col-lg-8 offset-sm-1 offset-md-2 offset-lg-2">
  <h1>Editar Funcion</h1>
<form action="${pageContext.request.contextPath}/function/store"  method="post">
<input hidden name="idfunction" value="${function.idfunction}"/>
    <label for="inputName">Hora de inicio</label>
    <input type="time" class="form-control" id="inputName" name="starttime" value="${function.starttime}" aria-describedby="nameHelp" required >
    <small id="nameHelp" class="form-text text-muted">Ingresa la hora de inicio.</small>
  
  
 
  
  
  <div class="form-group">
      <label  for="films">Pelicula</label>
    <select id="films" class="form-control" name="film" required>
	  
	  <c:forEach items="${films}" var="film">
	  <option value="${film.idfilm}">${film.filmname}</option>
	  </c:forEach>
	</select>
  </div>
  
    <div class="form-group">
     <label  for="tickettype">Tipo de Ticket</label>
    <select id="tickettype" class="form-control" name="tickettype" required >
      
	  <c:forEach items="${tickettypes}" var="tickettype">
	  <option value="${tickettype.idtype}">${tickettype.type}</option>
	  </c:forEach>
	</select>
   
  </div>
  
   <div class="form-check form-group">
    
    <input type="checkbox" class="form-check-input"  name="activestate" id="activestateCheck" required>
    <label class="form-check-label" for="activestateCheck">Publicar</label>
   
  </div>
   
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
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