package examen.entidades;
	
public class Libro {
	private Long id;
	private String titulo;
	private Long isbn;
	private Integer n_paginas;
	private Boolean formato;
		
		public Libro(Long id)
		{
			this.setId(id);
		}
		

		public Libro(Long id, String titulo, Long isbn, int n_paginas, boolean formato) {
			this.setId(id);
			this.setTitulo(titulo); 
			this.setIsbn(isbn);
			this.setN_paginas(n_paginas);
			this.setFormato(formato);
		}
		
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			if(id == null || id <= 0) {
				throw new EntidadesException("No se admiten ids menores o iguales a 0");
			}
			this.id = id;
		}
		
		public String getTitulo() {
			return titulo;
		}
		
		
		public void setTitulo(String titulo) {
			if(titulo == null || titulo.trim().length() == 0) {
				throw new EntidadesException("El titulo no puede estar vacio");
			}
			else if(titulo.trim().length()< 3)
			{
				throw new EntidadesException("El titulo debe contener minimo 3 letras");
			}
			else if(titulo.trim().length() > 150)
			{
				throw new EntidadesException("El titulo puede contener maximo 150 letras");
			}
			this.titulo = titulo;
		}
		
		
		public Long getIsbn() {
			return isbn;
		}
		
		
		public void setIsbn(Long isbn) {
			Long aux = isbn;
			int digitos = 0;
			while(aux !=0)
			 {
				aux = aux/10;
			   digitos++;
			 }
			if(digitos!=10)
			{
				throw new EntidadesException("No se admite un número de ISBN menor a 10");
			}
			this.isbn = isbn;
		}
		
		
		public Integer getN_paginas() {
			return n_paginas;
		}
		
		public void setN_paginas(Integer n_paginas) {
			if(n_paginas <= 0) {
				throw new EntidadesException("No se admite un número de página menor o igual a 0");
			}
			this.n_paginas = n_paginas;
		}
		
		public Boolean isFormato() {
			return formato;
		}
		
		
		public void setFormato(Boolean formato) {
			this.formato = formato;
		}

		@Override
		public String toString() {
			String format =(formato)?"digital":"papel";
			return "#" + id + ", titulo= " + titulo + ", isbn= " + isbn + ", n_paginas= " + n_paginas
					+ ", formato= " + format;
		}
}
