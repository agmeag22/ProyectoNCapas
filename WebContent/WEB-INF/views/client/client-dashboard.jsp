<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>TAREA 01 DE PROGRAMACIÓN DE N-CAPAS | BIBLIOTECA</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<style>
			body {
				background: #eeeeee;
				padding: 5%;
			}
			
			.form-container {
				width: 75%;
				margin: 0 auto;
			}
			
			.filter-form {
				width: 100%;
				display: flex;
			}
			.film-detail {
				margin-top: 100px;
			}
			
			.film-detail .card {
				margin-bottom: 20px;
			}
			
			.card-img-top {
				height: 400px;
			}
		</style>
	</head>
	<body>
	<form method="POST" action="${pageContext.request.contextPath}/logout" ModelAttribute="account">
	<input type="submit" class="btn btn-danger" value="Log Out">
	</form> 
	
		<div class="container">
			<div class="form-container">
				<form class="filter-form" method="POST" action="${pageContext.request.contextPath}/dashboard">
					<div class="input-group">
					  <input type="text" class="form-control" name="filter" placeholder="Buscar..." autocomplete="off" >
					  <div class="input-group-prepend" style="width:20%;">
						  <input type="submit" class="btn btn-dark w-100" value="Ir">
					  </div>
					</div>
				</form>
				
				<div class="film-detail">
					<div class="row">
						<c:forEach items="${films}" var="film">
				    		<div class="col-md-4">
				    			<div class="card">
								  <img src="${film.urlposter}" class="card-img-top">
								  <div class="card-body">
								    <p class="card-text">Película: ${film.filmname}</p>
								    <p class="card-text">Duración: ${film.duration}</p>
								    <a href="${pageContext.request.contextPath}/film-detail?id=${film.idfilm}" class="btn btn-outline-warning w-100">Ver más.</a>
								  </div>
								</div>
				    		</div>
				    	</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>