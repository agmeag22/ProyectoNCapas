<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		body {
		  background-position: center;
		  background-image: url("./../../resources/prism.png");
		  padding: 5%;
		  color:white;
		}
		  
		.card-img-top {
			width: 400px;
			height: auto;
		}

		.form-container {
			width: 100%;
			margin: 0 auto;
		}
		
		.card-info {
			padding: 15px;
		}
		
		.card-text {
			color: #222222;
		}
		
		.card-info .divider {
			background: #eeeeee;
		}
		
		.card-info .description {
			font-size: 9pt;
			text-align: justify;
		}
		
		.text-info-t {
			color: #222222;
		}
</style>
</head>
<body>
	<div class="container">
	  	<form method="POST" action="${pageContext.request.contextPath}/logout" >
		  <button type="submit" class="btn btn-danger btnleft">Log Out</button>
		</form>
			<br>
			<br>
		<div class="form-container">
			<h3 class="text-center">Reserva</h3>
			<br>
			<br>
			<form action="${pageContext.request.contextPath}/film-detail/${transaction.function.film.idfilm}/reservado"
				method="post" modelAttribute="transaction">
				<div class="row">
					<div class="col-md-6 text-center">
						<img src="${transaction.function.film.urlposter}" class="card-img-top" height="50%" width="50%">
					</div>
					<div class="col-md-6">
						<div class="card card-info">
							<input name="idfunction" value="${transaction.function.idfunction }" hidden>
							<input name="idaccount" value="${transaction.account.idaccount}" hidden>
							<input name="ticketquantity" value="${transaction.ticketquantity}" hidden>
							<input name="total" value="${transaction.total}" hidden>
							<h3 class="text-center card-text">${transaction.function.film.filmname} | ${transaction.function.tickettype.type}</h3><hr class="divider">
							<p class="description card-text">${transaction.function.film.description}</p>
							<div class="row">
								<div class="col-md-6">
									<p class="text-info-t">Duración: ${transaction.function.film.duration}</p>
									<p class="text-info-t">Horarios Escogido: ${transaction.function.starttime}</p>
									<p class="text-info-t">Cantidad de asientos : ${transaction.ticketquantity}</p>
									<p class="text-info-t">Costo por ticket :$${transaction.function.tickettype.ticketcost}</p>
								</div>
								<div class="col-md-6">
									<p class="text-info-t">Subtotal : $${subtotal}</p>
									<p class="text-info-t">Saldo de la cuenta : $${saldoutilizado}</p>
									<p class="text-info-t">Saldo remanente: $${saldocuenta}</p>
									<p class="text-info-t">Gran total : $${transaction.total}</p>
								</div>
							</div><br>
							<input name="saldocuenta" hidden value="${saldocuenta}">
							
							<button type="submit" class="btn btn-primary w-100">Continuar</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>