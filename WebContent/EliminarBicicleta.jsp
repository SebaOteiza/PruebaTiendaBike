<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eliminar Bicicleta</title>
</head>
<body>
	<h1>Eliminar Bicicleta</h1>
	<p>¿Estás seguro de eliminar la bicicleta?</p>
	
	<form action="EliminarBicicleta" method="POST">
	
		<input type ="hidden" value="${id}" name="id" />
		<button type="submit">Sí</button>
		<a href="/">No</a>
		
	</form>
	<a href="/">Volver al inicio</a>
</body>
</html>