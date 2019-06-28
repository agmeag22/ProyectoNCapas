<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
s
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaccion en proceso</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<!-- Custom fonts for this template-->
<link href="./../../resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link
	href="./../../resources/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="./../../resources/css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		
		
<style>
	body{
		  background-position: center;
		  background-image: url("./../../resources/prism.png");
		  padding: 5%;
		  color:white;
		  }

.form-container {
	width: 50%;
	margin: 0 auto;
}
</style>
</head>
<body>
	<div class="container">
		<div class="form-container">
			<h3 class="text-center">Reserva</h3>
			<br>
			<br>
			<form action="${pageContext.request.contextPath}//film-detail/${film.idfilm}/reservacion"
				method="post">
				<div class="col-md-4">
					<img src="${film.urlposter}" class="card-img-top" height="50%" width="50%">
				</div>
				<p class="card-text">Película: ${film.filmname}</p>
				<p class="card-text">Duración: ${film.duration}</p>
				<div class="form-group">
					<label for="idfilm">Horario Funcion</label> 
					<select id="idfunction" class="form-control" name="idfunction" required>
						<c:forEach items="${functions}" var="function">
							<option value="${function.idfunction}">${function.starttime}  -  ${function.tickettype.type}</option>
						</c:forEach>
					</select>
				</div>

				
				<div class="form-group">
					<label for="ticketquantity">Cantidad de tickets</label> <select
						id="ticketquantity" class="form-control" name="ticketquantity"
						required>
						<option selected value="1">1</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="14">15</option>
					</select>
				</div>
				<div class="form-check form-group">
					<input type="checkbox" class="form-check-input"  name="accountcredit" id="accountcredit" >
					<label class="form-check-label" for="accountcredit">Utilizar saldo cuenta</label>
				</div>
				<button type="submit" class="btn btn-primary w-100">Continuar</button>
			</form>
		</div>
	</div>
</body>
</html>