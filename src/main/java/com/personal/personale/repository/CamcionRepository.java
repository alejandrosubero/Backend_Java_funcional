
package com.personal.personale.repository;

import java.util.List;import java.util.Date;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.personal.personale.entitys.Camcion;

public interface CamcionRepository extends CrudRepository< Camcion, Long> {
 
		public Optional<Camcion> findByTitulo(String titulo);
		public List<Camcion> findByTituloContaining(String titulo);
		public Optional<Camcion> findByLetra(String letra);
		public List<Camcion> findByLetraContaining(String letra);
		public Optional<Camcion> findByTiempo(Double tiempo);
		public List<Camcion> findByTiempoContaining(Double tiempo);

}
