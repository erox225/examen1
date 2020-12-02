<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp" %>

	<form action="login" method="post" class="form-inline">
		<input class="form-control" type="email" name="email" placeholder="Email" value="${email}" />
		<input class="form-control" type="password" name="password" placeholder="Contraseña" />
		<button class="btn btn-primary">Login</button>
		
		<div class="error">${error}</div>
	</form>

<%@ include file="includes/pie.jsp" %>