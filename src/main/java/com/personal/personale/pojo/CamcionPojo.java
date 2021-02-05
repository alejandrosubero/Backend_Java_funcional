
package com.personal.personale.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.util.Date;



public class CamcionPojo implements Serializable {

private static final long serialVersionUID = 4369998243779953188L;

		private Long id;

		private String titulo;

		private String letra;

		private Double tiempo;

		public Long getId() { 
			return id;
		}
		public void setId(Long  id) {
			this.id = id;
		}
		public String getTitulo() { 
			return titulo;
		}
		public void setTitulo(String  titulo) {
			this.titulo = titulo;
		}
		public String getLetra() { 
			return letra;
		}
		public void setLetra(String  letra) {
			this.letra = letra;
		}
		public Double getTiempo() { 
			return tiempo;
		}
		public void setTiempo(Double  tiempo) {
			this.tiempo = tiempo;
		}
			public boolean equalsCamcionPojo(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
					CamcionPojo camcionpojo = (CamcionPojo) o;
						return 			Objects.equals(id, camcionpojo.id) ||
			Objects.equals(titulo, camcionpojo.titulo) ||
			Objects.equals(letra, camcionpojo.letra) ||
			Objects.equals(tiempo, camcionpojo.tiempo);

}}
