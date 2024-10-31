<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle de la Canción</title>
</head>
<body>
	<h1>Detalle de la Canción</h1>
	<p><b>Título:</b> ${cancion.titulo}</p>
	<p><b>Artista:</b> ${cancion.artista}</p>
	<p><b>Álbum:</b> ${cancion.album}</p>
	<p><b>Género:</b> ${cancion.genero}</p>
	<p><b>Idioma:</b> ${cancion.idioma}</p>
	
	<a href='<c:url value="/canciones/formulario/editar/${cancion.id}"/>'>Editar</a>
	<form action="/canciones/eliminar/${cancion.id}" method="POST">
		<input type="hidden" name="_method" value="DELETE"/>
		<button>Eliminar</button>
	</form>
	<a href='<c:url value="/canciones"/>'>Volver</a>
</body>
</html>