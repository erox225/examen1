package modelos;

import java.text.DecimalFormat;

public class libro {
	
	public Long id;
	public String nombre;
	public double precio;
	public int descuento;
	private String errorId, errorNombre, errorDescuento, errorPrecio;
	public boolean correcto;
		
	public libro(String nombre, double precio, int descuento) {
		this.setCorrecto(true);
		this.setNombre(nombre);
		this.setPrecio(precio);
		this.setDescuento(descuento);
	}
	
	public libro(String nombre, String precio, String descuento) {
		this.setCorrecto(true);
		this.setNombre(nombre);
		this.setPrecio(precio);
		this.setDescuento(descuento);
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
		if(nombre == null || nombre.trim().length() < 2 || nombre.trim().length() > 150) {
			setErrorNombre("No se admiten nombres de menos de 2 caracteres y m·ximo 150");
		}
		this.nombre = nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	/*SOBRECARGA DE M…TODO*/
	public void setPrecio(String precio) {
		Double precioDouble;
		try {
			if(precio == null || precio.trim().length() < 1) {
				setErrorPrecio("Debes ingresar al menos un n˙mero");
			}else {
				precioDouble = precio.length() == 0 ? null : Double.parseDouble(precio);
				this.setPrecio(redondearDecimales(precioDouble,2));
			}
		} catch (NumberFormatException e) {
			setErrorPrecio("El id debe ser num√©rico");
		}
	}
	/*SOBRECARGA DE M…TODO*/
	
	
	/*Redondear double*/
	 public double redondearDecimales(double valorInicial, int numeroDecimales) {
	        double parteEntera, resultado;
	        resultado = valorInicial;
	        parteEntera = Math.floor(resultado);
	        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
	        resultado=Math.round(resultado);
	        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
	        return resultado;
	    }
	/*Redondear double*/
	
	
	public int getDescuento() {
		return this.descuento;
	}
	
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	/*SOBRECARGA DE M…TODO*/
	public void setDescuento(String descuento) {
		int intDescuento;
		try {
			if(descuento == null || descuento.trim().length() < 1) {
				setErrorDescuento("Debes ingresar al menos un n˙mero");
			}else {
				intDescuento = descuento.length() == 0 ? null : Integer.parseInt(descuento);
					if(intDescuento > 0 && intDescuento < 100){
						this.setDescuento(intDescuento);
					}
					else {
						setErrorDescuento("Debes ingresar un n˙mero mayor que 0 y menor que 100");
					}
			}
		} catch (NumberFormatException e) {
			setErrorOferta("El descuento debe ser numÈrica");
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

	public String getErrorPrecio() {
		return errorPrecio;
	}


	public void setErrorPrecio(String errorPrecio) {
		this.errorPrecio = errorPrecio;
		this.setCorrecto(false);
	}


	public String getErrorDescuento() {
		return errorDescuento;
	}

	public void setErrorDescuento(String errorDescuento) {
		this.errorDescuento = errorDescuento;
		this.setCorrecto(false);
	}

	public void setErrorOferta(String errorDescuento) {
		this.errorDescuento = errorDescuento;
		this.setCorrecto(false);
	}

	@Override
	public String toString() {
		return "libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento
				+ ", errorId=" + errorId + ", errorNombre=" + errorNombre + ", errorDescuento=" + errorDescuento
				+ ", errorPrecio=" + errorPrecio + ", correcto=" + correcto + "]";
	}



}
