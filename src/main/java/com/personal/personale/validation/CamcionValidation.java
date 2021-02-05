package com.personal.personale.validation ;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;import java.util.Date;

import com.personal.personale.entitys.Camcion;import java.util.regex.Pattern;
import org.springframework.stereotype.Service;
import com.personal.personale.pojo.CamcionPojo;


    @Service
    public class CamcionValidation {

        public CamcionPojo valida(CamcionPojo camcion) {
        CamcionPojo pojo = null;
        try {
             if (camcion != null) {
              if (
        camcion.getId() != null &&
        camcion.getTitulo() != null &&
        camcion.getLetra() != null &&
        camcion.getTiempo() != null        ) {
        pojo = camcion;
         }
        }
            return pojo;
        } catch (Exception e) {
            e.printStackTrace();
            return pojo;
        }
    }
// remplace de name of variable for you proyecte
    public Long valida_id( String poder) {
             Long id_Delete = 0l;        try {
          if (poder != null) {
          if (poder.length() > 0 && !Pattern.matches("[a-zA-Z]+", poder)) {
         id_Delete = Long.parseLong(poder);            }
        }
            return id_Delete;
        } catch (Exception e) {
            e.printStackTrace();
            return id_Delete;
        }
    }
    public <T> Object validation(T t) {
         T elemento = null;
        try {
        if (t != null) {
            elemento = t;
        }
            return elemento;
        } catch (Exception e) {
            e.printStackTrace();
            return elemento;
        }
    }
}
