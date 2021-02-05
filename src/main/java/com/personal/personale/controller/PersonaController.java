

package com.personal.personale.controller;
import com.personal.personale.entitys.Persona;
import com.personal.personale.validation.PersonaValidation;
import com.personal.personale.mapper.PersonaMapper;
import com.personal.personale.service.PersonaService;
import com.personal.personale.mapper.MapperEntityRespone;
import com.personal.personale.pojo.EntityRespone;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Date;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.personal.personale.pojo.PersonaPojo;
import com.personal.personale.entitys.Camcion;
import com.personal.personale.validation.CamcionValidation;
import com.personal.personale.mapper.CamcionMapper;
import com.personal.personale.pojo.CamcionPojo;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @Autowired
    PersonaValidation personaValidationService;

    @Autowired
   PersonaMapper personaMapper;

    @Autowired
   MapperEntityRespone mapperEntityRespone;

    @Autowired
    CamcionValidation cancionesValidationService;

    @Autowired
    CamcionMapper cancionesMapper;



        @GetMapping("/Getnombre/{nombre}")
        private  ResponseEntity<EntityRespone> findByNombre(@PathVariable("nombre") String  nombre) {
        String busca = (String) personaValidationService.validation(nombre);
        try {
                EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(personaService.findByNombre(busca));
                return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
             } catch (DataAccessException e) {
                 EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
     }

        @GetMapping("/Getapellido/{apellido}")
        private  ResponseEntity<EntityRespone> findByApellido(@PathVariable("apellido") String  apellido) {
        String busca = (String) personaValidationService.validation(apellido);
        try {
                EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(personaService.findByApellido(busca));
                return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
             } catch (DataAccessException e) {
                 EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
     }

        @GetMapping("/Getedad/{edad}")
        private  ResponseEntity<EntityRespone> findByEdad(@PathVariable("edad") Integer  edad) {
        Integer busca = (Integer) personaValidationService.validation(edad);
        try {
                EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(personaService.findByEdad(busca));
                return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
             } catch (DataAccessException e) {
                 EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
     }

        @GetMapping("/Getnacimiento/{nacimiento}")
        private  ResponseEntity<EntityRespone> findByNacimiento(@PathVariable("nacimiento") Date  nacimiento) {
        Date busca = (Date) personaValidationService.validation(nacimiento);
        try {
                EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(personaService.findByNacimiento(busca));
                return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
             } catch (DataAccessException e) {
                 EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
     }

        @GetMapping("/Getnombrecontain/{nombre}")
        private ResponseEntity<EntityRespone> findByNombreContain(@PathVariable("nombre") String  nombre) {
              String busca = (String) personaValidationService.validation(nombre);
              EntityRespone entityRespone = mapperEntityRespone.setEntityT(personaService.findByNombreContaining(busca));
              return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        }

        @GetMapping("/Getapellidocontain/{apellido}")
        private ResponseEntity<EntityRespone> findByApellidoContain(@PathVariable("apellido") String  apellido) {
              String busca = (String) personaValidationService.validation(apellido);
              EntityRespone entityRespone = mapperEntityRespone.setEntityT(personaService.findByApellidoContaining(busca));
              return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        }

        @GetMapping("/Getedadcontain/{edad}")
        private ResponseEntity<EntityRespone> findByEdadContain(@PathVariable("edad") Integer  edad) {
              Integer busca = (Integer) personaValidationService.validation(edad);
              EntityRespone entityRespone = mapperEntityRespone.setEntityT(personaService.findByEdadContaining(busca));
              return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        }

        @GetMapping("/Getnacimientocontain/{nacimiento}")
        private ResponseEntity<EntityRespone> findByNacimientoContain(@PathVariable("nacimiento") Date  nacimiento) {
              Date busca = (Date) personaValidationService.validation(nacimiento);
              EntityRespone entityRespone = mapperEntityRespone.setEntityT(personaService.findByNacimientoContaining(busca));
              return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        }


        @GetMapping("/GetPersona/{id}")
          private ResponseEntity<EntityRespone> findById(@PathVariable("id") String id) {
          EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(personaService.findById(personaValidationService.valida_id(id))); 
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
          }


        @GetMapping("/GetAllPersona")
        private  ResponseEntity<EntityRespone> getAllPersona(){
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(personaService.getAllPersona());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK); }



        @PostMapping("/save")
        private Boolean  savePersona(@RequestBody PersonaPojo  persona){ 
            return personaService.savePersona(personaMapper.PojoToEntity(personaValidationService.valida(persona)) ); }



        @PostMapping("/Update")
        private Long UpdatePersona(@RequestBody PersonaPojo  persona){ 
        personaService.updatePersona(personaMapper.PojoToEntity(personaValidationService.valida(persona)));
            return persona.getId(); }


        @PostMapping("/saveOrUpdate")
        private boolean saveOrUpdatePersona(@RequestBody PersonaPojo  persona){ 
            return personaService.saveOrUpdatePersona(personaMapper.PojoToEntity(personaValidationService.valida(persona)) ); }


        @DeleteMapping("/deletePersona/{id}")
            private boolean deletePersona(@PathVariable("id") String id) {
            return personaService.deletePersona(personaValidationService.valida_id(id)); }


        @PostMapping("/Get_canciones_contain/")
        private List<Persona> findByCamcion(@RequestBody CamcionPojo  camcion){ 
            return personaService.findByCamcionContaining(cancionesMapper.PojoToEntity(cancionesValidationService.valida(camcion))); }

}
