package com.appslip.Tutor.api;

import com.appslip.Tutor.domain.model.Tutor;
import com.appslip.Tutor.domain.model.ITutorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tutors")
@Api(tags = "Tutor", value = "Servicio Web RESTFul de Tutors")
public class TutorController {

    @Autowired
    private ITutorService tutorService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Listar Tutors", notes = "Método para listar todos los tutors")
    @ApiResponses({
            @ApiResponse(code=201, message = "Tutors encontrados"),
            @ApiResponse(code=404, message = "Tutors no encontrados")
    })
    public ResponseEntity<List<Tutor>> findAll(){
        try{
            List<Tutor> tutors = tutorService.getAll();
            if(tutors.size()>0)
                return new ResponseEntity<List<Tutor>>(tutors, HttpStatus.OK);
            else
                return new ResponseEntity<List<Tutor>>(HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            return new ResponseEntity<List<Tutor>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Tutor por Id", notes = "Método para encontrar un tutor por su respectivo Id")
    @ApiResponses({
            @ApiResponse(code=201, message = "Tutor encontrado"),
            @ApiResponse(code=404, message = "Tutor no encontrado")
    })
    public ResponseEntity<Tutor> findById(@PathVariable("id") Long id){
        try{
            Optional<Tutor> tutor = tutorService.getById(id);
            if(!tutor.isPresent())
            return new ResponseEntity<Tutor>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<Tutor>(tutor.get(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Tutor>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchByLastName/{lastname}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Tutors por lastname", notes = "Método para encontrar tutors por su respectivo lastname")
    @ApiResponses({
            @ApiResponse(code=201, message = "Tutors encontrados"),
            @ApiResponse(code=404, message = "Tutors no encontrados")
    })
    public ResponseEntity<List<Tutor>> findByLastName(@PathVariable("lastname") String lastname){
        try{
            List<Tutor> tutors = tutorService.findByLastName(lastname);
            if(tutors.size()>0)
                return new ResponseEntity<List<Tutor>>(tutors, HttpStatus.OK);
            else
                return new ResponseEntity<List<Tutor>>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<List<Tutor>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchByFirstName/{firstname}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Tutors por firstname", notes = "Método para encontrar tutors por su respectivo firstname")
    @ApiResponses({
            @ApiResponse(code=201, message = "Tutors encontrados"),
            @ApiResponse(code=404, message = "Tutors no encontrados")
    })
    public ResponseEntity<List<Tutor>> findByFirstName(@PathVariable("firstname") String firstname){
        try{
            List<Tutor> tutors = tutorService.findByFirstName(firstname);
            if(tutors.size()>0)
                return new ResponseEntity<List<Tutor>>(tutors, HttpStatus.OK);
            else
                return new ResponseEntity<List<Tutor>>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<List<Tutor>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchByEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Tutors por email", notes = "Método para encontrar tutors por su respectivo email")
    @ApiResponses({
            @ApiResponse(code=201, message = "Tutors encontrados"),
            @ApiResponse(code=404, message = "Tutors no encontrados")
    })
    public ResponseEntity<List<Tutor>> findByEmail(@PathVariable("email") String email){
        try{
            List<Tutor> tutors = tutorService.findByEmail(email);
            if(tutors.size()>0)
                return new ResponseEntity<List<Tutor>>(tutors, HttpStatus.OK);
            else
                return new ResponseEntity<List<Tutor>>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<List<Tutor>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchByPhone/{phone}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Tutors por phone", notes = "Método para encontrar tutors por su respectivo phone")
    @ApiResponses({
            @ApiResponse(code=201, message = "Tutors encontrados"),
            @ApiResponse(code=404, message = "Tutors no encontrados")
    })
    public ResponseEntity<List<Tutor>> findByPhone(@PathVariable("phone") String phone){
        try{
            List<Tutor> tutors = tutorService.findByPhone(phone);
            if(tutors.size()>0)
                return new ResponseEntity<List<Tutor>>(tutors, HttpStatus.OK);
            else
                return new ResponseEntity<List<Tutor>>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<List<Tutor>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchBySpecialty/{specialty}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Tutors por specialty", notes = "Método para encontrar tutors por su respectivo specialty")
    @ApiResponses({
            @ApiResponse(code=201, message = "Tutors encontrados"),
            @ApiResponse(code=404, message = "Tutors no encontrados")
    })
    public ResponseEntity<List<Tutor>> findBySpecialty(@PathVariable("specialty") String specialty){
        try{
            List<Tutor> tutors = tutorService.findBySpecialty(specialty);
            if(tutors.size()>0)
                return new ResponseEntity<List<Tutor>>(tutors, HttpStatus.OK);
            else
                return new ResponseEntity<List<Tutor>>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<List<Tutor>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchByLastNameAndFirstName/{lastname}/{firstname}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Tutors por lastname y firstname", notes = "Método para encontrar tutors por su respectivos lastname y firstname")
    @ApiResponses({
            @ApiResponse(code=201, message = "Tutors encontrados"),
            @ApiResponse(code=404, message = "Tutors no encontrados")
    })
    public ResponseEntity<List<Tutor>> findByLastNameAndFirstName(@PathVariable("lastname") String lastname, @PathVariable("firstname") String firstname){
        try{
            List<Tutor> tutors = tutorService.findByLastNameAndFirstName(lastname, firstname);
            if(tutors.size()>0)
                return new ResponseEntity<List<Tutor>>(tutors, HttpStatus.OK);
            else
                return new ResponseEntity<List<Tutor>>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<List<Tutor>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchByFirstNameAndLastName/{firstname/{lastname}}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Tutors por firstname y lastname", notes = "Método para encontrar tutors por su respectivos firstname y lastname")
    @ApiResponses({
            @ApiResponse(code=201, message = "Tutors encontrados"),
            @ApiResponse(code=404, message = "Tutors no encontrados")
    })
    public ResponseEntity<List<Tutor>> findByFirstNameAndLastName(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname){
        try{
            List<Tutor> tutors = tutorService.findByFirstNameAndLastName(firstname, lastname);
            if(tutors.size()>0)
                return new ResponseEntity<List<Tutor>>(tutors, HttpStatus.OK);
            else
                return new ResponseEntity<List<Tutor>>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<List<Tutor>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Registro de Tutors", notes = "Metodo que registra tutores en base de datos")
    @ApiResponses({
            @ApiResponse(code=201, message = "Tutor creado"),
            @ApiResponse(code=404, message = "Tutor no creado")
    })
    public ResponseEntity<Tutor> insertTutor(@Valid @RequestBody Tutor tutor){
        try{
            Tutor tutorNew = tutorService.save(tutor);
            return ResponseEntity.status(HttpStatus.CREATED).body(tutorNew);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Actualización de datos de Tutors", notes = "Metodo que actualiza los datos de tutores")
    @ApiResponses({
            @ApiResponse(code=200, message = "Datos de Tutor actualizados"),
            @ApiResponse(code=404, message = "Tutor no encontrado")
    })
    public ResponseEntity<Tutor> update(@PathVariable("id") Long id, @Valid @RequestBody Tutor tutor){
        try{
            Optional<Tutor> tutorUp = tutorService.getById(id);
            if(!tutorUp.isPresent())
                return new ResponseEntity<Tutor>(HttpStatus.NOT_FOUND);
            tutor.setId(id);
            tutorService.save(tutor);
            return new ResponseEntity<Tutor>(tutor, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Tutor>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Eliminación de Tutors", notes = "Metodo que elimina tutors")
    @ApiResponses({
            @ApiResponse(code=200, message = "Tutor eliminado"),
            @ApiResponse(code=404, message = "Tutor no eliminado")
    })
    public ResponseEntity<Tutor> deleteTutor(@PathVariable("id")Long id){
        try{
            Optional<Tutor> tutorDelete = tutorService.getById(id);
            if(!tutorDelete.isPresent())
                return new ResponseEntity<Tutor>(HttpStatus.NOT_FOUND);
            tutorService.delete(id);
            return new ResponseEntity<Tutor>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Tutor>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
