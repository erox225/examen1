<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/estilos.css" />

<title>Ejemplos de JSP</title>
</head>
<body class="${cookie.colores.value} container">
	<nav id="menu-principal"
		class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="#">Ejemplos de JSP y servlets</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="bienvenida.jsp">Bienvenida</a></li>
				<li class="nav-item"><a class="nav-link"
					href="preferencias.jsp">Preferencias</a></li>
			</ul>
			<ul class="navbar-nav">
				<c:choose>
					<c:when test="${sessionScope.email != null}">
						<li class="nav-item navbar-text">${email}</li>
						<li class="nav-item"><a class="nav-link" href="desconectar">Desconectar</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>

	<!-- <nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Inicio</a></li>
			<li class="breadcrumb-item"><a href="#">Segundo nivel</a></li>
			<li class="breadcrumb-item active" aria-current="page">Bootstrap</li>
		</ol>
	</nav> -->
	<!-- <div class="alert alert-info alert-dismissible fade show" role="alert">
		Bienvenidos a este ejemplo de Bootstrap
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div> -->

	<main>