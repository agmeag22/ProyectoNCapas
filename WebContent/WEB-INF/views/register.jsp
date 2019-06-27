<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/register" method = "post">
		<input type="text" id="name" class="form-control t" name="uname" placeholder="Name">
		<input type="text" id="lastname" class="form-control t" name="ulastname" placeholder="Last_name">
		
		
		  <select class="custom-select" id="inputGroupSelect01" name="ucountry">
		  	<option selected>${paises.name}</option>
		  	<c:forEach items="${paises}" var="paises">
		    <option value="${paises.name}">${paises.name}</option>
		    </c:forEach>
		  </select>
		  
		<input type="text" id="bdate" class="form-control t" name="ubirthdate" placeholder="Birthdate">
		<input type="text" id="adress" class="form-control t" name="uaddress" placeholder="Address">
		
		<input type="text" id="username" class="form-control t" name="username" placeholder="User">
		<input type="password" id="password" class="form-control t" name="password" placeholder="Password">
		
		<input type="submit" class="btn btn-outline-dark t e" value="Registrarse">

    </form>
</body>
</html>