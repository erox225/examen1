<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp" %>

<h1>Bienvenido ${email} <%=session.getAttribute("email")%></h1>

<%@ include file="includes/pie.jsp" %>