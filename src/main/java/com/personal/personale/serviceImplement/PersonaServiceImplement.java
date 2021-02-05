

package com.personal.personale.serviceImplement ;

import com.personal.personale.service.PersonaService;
import com.personal.personale.repository.PersonaRepository;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.personal.personale.entitys.Persona;
import com.personal.personale.entitys.Camcion;




@Service
public class PersonaServiceImplement implements PersonaService {

protected static final Log logger = LogFactory.getLog(PersonaServiceImplement.class);
@Autowired
private PersonaRepository personarepository;

		@Override
		public Persona findByNombre(String nombre){

		logger.info("Starting getPersona");
			Persona personaEntity = new Persona();
		Optional<Persona> fileOptional1 = personarepository.findByNombre(nombre);

		if (fileOptional1.isPresent()) { 

				try {
			personaEntity = fileOptional1.get();
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);

				}
		}
		return personaEntity;	}
		@Override
		public Persona findByApellido(String apellido){

		logger.info("Starting getPersona");
			Persona personaEntity = new Persona();
		Optional<Persona> fileOptional1 = personarepository.findByApellido(apellido);

		if (fileOptional1.isPresent()) { 

				try {
			personaEntity = fileOptional1.get();
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);

				}
		}
		return personaEntity;	}
		@Override
		public Persona findByEdad(Integer edad){

		logger.info("Starting getPersona");
			Persona personaEntity = new Persona();
		Optional<Persona> fileOptional1 = personarepository.findByEdad(edad);

		if (fileOptional1.isPresent()) { 

				try {
			personaEntity = fileOptional1.get();
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);

				}
		}
		return personaEntity;	}
		@Override
		public Persona findByNacimiento(Date nacimiento){

		logger.info("Starting getPersona");
			Persona personaEntity = new Persona();
		Optional<Persona> fileOptional1 = personarepository.findByNacimiento(nacimiento);

		if (fileOptional1.isPresent()) { 

				try {
			personaEntity = fileOptional1.get();
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);

				}
		}
		return personaEntity;	}




		@Override
		public List<Persona> getAllPersona(){
		logger.info("Get allProyect");
			List<Persona> listaPersona = new ArrayList<Persona>();
				personarepository.findAll().forEach(persona -> listaPersona.add(persona));
			return listaPersona;
}


		@Override
		public boolean savePersona(Persona persona){
		logger.info("Save Proyect");


				try {
				personarepository.save(persona);
				return true;
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);
				return false;
				}
		}


		@Override
		public boolean deletePersona( Long id){
		logger.info("Delete Proyect");
		boolean clave = false;


				try {
				personarepository.deleteById(id);
				clave = true;
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);
				clave = false;
				}
		return clave;
	}



		@Override
		public boolean updatePersona(Persona  persona ){
			logger.info("Update Proyect");
			boolean clave = false;
		Persona empre = findById(persona.getId());
			empre = persona;

				try {
				personarepository.save(empre);
						clave = true;
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);
				clave = false;
				}

					return clave;
	}



		@Override
		public Persona findById( Long id){
				return  personarepository.findById(id).get();
		}



		@Override
		public boolean saveOrUpdatePersona(Persona  persona ){
			logger.info("Update Proyect");
			boolean clave = false;
			logger.info("Starting getEmpresa");
			Optional<Persona> fileOptional2 = personarepository.findById(persona.getId());
			if (fileOptional2.isPresent()) { 
				clave = this.updatePersona(persona);
				logger.info(" is update");
			} else {
					clave = this.savePersona(persona);
					logger.info(" is save");
 				}
 		return clave;
		}


		@Override
		public List<Persona> findByNombreContaining(String nombre){
			logger.info("Get allProyect");
 			List<Persona> listaPersona = new ArrayList<Persona>();
			listaPersona = personarepository.findByNombreContaining(nombre);
  			return listaPersona;
		}

		@Override
		public List<Persona> findByApellidoContaining(String apellido){
			logger.info("Get allProyect");
 			List<Persona> listaPersona = new ArrayList<Persona>();
			listaPersona = personarepository.findByApellidoContaining(apellido);
  			return listaPersona;
		}

		@Override
		public List<Persona> findByEdadContaining(Integer edad){
			logger.info("Get allProyect");
 			List<Persona> listaPersona = new ArrayList<Persona>();
			listaPersona = personarepository.findByEdadContaining(edad);
  			return listaPersona;
		}

		@Override
		public List<Persona> findByNacimientoContaining(Date nacimiento){
			logger.info("Get allProyect");
 			List<Persona> listaPersona = new ArrayList<Persona>();
			listaPersona = personarepository.findByNacimientoContaining(nacimiento);
  			return listaPersona;
		}


		
		@Override
		public List<Persona> findByCamcionContaining(Camcion canciones){
			logger.info("metodo: metodContainingRelacion NEW ");
			logger.info("Get allProyect");
 			List<Persona> listaPersona = new ArrayList<Persona>();
			for (Persona persona : this.getAllPersona()) {
				for (Camcion cancionesx : persona.getcanciones()) { 
						if(cancionesx.equalsCamcion(canciones)) {
						listaPersona.add(persona);	
				}
	  	 	}
		}
			return listaPersona;	

	}

}
