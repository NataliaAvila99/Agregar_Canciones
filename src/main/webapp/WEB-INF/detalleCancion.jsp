<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalles de la Cancion</title>
</head>
<body>
<h1>Detalles de la Cancion</h1>

<ul>
<li>Titulo: ${cancion.titulo}</li>
<li>Artista: ${cancion.artista}</li>
<li>Album: ${cancion.album}</li>
<li>Genero: ${cancion.genero}</li>
<li>Idioma: ${cancion.idioma}</li>
<li>Fecha de Creación: ${cancion.fechaCreacion}</li>
  <li>Fecha de Actualización: ${cancion.fechaActualizacion}</li>
</ul>

<a href="/canciones">Volver a la lista de canciones</a>

</body>
</html>