<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Catalogo de Funciones</title>
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
				height: auto;
			}
			
		body{
		  background-position: center;
		  background-image: url("./resources/prism.png");
		  }
		  
		  .btnright{
		  position:absolute;
		    transition: .5s ease;
		    top: 10%;
		    right: 80%;
		  }
		  .btnleft{
		  position:absolute;
		    transition: .5s ease;
		    top: 10%;
		    left: 90%;
		  }
		</style>
	</head>
	<body>
	
	 
	
  <form method="POST" action="${pageContext.request.contextPath}/transaction/list" >
  <button type="submit" class="btn btn-outline-light btnright">Historial de transacciones</button>
	</form>
<form method="POST" action="${pageContext.request.contextPath}/logout" >
  <button type="submit" class="btn btn-danger btnleft">Log Out</button>
  </form>
	
		<div class="container">
			<div class="form-container">
				<div class="film-detail">
					<div class="row">
						<c:forEach items="${films}" var="film">
				    		<div class="col-md-3">
				    			<div class="card">
								  <img src="${film.urlposter}" class="card-img-top" >
								  <div class="card-body">
								    <p class="card-text">Película: ${film.filmname}</p>
								    <p class="card-text">Duración: ${film.duration}</p>
								    <a href="${pageContext.request.contextPath}/film-detail/${film.idfilm}" class="btn btn-outline-warning w-100" name="id">Ver más.</a>
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