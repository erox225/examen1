<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<h1 class="col-12">Edición de película</h1>

	<div class="col-12">
		<form action="admin/guardar" method="post">
			<input type="hidden" name="id" value="${pelicula.id}" />
			
			<%-- <div class="form-group row">
				<label for="id" class="col-sm-2 col-form-label">Id</label>
				<div class="col-sm-10">
					<input type="number" class="form-control ${pelicula.errorId != null ? 'is-invalid' : '' }" id="id" name="id"
						value="${pelicula.id}" readonly>
					<div class="invalid-feedback">${pelicula.errorId}</div>
				</div>
			</div> --%>
			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Título</label>
				<div class="col-sm-10">
					<input type="text"
						class="form-control ${pelicula.errorTitulo != null ? 'is-invalid' : '' }"
						id="titulo" name="titulo" placeholder="El título de la película"
						value="${pelicula.titulo}">
					<div class="invalid-feedback">${pelicula.errorTitulo}</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="genero" class="col-sm-2 col-form-label">Género</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="genero" name="genero"
						value="${pelicula.genero}">
				</div>
			</div>

			<div class="form-group row">
				<label for="fecha-estreno" class="col-sm-2 col-form-label">Fecha
					de estreno</label>
				<div class="col-sm-10">
					<input type="date"
						class="form-control ${pelicula.errorFechaEstreno != null ? 'is-invalid' : '' }"
						id="fecha-estreno" name="fecha-estreno"
						value="${pelicula.fechaEstreno}">
					<div class="invalid-feedback">${pelicula.errorFechaEstreno}</div>
				</div>
			</div>

			<div class="form-group row">
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary">Aceptar</button>
					<a class="btn btn-danger" href="admin/listado">Cancelar</a>
				</div>
			</div>
		</form>

	</div>


</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
