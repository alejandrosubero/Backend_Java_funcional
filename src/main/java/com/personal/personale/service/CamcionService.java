
package com.personal.personale.service ;

import java.util.Optional;import java.util.Date;

import java.util.ArrayList;
import java.util.List;
import com.personal.personale.entitys.Camcion;


public interface CamcionService{
 
		public Camcion  findByTitulo(String titulo);

		public Camcion  findByLetra(String letra);

		public Camcion  findByTiempo(Double tiempo);

		public List<Camcion>  findByTituloContaining(String titulo);

		public List<Camcion>  findByLetraContaining(String letra);

		public List<Camcion>  findByTiempoContaining(Double tiempo);

		public Camcion findById(Long id);
		public boolean saveCamcion(Camcion camcion);
		public List<Camcion> getAllCamcion();
		public boolean deleteCamcion(Long id);
		public boolean updateCamcion(Camcion camcion);
 		public boolean saveOrUpdateCamcion(Camcion camcion);

}
