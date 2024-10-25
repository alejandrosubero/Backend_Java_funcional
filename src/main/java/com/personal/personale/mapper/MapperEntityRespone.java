package com.personal.personale.mapper;
import com.personal.personale.pojo.EntityRespone;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperEntityRespone {

public <T> EntityRespone setEntityT(List<T> t) {
        EntityRespone entityRespone = new EntityRespone();
        List<Object> list = (List<Object>) t;
        entityRespone.setEntidades(list);
        return entityRespone;
    }
public <T> EntityRespone setEntityTobj(T t ) {
        EntityRespone entityRespone = new EntityRespone();
        List<Object> ob = new ArrayList<>();
        Object objects = t;
       ob.add(objects);
       entityRespone.setEntidades(ob);
        return entityRespone;
    }
 public <T> EntityRespone setEntityResponT(T t , String mensaje, String error) {
        EntityRespone entityRespone = new EntityRespone();
        List<Object> ob = new ArrayList<>();
        Object objects = t;
        ob.add(objects);
        entityRespone.setError(error);
        entityRespone.setMensaje(mensaje);
        entityRespone.setEntidades(ob);
        return entityRespone;
    }

  public <T> EntityRespone setEntityResponseT(List<T> t, String mensaje, String error) {
        EntityRespone entityRespone = new EntityRespone();
        List<Object> objects = (List<Object>) t;
        entityRespone.setError(error);
        entityRespone.setMensaje(mensaje);
        entityRespone.setEntidades(objects);
        return entityRespone;
    }
}
