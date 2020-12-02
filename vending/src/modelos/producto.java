package modelos;

public class producto {
	public String nombre, tipo, descripcion, img ;
	public int cantidad;
	public double precio_base, oferta, precio_oferta;
	public Long id;
	public boolean correcto;
	private String errorId, errorNombre, errorCantidad, errorDescripcion, errorImg,errorPrecio,errorOferta,errorTipo;
	
	
	
	
	public producto(String nombre, String tipo, String descripcion, String img, int cantidad, double precio,double oferta, Long id) {
		this.setCorrecto(true);
		this.setNombre(nombre);
		this.setTipo(tipo);
		this.setDescripcion(descripcion);
		this.setImg(img);
		this.setCantidad(cantidad);
		this.setPrecio_base(precio);
		this.setOferta(oferta);
		this.setId(id);
	}
	
	public producto(String nombre, String tipo, String descripcion, String img, String cantidad, String precio,String oferta) {
		this.setCorrecto(true);
		this.setNombre(nombre);
		this.setTipo(tipo);
		this.setDescripcion(descripcion);
		this.setImg(img);
		this.setCantidad(cantidad);
		this.setPrecio_base(precio);
		this.setOferta(oferta);
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	/*SOBRECARGA DE M…TODO*/
	public void setId(String id) {
		Long peliculaId;
		try {
			peliculaId = id.length() == 0 ? null : Long.parseLong(id);
			setId(peliculaId);
		} catch (NumberFormatException e) {
			setErrorId("El id debe ser num√©rico");
		}
	}
	/*SOBRECARGA DE M…TODO*/

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().length() < 3) {
			setErrorNombre("No se admiten tÌtulos de menos de 3 caracteres");
		}
		this.nombre = nombre;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		if(tipo == null || tipo.trim().length() < 3) {
			setErrorTipo("No se admiten t√≠tulos de menos de 3 caracteres");
		}
		this.tipo = tipo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		if(descripcion == null || descripcion.trim().length() < 3) {
			setErrorDescripcion("No se admiten t√≠tulos de menos de 3 caracteres");
		}
		this.descripcion = descripcion;
	}
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		if(img == null || img.trim().length() < 3) {
			setErrorImg("No se admiten t√≠tulos de menos de 3 caracteres");
		}
		this.img = img;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	/*SOBRECARGA DE M…TODO*/
	public void setCantidad(String cantidad) {
		int intCantidad;
		try {
			intCantidad = cantidad.length() == 0 ? null : Integer.parseInt(cantidad);
			setCantidad(intCantidad);
		} catch (NumberFormatException e) {
			setErrorCantidad("El id debe ser num√©rico");
		}
	}
	/*SOBRECARGA DE M…TODO*/
	
	public double getPrecio_base() {
		return precio_base;
	}
	
	public void setPrecio_base(double precio) {
		this.precio_base = precio;
	}
	
	/*SOBRECARGA DE M…TODO*/
	public void setPrecio_base(String precio) {
		Double precioDouble;
		try {
			precioDouble = precio.length() == 0 ? null : Double.parseDouble(precio);
			this.setPrecio_base(precioDouble);
		} catch (NumberFormatException e) {
			setErrorPrecio("El id debe ser num√©rico");
		}
	}
	/*SOBRECARGA DE M…TODO*/
	
	public double getOferta() {
		return oferta;
	}
	
	public void setOferta(double oferta) {
		this.oferta = oferta;
	}
	
	/*SOBRECARGA DE M…TODO*/
	public void setOferta(String oferta) {
		Double OfertaDouble;
		try {
			OfertaDouble = oferta.length() == 0 ? null : Double.parseDouble(oferta);
			this.setOferta(OfertaDouble);
		} catch (NumberFormatException e) {
			setErrorOferta("La oferta debe ser numÈrica");
		}
		
	}
	/*SOBRECARGA DE M…TODO*/
	
	public boolean isCorrecto() {
		return correcto;
	}


	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}


	public String getErrorId() {
		return errorId;
	}


	public void setErrorId(String errorId) {
		this.errorId = errorId;
		this.setCorrecto(false);
	}


	public String getErrorNombre() {
		return errorNombre;
	}


	public void setErrorNombre(String errorNombre) {
		this.errorNombre = errorNombre;
		this.setCorrecto(false);
	}


	public String getErrorCantidad() {
		return errorCantidad;
	}


	public void setErrorCantidad(String errorCantidad) {
		this.errorCantidad = errorCantidad;
		this.setCorrecto(false);
	}


	public String getErrorDescripcion() {
		return errorDescripcion;
	}


	public void setErrorDescripcion(String errorDescripcion) {
		this.errorDescripcion = errorDescripcion;
		this.setCorrecto(false);
	}


	public String getErrorImg() {
		return errorImg;
	}


	public void setErrorImg(String errorImg) {
		this.errorImg = errorImg;
		this.setCorrecto(false);
	}


	public String getErrorPrecio() {
		return errorPrecio;
	}


	public void setErrorPrecio(String errorPrecio) {
		this.errorPrecio = errorPrecio;
		this.setCorrecto(false);
	}


	public String getErrorOferta() {
		return errorOferta;
	}


	public void setErrorOferta(String errorOferta) {
		this.errorOferta = errorOferta;
		this.setCorrecto(false);
	}


	public String getErrorTipo() {
		return errorTipo;
	}


	public void setErrorTipo(String errorTipo) {
		this.errorTipo = errorTipo;
		this.setCorrecto(false);
	}



	public double getPrecio_oferta() {
		double precio = this.getPrecio_base();
		precio=(precio*this.oferta)/100;
		return precio_base-precio;
	}


	public void setPrecio_oferta(double precio_oferta) {
		this.precio_oferta = precio_oferta;
	}

	@Override
	public String toString() {
		return "producto [nombre=" + nombre + ", tipo=" + tipo + ", descripcion=" + descripcion + ", img=" + img
				+ ", cantidad=" + cantidad + ", precio_base=" + precio_base + ", oferta=" + oferta + ", precio_oferta="
				+ precio_oferta + ", id=" + id + ", correcto=" + correcto + ", errorId=" + errorId + ", errorNombre="
				+ errorNombre + ", errorCantidad=" + errorCantidad + ", errorDescripcion=" + errorDescripcion
				+ ", errorImg=" + errorImg + ", errorPrecio=" + errorPrecio + ", errorOferta=" + errorOferta
				+ ", errorTipo=" + errorTipo + "]";
	}

	
	
	

}
