
package com.personal.personale.entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.util.Date;

import com.personal.personale.entitys.Camcion;


@Entity
@Table(name = "PERSONA")
public class Persona implements Serializable {

private static final long serialVersionUID = -2345374833559541839L;

		@Column(name = "NOMBRE", updatable = true, nullable = true, length = 200)
		private String nombre;


		@Id
		@GeneratedValue(generator = "sequence_mat_id_generator")
		@SequenceGenerator(name="sequence_mat_id_generator", initialValue= 25, allocationSize=1000)
		@Column(name = "ID_PERSONA", updatable = true, nullable = false, length = 25)
		private Long id;


		@Column(name = "APELLIDO", updatable = true, nullable = true, length = 200)
		private String apellido;


		@Column(name = "EDAD", updatable = true, nullable = true, length = 200)
		private Integer edad;


		@Column(name = "NACIMIENTO", updatable = true, nullable = true, length = 200)
		private Date nacimiento;


		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = false)

		private   List<Camcion>canciones= new ArrayList<>();

		public String getNombre() { 
			return nombre;
		}
		public void setNombre(String  nombre) {
			this.nombre = nombre;
		}
		public Long getId() { 
			return id;
		}
		public void setId(Long  id) {
			this.id = id;
		}
		public String getApellido() { 
			return apellido;
		}
		public void setApellido(String  apellido) {
			this.apellido = apellido;
		}
		public Integer getEdad() { 
			return edad;
		}
		public void setEdad(Integer  edad) {
			this.edad = edad;
		}
		public Date getNacimiento() { 
			return nacimiento;
		}
		public void setNacimiento(Date  nacimiento) {
			this.nacimiento = nacimiento;
		}
		public List<Camcion> getcanciones() { 
			return canciones;
		}
		public void setcanciones( List<Camcion>  canciones) {
			this.canciones = canciones;
		}
			public boolean equalsPersona(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
					Persona persona = (Persona) o;
						return 			Objects.equals(nombre, persona.nombre) ||
			Objects.equals(id, persona.id) ||
			Objects.equals(apellido, persona.apellido) ||
			Objects.equals(edad, persona.edad) ||
			Objects.equals(nacimiento, persona.nacimiento);

}}
