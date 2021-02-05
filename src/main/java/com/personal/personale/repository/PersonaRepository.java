
package com.personal.personale.repository;

import java.util.List;import java.util.Date;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.personal.personale.entitys.Persona;

public interface PersonaRepository extends CrudRepository< Persona, Long> {
 
		public Optional<Persona> findByNombre(String nombre);
		public List<Persona> findByNombreContaining(String nombre);
		public Optional<Persona> findByApellido(String apellido);
		public List<Persona> findByApellidoContaining(String apellido);
		public Optional<Persona> findByEdad(Integer edad);
		public List<Persona> findByEdadContaining(Integer edad);
		public Optional<Persona> findByNacimiento(Date nacimiento);
		public List<Persona> findByNacimientoContaining(Date nacimiento);

}
