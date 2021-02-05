package com.personal.personale.validation ;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;import java.util.Date;

import com.personal.personale.entitys.Persona;import java.util.regex.Pattern;
import org.springframework.stereotype.Service;
import com.personal.personale.pojo.PersonaPojo;import com.personal.personale.entitys.Camcion;
import com.personal.personale.pojo.CamcionPojo;



    @Service
    public class PersonaValidation {

        public PersonaPojo valida(PersonaPojo persona) {
        PersonaPojo pojo = null;
        try {
             if (persona != null) {
              if (
        persona.getNombre() != null &&
        persona.getId() != null &&
        persona.getApellido() != null &&
        persona.getEdad() != null &&
        persona.getNacimiento() != null        ) {
        pojo = persona;
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
