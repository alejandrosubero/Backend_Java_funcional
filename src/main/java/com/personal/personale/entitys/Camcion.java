
package com.personal.personale.entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.util.Date;



@Entity
@Table(name = "CAMCION")
public class Camcion implements Serializable {

private static final long serialVersionUID = -2234032604302538071L;

		@Id
		@GeneratedValue(generator = "sequence_mat_id_generator")
		@SequenceGenerator(name="sequence_mat_id_generator", initialValue= 25, allocationSize=1000)
		@Column(name = "ID", updatable = true, nullable = false, length = 25)
		private Long id;


		@Column(name = "TITULO", updatable = true, nullable = true, length = 200)
		private String titulo;


		@Column(name = "LETRA", updatable = true, nullable = true, length = 200)
		private String letra;


		@Column(name = "TIEMPO", updatable = true, nullable = true, length = 200)
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
			public boolean equalsCamcion(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
					Camcion camcion = (Camcion) o;
						return 			Objects.equals(id, camcion.id) ||
			Objects.equals(titulo, camcion.titulo) ||
			Objects.equals(letra, camcion.letra) ||
			Objects.equals(tiempo, camcion.tiempo);

}}
