
package com.personal.personale.service ;

import java.util.Optional;import java.util.Date;

import java.util.ArrayList;
import java.util.List;
import com.personal.personale.entitys.Persona;import com.personal.personale.entitys.Camcion;



public interface PersonaService{
 
		public Persona  findByNombre(String nombre);

		public Persona  findByApellido(String apellido);

		public Persona  findByEdad(Integer edad);

		public Persona  findByNacimiento(Date nacimiento);

		public List<Persona>  findByNombreContaining(String nombre);

		public List<Persona>  findByApellidoContaining(String apellido);

		public List<Persona>  findByEdadContaining(Integer edad);

		public List<Persona>  findByNacimientoContaining(Date nacimiento);

		public Persona findById(Long id);
		public boolean savePersona(Persona persona);
		public List<Persona> getAllPersona();
		public boolean deletePersona(Long id);
		public boolean updatePersona(Persona persona);
 		public boolean saveOrUpdatePersona(Persona persona);

		public List<Persona>  findByCamcionContaining(Camcion canciones);
}
