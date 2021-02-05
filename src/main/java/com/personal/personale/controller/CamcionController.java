

package com.personal.personale.controller;
import com.personal.personale.entitys.Camcion;
import com.personal.personale.validation.CamcionValidation;
import com.personal.personale.mapper.CamcionMapper;
import com.personal.personale.service.CamcionService;
import com.personal.personale.mapper.MapperEntityRespone;
import com.personal.personale.pojo.EntityRespone;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Date;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.personal.personale.pojo.CamcionPojo;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/camcion")
public class CamcionController {

    @Autowired
    CamcionService camcionService;

    @Autowired
    CamcionValidation camcionValidationService;

    @Autowired
   CamcionMapper camcionMapper;

    @Autowired
   MapperEntityRespone mapperEntityRespone;



        @GetMapping("/Gettitulo/{titulo}")
        private  ResponseEntity<EntityRespone> findByTitulo(@PathVariable("titulo") String  titulo) {
        String busca = (String) camcionValidationService.validation(titulo);
        try {
                EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(camcionService.findByTitulo(busca));
                return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
             } catch (DataAccessException e) {
                 EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
     }

        @GetMapping("/Getletra/{letra}")
        private  ResponseEntity<EntityRespone> findByLetra(@PathVariable("letra") String  letra) {
        String busca = (String) camcionValidationService.validation(letra);
        try {
                EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(camcionService.findByLetra(busca));
                return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
             } catch (DataAccessException e) {
                 EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
     }

        @GetMapping("/Gettiempo/{tiempo}")
        private  ResponseEntity<EntityRespone> findByTiempo(@PathVariable("tiempo") Double  tiempo) {
        Double busca = (Double) camcionValidationService.validation(tiempo);
        try {
                EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(camcionService.findByTiempo(busca));
                return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
             } catch (DataAccessException e) {
                 EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
     }

        @GetMapping("/Gettitulocontain/{titulo}")
        private ResponseEntity<EntityRespone> findByTituloContain(@PathVariable("titulo") String  titulo) {
              String busca = (String) camcionValidationService.validation(titulo);
              EntityRespone entityRespone = mapperEntityRespone.setEntityT(camcionService.findByTituloContaining(busca));
              return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        }

        @GetMapping("/Getletracontain/{letra}")
        private ResponseEntity<EntityRespone> findByLetraContain(@PathVariable("letra") String  letra) {
              String busca = (String) camcionValidationService.validation(letra);
              EntityRespone entityRespone = mapperEntityRespone.setEntityT(camcionService.findByLetraContaining(busca));
              return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        }

        @GetMapping("/Gettiempocontain/{tiempo}")
        private ResponseEntity<EntityRespone> findByTiempoContain(@PathVariable("tiempo") Double  tiempo) {
              Double busca = (Double) camcionValidationService.validation(tiempo);
              EntityRespone entityRespone = mapperEntityRespone.setEntityT(camcionService.findByTiempoContaining(busca));
              return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        }


        @GetMapping("/GetCamcion/{id}")
          private ResponseEntity<EntityRespone> findById(@PathVariable("id") String id) {
          EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(camcionService.findById(camcionValidationService.valida_id(id))); 
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
          }


        @GetMapping("/GetAllCamcion")
        private  ResponseEntity<EntityRespone> getAllCamcion(){
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(camcionService.getAllCamcion());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK); }



        @PostMapping("/save")
        private Boolean  saveCamcion(@RequestBody CamcionPojo  camcion){ 
            return camcionService.saveCamcion(camcionMapper.PojoToEntity(camcionValidationService.valida(camcion)) ); }



        @PostMapping("/Update")
        private Long UpdateCamcion(@RequestBody CamcionPojo  camcion){ 
        camcionService.updateCamcion(camcionMapper.PojoToEntity(camcionValidationService.valida(camcion)));
            return camcion.getId(); }


        @PostMapping("/saveOrUpdate")
        private boolean saveOrUpdateCamcion(@RequestBody CamcionPojo  camcion){ 
            return camcionService.saveOrUpdateCamcion(camcionMapper.PojoToEntity(camcionValidationService.valida(camcion)) ); }


        @DeleteMapping("/deleteCamcion/{id}")
            private boolean deleteCamcion(@PathVariable("id") String id) {
            return camcionService.deleteCamcion(camcionValidationService.valida_id(id)); }

}
