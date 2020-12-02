<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp" %>

	<h1>Preferencias</h1>
	
	<form action="preferencias" method="post" class="form-inline">
		<select name="colores" class="custom-select">
			<option value="light">Claros</option>
			<option value="gray">Grises</option>
			<option value="dark">Oscuros</option>
		</select>
		
		<button class="btn btn-primary">Establecer colores por defecto</button>
	</form>
	
	<ul class="nav">
		<li><a class="btn btn-secondary" href="preferencias?colores=light">Claros</a></li>
		<li><a class="btn btn-secondary" href="preferencias?colores=gray">Grises</a></li>
		<li><a class="btn btn-secondary" href="preferencias?colores=dark">Oscuros</a></li>
	</ul>

<%@ include file="includes/pie.jsp" %>
