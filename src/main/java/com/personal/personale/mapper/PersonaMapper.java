

package com.personal.personale.mapper;
import com.personal.personale.entitys.Persona;
import com.personal.personale.pojo.PersonaPojo;
import com.personal.personale.entitys.Camcion;
import com.personal.personale.pojo.CamcionPojo;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

    @Component
    public class PersonaMapper {

      @Autowired
      private CamcionMapper camcionmapper;

        public Persona PojoToEntity(PersonaPojo pojo) {
           Persona entity = new Persona();
        List<Camcion> listcanciones = new ArrayList<Camcion>();
          entity.setNombre(pojo.getNombre());
          entity.setId(pojo.getId());
          entity.setApellido(pojo.getApellido());
          entity.setEdad(pojo.getEdad());
          entity.setNacimiento(pojo.getNacimiento());
        for (CamcionPojo cancionespojo : pojo.getcanciones()) {
            listcanciones.add(camcionmapper.PojoToEntity(cancionespojo));
        }
        entity.setcanciones(listcanciones);
            return entity;
        }


    public PersonaPojo entityToPojo(Persona entity) {
        PersonaPojo pojo = new PersonaPojo();
        List<CamcionPojo> listcanciones = new ArrayList<CamcionPojo>();
        pojo.setNombre(entity.getNombre());
        pojo.setId(entity.getId());
        pojo.setApellido(entity.getApellido());
        pojo.setEdad(entity.getEdad());
        pojo.setNacimiento(entity.getNacimiento());

        for (Camcion cancionesentity : entity.getcanciones()) {
            listcanciones.add(camcionmapper.entityToPojo(cancionesentity ));
        }
        pojo.setcanciones(listcanciones);
            return pojo;
        }

}
