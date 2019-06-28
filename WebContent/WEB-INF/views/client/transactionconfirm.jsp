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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		
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
			<form action="${pageContext.request.contextPath}/film-detail/${transaction.function.film.idfilm}/reservado"
				method="post" modelAttribute="transaction">
				<div class="col-md-4">
					<img src="${transaction.function.film.urlposter}" class="card-img-top" height="50%" width="50%">
				</div>
				<input name="idfunction" value="${transaction.function.idfunction }" hidden>
				<input name="idaccount" value="${transaction.account.idaccount}" hidden>
				<input name="ticketquantity" value="${transaction.ticketquantity}" hidden>
				<input name="total" value="${transaction.total}" hidden>
				<p class="card-text">Película: ${transaction.function.film.filmname}</p>
				<p class="card-text">Duración: ${transaction.function.film.duration}</p>
				<p class="card-text">Horario Escogido : ${transaction.function.starttime}</p>
				<p class="card-text">Tipo de asientos : ${transaction.function.tickettype.type}</p>
				<p class="card-text">Cantidad de asientos : ${transaction.ticketquantity}</p>
				<p class="card-text">Costo por ticket :$${transaction.function.tickettype.ticketcost}</p>
				<p class="card-text">Subtotal : $${subtotal}</p>
				<p class="card-text">Saldo a utilizar de la cuenta : $${saldoutilizado}</p>
				<p class="card-text">Saldo remanente de la cuenta : $${saldocuenta}</p>
				<p class="card-text">Gran total : $${transaction.total}</p>
				<input name="saldocuenta" hidden value="${saldocuenta}">
				
				<button type="submit" class="btn btn-primary w-100">Continuar</button>
			</form>
		</div>
	</div>
</body>
</html>