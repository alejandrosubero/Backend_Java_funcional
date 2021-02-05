

package com.personal.personale.mapper;
import com.personal.personale.entitys.Camcion;
import com.personal.personale.pojo.CamcionPojo;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

    @Component
    public class CamcionMapper {

        public Camcion PojoToEntity(CamcionPojo pojo) {
           Camcion entity = new Camcion();
          entity.setId(pojo.getId());
          entity.setTitulo(pojo.getTitulo());
          entity.setLetra(pojo.getLetra());
          entity.setTiempo(pojo.getTiempo());
            return entity;
        }


    public CamcionPojo entityToPojo(Camcion entity) {
        CamcionPojo pojo = new CamcionPojo();
        pojo.setId(entity.getId());
        pojo.setTitulo(entity.getTitulo());
        pojo.setLetra(entity.getLetra());
        pojo.setTiempo(entity.getTiempo());

            return pojo;
        }

}
