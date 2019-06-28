<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado Transacciones</title>
 <!-- Custom fonts for this template-->
  <link href="./../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="./../resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  

  <!-- Custom styles for this template-->
  <link href="./../resources/css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style type="text/css">
body{
		  background-position: center;
		  background-image: url("./../resources/prism.png");
		  padding: 5%;
		  color:white;
		  }
		  .modal{
		  	color:black;
		  }
		  .table{
		  color:white;
		  }
</style>
</head>
<body id="page-top">

        <div class="col-sm-10 col-md-10 col-lg-10 offset-sm-1 offset-md-1 offset-lg-1">
<h1>Listado Transacciones</h1><br>
<form method="POST" action="${pageContext.request.contextPath}/logout" >
  <button type="submit" class="btn btn-danger btnleft">Log Out</button>
  </form><br>
<form class="form-horizontal" action="" method="get">
  <div class="form-row">
  
	    <div class="col-md-4 col-lg-2 mb-3">
	    <label  class ="control-label col-sm-3">Inicio:</label>
	    <div class="	">
		<input type="date" class="form-control" name="start" value="<fmt:formatDate value="${start}" pattern="yyyy-MM-dd" />"/>
		</div>
		</div>
		<div class="col-md-4 col-lg-2 mb-3">
		<label class ="control-label col-sm-3">Fin:</label>
		<div class="">
		<input type="date" class="form-control" name="end" value="<fmt:formatDate value="${end}" pattern="yyyy-MM-dd" />" />
		</div>
		</div>
		<div class="col-md-4 col-lg-2 mb-3">
		<label class ="control-label col-sm-3" style="color:transparent">SS</label>
		<input type="submit" class="form-control" value="Filtrar"/>
		</div>
	</div>
	</form>
<div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
		<div class="btn-group btn-group align-left" role="group" >
		</div>
		
			<div class="btn-group align-rigth" role="group" aria-label="Button group with nested dropdown">
		  <c:if test = "${pagina > 1}">
		  <a href=" ${pageContext.request.contextPath}/film/list?page=${pagina-2}" class="btn btn-secondary">Anterior</a>
		  </c:if>
		  
		  <c:if test = "${pagina < total/10}">
		  <a  href=" ${pageContext.request.contextPath}/film/list?page=${pagina}"class="btn btn-secondary">Siguiente</a>
		  </c:if>
		  </div>
	</div>
	
<br/>
	<table class="table table-sm table-bordered">
		<thead>
		  <tr>
		    <th scope="col">Accion</th>
		    <th scope="col">Codigo</th>
		    <th scope="col">Fecha Transaccion</th>
		    
		  </tr>
		</thead>
		<tbody>
			<c:forEach items="${films}" var="film">
				<tr>
					<td>
						<div class="btn-group" role="group">
						  <a onclick="showModal('${film.function.film.filmname}','${film.ticketquantity}','${film.function.tickettype.type}','$${film.total}')" class="btn btn-secondary">Ver</a>
						</div>
					</td>
				<td><fmt:formatNumber pattern = "########"
         minIntegerDigits="8" value = "${film.idtransaction}" /></td>
				<td><fmt:formatDate value="${film.transactiondatehour}" pattern="MM-dd-yyyy HH:mm" /></td>
				</tr>	
			</c:forEach>
		</tbody>  
	</table>
<p class="text-right"> Mostrando ${actual}/${total}</p>
	  
  
</div>
</div>

 
<div class="modal fade" id="commentModal" tabindex="-1" role="dialog" aria-labelledby="commentModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="commentModalLabel">Detalles</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <p>Pelicula: <span id="pelicula"></span></p>
      <p>Cantidad: <span id="cantidad"></span></p>
      <p>Tipo Asiento: <span id="ticket"></span></p>
      <p>Total: <span id="total"></span></p>  
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
 
</div>
<script>
function showModal(pelicula,cantidad,ticket,total){
	$('#pelicula').html(pelicula);
	 $('#cantidad').html(cantidad);
	 $('#ticket').html(ticket);
	 $('#total').html(total);
	$('#commentModal').modal();
	
}
</script>
    

</body>

</html>