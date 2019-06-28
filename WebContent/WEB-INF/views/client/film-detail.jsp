<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Film-detail-${film.filmname}</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<style>
			body {
			  background-position: center;
			  background-image: url("./../resources/prism.png");
			  padding: 5%;
			  color:white;
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
				height: auto;
			}
			
			.btnsize{
				margin:10px;
			}
			
			.card-film {
				padding: 25px 25px;
			}
			
			.card-film h3 {
				color: #222222;
			}
			
			.card-film p {
				color: #222222;
			}
			
			.card-film .divider {
				background: #eeeeee;
			}
			
			.description {
				font-size: 9pt;
				text-align: justify;
			}
			
			.function-row {
				padding: 5px;
			}
		</style>
	</head>
	<body>
		<div class="container">
		  <form method="POST" action="${pageContext.request.contextPath}/logout" >
		  	<button type="submit" class="btn btn-danger btnleft">Log Out</button>
		  </form>
			<div class="row">
				<div class="col-md-4">
					<img src="${film.urlposter}" class="card-img-top" height="50%" width="50%">
				</div>
				<div class="col-md-6">
					<div class="card container card-film">
						<h3 class="text-center">${film.filmname}</h3><hr class="divider">
						<p class="description">${film.description}</p>
				    	<p class="card-text">Duración: ${film.duration}</p>
				    	<p class="card-text">Horarios: ${film.filmname}</p><br>
			    		<div class="row">
			    			<c:forEach items="${functions}" var="function">
							  <div class="col-md-6 function-row">
							  	<button class="btn btn-light w-100" disabled>${function.starttime}  -  ${function.tickettype.type}</button>
							  </div>
							</c:forEach>
			    		</div><br>
					    <a href="${pageContext.request.contextPath}/film-detail/${film.idfilm}/reserva" class="btn btn-outline-warning w-100" >Reservar.</a>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>