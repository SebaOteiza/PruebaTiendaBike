<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar bicicletas</title>
</head>
<body>

<h1>Listar Bicicletas</h1>

	<table>
	<tr>
		<th>Modelo</th>
		<th>Color</th>
		<th>Tamaño de aro </th>
		<th>Precio</th>
		<th>Marca</th>
		<th>Acciones</th>
	</tr>
	
	<c:forEach items="${bicicletas}"  var="bicicleta">
	<tr>
		<td>${bicicleta.getBicicleta().getModelo()}</td>
		<td>${bicicleta.getBicicleta().getColor()}</td>
		<td>${bicicleta.getBicicleta().getAro()}</td>
		<td>${bicicleta.getBicicleta().getPrecio()}</td>
		<td>${bicicleta.getMarca().getNombre()}</td>
		<td>
			<a href="/ModificarBicicleta?id_bicicleta=${bicicleta.getBicicleta().getId()}">Modificar</a>&nbsp;
			<a href="/EliminarBicicleta?id=${bicicleta.getBicicleta().getId()}">Eliminar</a>
		
		</td>
		
	</tr>
	</c:forEach>
	</table>
	<a href="/" >Volver</a>
</body>
</html>