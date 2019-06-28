<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
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
</head>
<body id="page-top">

        <div class="col-sm-10 col-md-10 col-lg-10 offset-sm-1 offset-md-1 offset-lg-1">
<h1>Listado Transacciones</h1>
<form class="needs-validation" action="" method="get">
  <div class="form-row">
  
	    <div class="col-md-4 col-lg-2 mb-3">
	    <label>Inicio:</label>
		<input type="date" class="form-control" name="start" />
		</div>
		<div class="col-md-4 col-lg-2 mb-3">
		<label>Fin:</label>
		<input type="date" class="form-control" name="end" />
		</div>
		<div class="col-md-4 col-lg-2 mb-3">
		<label></label>
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
	<table class="table">
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
						  <a onclick="showModal('${film.function.film.filmname}','${film.ticketquantity}','${film.function.tickettype.type}')" class="btn btn-secondary">Ver</a>
						</div>
					</td>
				<td>${film.idtransaction}</td>
				<td>${film.transactiondatehour}</td>
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
        
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
 
</div>
<script>
function showModal(pelicula,cantidad,ticket){
	$('#pelicula').html(pelicula);
	 $('#cantidad').html(cantidad);
	 $('#ticket').html(ticket);
	$('#commentModal').modal();
	
}
</script>
    

</body>

</html>