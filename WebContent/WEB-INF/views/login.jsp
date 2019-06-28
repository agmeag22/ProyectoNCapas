<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="./resources/css/bootstrap.css" media="all" type="text/css" rel="stylesheet">
<style type="text/css">
	.wraper{
		display:flex;
		align-content: center;
		justify-content: center;
		margin-top: 60px;
	}
	.container{
		margin-top: 50%;
	}
	
	.t{
		margin-top: 10px;
	}
	.e{
		margin-left: 80px;
	}
	body{
		  background-position: center;
		  background-image: url("./resources/prism.png");
		  }

</style>
</head>
<body>

<div class="wraper">
    <form action="${pageContext.request.contextPath}/login" method ="post">
    <div class="form-group col-md-12 container">
		<input type="text" id="login" class="form-control t" name="username" placeholder="Username">
		<input type="password" id="password" class="form-control" name="password" placeholder="Password">
		<div align="center">
		<input type="submit" class="btn btn-outline-light t" value="Iniciar Sesión">
		<a class="btn btn-outline-primary t" href="${pageContext.request.contextPath}/register">Registrarse</a>
		</div>
    </div>
    
    
    </form>
  </div>
</body>
</html>