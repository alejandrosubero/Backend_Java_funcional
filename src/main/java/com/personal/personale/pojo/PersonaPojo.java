
package com.personal.personale.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.util.Date;

import com.personal.personale.pojo.CamcionPojo;


public class PersonaPojo implements Serializable {

private static final long serialVersionUID = 2526125263277958976L;

		private String nombre;

		private Long id;

		private String apellido;

		private Integer edad;

		private Date nacimiento;

		private   List<CamcionPojo>canciones= new ArrayList<>();


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
		public List<CamcionPojo> getcanciones() { 
			return canciones;
		}
		public void setcanciones( List<CamcionPojo>  canciones) {
			this.canciones = canciones;
		}
			public boolean equalsPersonaPojo(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
					PersonaPojo personapojo = (PersonaPojo) o;
						return 			Objects.equals(nombre, personapojo.nombre) ||
			Objects.equals(id, personapojo.id) ||
			Objects.equals(apellido, personapojo.apellido) ||
			Objects.equals(edad, personapojo.edad) ||
			Objects.equals(nacimiento, personapojo.nacimiento);

}}
