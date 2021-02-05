

package com.personal.personale.serviceImplement ;

import com.personal.personale.service.CamcionService;
import com.personal.personale.repository.CamcionRepository;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.personal.personale.entitys.Camcion;




@Service
public class CamcionServiceImplement implements CamcionService {

protected static final Log logger = LogFactory.getLog(CamcionServiceImplement.class);
@Autowired
private CamcionRepository camcionrepository;

		@Override
		public Camcion findByTitulo(String titulo){

		logger.info("Starting getCamcion");
			Camcion camcionEntity = new Camcion();
		Optional<Camcion> fileOptional1 = camcionrepository.findByTitulo(titulo);

		if (fileOptional1.isPresent()) { 

				try {
			camcionEntity = fileOptional1.get();
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);

				}
		}
		return camcionEntity;	}
		@Override
		public Camcion findByLetra(String letra){

		logger.info("Starting getCamcion");
			Camcion camcionEntity = new Camcion();
		Optional<Camcion> fileOptional1 = camcionrepository.findByLetra(letra);

		if (fileOptional1.isPresent()) { 

				try {
			camcionEntity = fileOptional1.get();
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);

				}
		}
		return camcionEntity;	}
		@Override
		public Camcion findByTiempo(Double tiempo){

		logger.info("Starting getCamcion");
			Camcion camcionEntity = new Camcion();
		Optional<Camcion> fileOptional1 = camcionrepository.findByTiempo(tiempo);

		if (fileOptional1.isPresent()) { 

				try {
			camcionEntity = fileOptional1.get();
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);

				}
		}
		return camcionEntity;	}




		@Override
		public List<Camcion> getAllCamcion(){
		logger.info("Get allProyect");
			List<Camcion> listaCamcion = new ArrayList<Camcion>();
				camcionrepository.findAll().forEach(camcion -> listaCamcion.add(camcion));
			return listaCamcion;
}


		@Override
		public boolean saveCamcion(Camcion camcion){
		logger.info("Save Proyect");


				try {
				camcionrepository.save(camcion);
				return true;
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);
				return false;
				}
		}


		@Override
		public boolean deleteCamcion( Long id){
		logger.info("Delete Proyect");
		boolean clave = false;


				try {
				camcionrepository.deleteById(id);
				clave = true;
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);
				clave = false;
				}
		return clave;
	}



		@Override
		public boolean updateCamcion(Camcion  camcion ){
			logger.info("Update Proyect");
			boolean clave = false;
		Camcion empre = findById(camcion.getId());
			empre = camcion;

				try {
				camcionrepository.save(empre);
						clave = true;
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);
				clave = false;
				}

					return clave;
	}



		@Override
		public Camcion findById( Long id){
				return  camcionrepository.findById(id).get();
		}



		@Override
		public boolean saveOrUpdateCamcion(Camcion  camcion ){
			logger.info("Update Proyect");
			boolean clave = false;
			logger.info("Starting getEmpresa");
			Optional<Camcion> fileOptional2 = camcionrepository.findById(camcion.getId());
			if (fileOptional2.isPresent()) { 
				clave = this.updateCamcion(camcion);
				logger.info(" is update");
			} else {
					clave = this.saveCamcion(camcion);
					logger.info(" is save");
 				}
 		return clave;
		}


		@Override
		public List<Camcion> findByTituloContaining(String titulo){
			logger.info("Get allProyect");
 			List<Camcion> listaCamcion = new ArrayList<Camcion>();
			listaCamcion = camcionrepository.findByTituloContaining(titulo);
  			return listaCamcion;
		}

		@Override
		public List<Camcion> findByLetraContaining(String letra){
			logger.info("Get allProyect");
 			List<Camcion> listaCamcion = new ArrayList<Camcion>();
			listaCamcion = camcionrepository.findByLetraContaining(letra);
  			return listaCamcion;
		}

		@Override
		public List<Camcion> findByTiempoContaining(Double tiempo){
			logger.info("Get allProyect");
 			List<Camcion> listaCamcion = new ArrayList<Camcion>();
			listaCamcion = camcionrepository.findByTiempoContaining(tiempo);
  			return listaCamcion;
		}



}
