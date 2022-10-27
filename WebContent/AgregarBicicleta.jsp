<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar bicicleta</title>
</head>
<body>

<h1>Agregar bicicleta</h1>

	<form action="/AgregarBicicleta" method="POST">
	
		<label for="modelo">Modelo</label>
		<input type ="text" name="modelo" id="modelo"/>
		
		<label for="color">Color</label>
		<input type ="text" name="color" id="color"/>
		
		
		<label for="aro">Tamaño de aro</label>
		<input type ="number" name="aro" id="aro"/>
		
		<label for="precio">Precio</label>
		<input type ="number" name="precio" id="precio"/>
		
		<label for="marca" >Marca</label>
		<select name="marca" id="marca"> 
			<c:forEach items="${marcas} var="marca">
			<option value="${marca.getId()}">${marca.getNombre()}</option>
			
			</c:forEach>
		</select>
		
		<button type= "submit">Enviar</button>
		
	</form>
	
	<a href="/"> volver al inicio</a>
	
</body>
</html>