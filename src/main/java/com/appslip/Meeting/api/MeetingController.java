package com.appslip.Meeting.api;

import com.appslip.Meeting.domain.model.IMeetingService;
import com.appslip.Meeting.domain.model.Meeting;
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
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/meetings")
@Api(tags = "Meeting", value = "Servicio Web RESTFul de Meetings")
public class MeetingController {

    @Autowired
    private IMeetingService meetingService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Listar Meetings", notes = "Método para listar todos los meetings")
    @ApiResponses({
            @ApiResponse(code=201, message = "Meetings encontrados"),
            @ApiResponse(code=404, message = "Meetings no encontrados")
    })
    public ResponseEntity<List<Meeting>> findAll(){
        try{
            List<Meeting> meetings = meetingService.getAll();
            if(meetings.size()>0)
                return new ResponseEntity<List<Meeting>>(meetings, HttpStatus.OK);
            else
                return new ResponseEntity<List<Meeting>>(HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            return new ResponseEntity<List<Meeting>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Meeting por Id", notes = "Método para encontrar un meeting por su respectivo Id")
    @ApiResponses({
            @ApiResponse(code=201, message = "Meeting encontrado"),
            @ApiResponse(code=404, message = "Meeting no encontrado")
    })
    public ResponseEntity<Meeting> findById(@PathVariable("id") Long id){
        try{
            Optional<Meeting> meeting = meetingService.getById(id);
            if(!meeting.isPresent())
            return new ResponseEntity<Meeting>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<Meeting>(meeting.get(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Meeting>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchByNameMeeting/{nameMeeting}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Meetings por nameMeeting", notes = "Método para encontrar meetings por su respectivo nameMeeting")
    @ApiResponses({
            @ApiResponse(code=201, message = "Meetings encontrados"),
            @ApiResponse(code=404, message = "Meetings no encontrados")
    })
    public ResponseEntity<List<Meeting>> findByNameMeeting(@PathVariable("nameMeeting") String nameMeeting){
        try{
            List<Meeting> meetings = meetingService.findByNameMeeting(nameMeeting);
            if(meetings.size()>0)
                return new ResponseEntity<List<Meeting>>(meetings, HttpStatus.OK);
            else
                return new ResponseEntity<List<Meeting>>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<List<Meeting>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchByNumberUsers/{numberUsers}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Meetings por numberUsers", notes = "Método para encontrar meetings por su respectivo numberUsers")
    @ApiResponses({
            @ApiResponse(code=201, message = "Meetings encontrados"),
            @ApiResponse(code=404, message = "Meetings no encontrados")
    })
    public ResponseEntity<List<Meeting>> findByNumberUsers(@PathVariable("numberUsers") Integer numberUsers){
        try{
            List<Meeting> meetings = meetingService.findByNumberUsers(numberUsers);
            if(meetings.size()>0)
                return new ResponseEntity<List<Meeting>>(meetings, HttpStatus.OK);
            else
                return new ResponseEntity<List<Meeting>>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<List<Meeting>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchByCreateAt/{createAt}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Meetings por createAt", notes = "Método para encontrar meetings por su respectivo createAt")
    @ApiResponses({
            @ApiResponse(code=201, message = "Meetings encontrados"),
            @ApiResponse(code=404, message = "Meetings no encontrados")
    })
    public ResponseEntity<List<Meeting>> findByCreateAt(@PathVariable("createAt") Date createAt){
        try{
            List<Meeting> meetings = meetingService.findByCreateAt(createAt);
            if(meetings.size()>0)
                return new ResponseEntity<List<Meeting>>(meetings, HttpStatus.OK);
            else
                return new ResponseEntity<List<Meeting>>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<List<Meeting>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchByCheckingDate/{CheckingDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Meetings por CheckingDate", notes = "Método para encontrar meetings por su respectivo CheckingDate")
    @ApiResponses({
            @ApiResponse(code=201, message = "Meetings encontrados"),
            @ApiResponse(code=404, message = "Meetings no encontrados")
    })
    public ResponseEntity<List<Meeting>> findByCheckingDate(@PathVariable("CheckingDate") Date checkingDate){
        try{
            List<Meeting> meetings = meetingService.findByCheckingDate(checkingDate);
            if(meetings.size()>0)
                return new ResponseEntity<List<Meeting>>(meetings, HttpStatus.OK);
            else
                return new ResponseEntity<List<Meeting>>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<List<Meeting>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchByCheckoutDate/{CheckoutDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Meetings por CheckoutDate", notes = "Método para encontrar meetings por su respectivo CheckoutDate")
    @ApiResponses({
            @ApiResponse(code=201, message = "Meetings encontrados"),
            @ApiResponse(code=404, message = "Meetings no encontrados")
    })
    public ResponseEntity<List<Meeting>> findByCheckoutDate(@PathVariable("CheckoutDate") Date checkoutDate){
        try{
            List<Meeting> meetings = meetingService.findByCheckoutDate(checkoutDate);
            if(meetings.size()>0)
                return new ResponseEntity<List<Meeting>>(meetings, HttpStatus.OK);
            else
                return new ResponseEntity<List<Meeting>>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<List<Meeting>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Registro de Meetings", notes = "Metodo que registra reuniones en base de datos")
    @ApiResponses({
            @ApiResponse(code=201, message = "Meeting creado"),
            @ApiResponse(code=404, message = "Meeting no creado")
    })
    public ResponseEntity<Meeting> insertMeeting(@Valid @RequestBody Meeting meeting){
        try{
            Meeting meetingNew = meetingService.save(meeting);
            return ResponseEntity.status(HttpStatus.CREATED).body(meetingNew);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Actualización de datos de Meetings", notes = "Metodo que actualiza los datos de las reuniones")
    @ApiResponses({
            @ApiResponse(code=200, message = "Datos de Meeting actualizados"),
            @ApiResponse(code=404, message = "Meeting no encontrado")
    })
    public ResponseEntity<Meeting> updateMeeting(@PathVariable("id") Long id, @Valid @RequestBody Meeting meeting){
        try{
            Optional<Meeting> meetingUp = meetingService.getById(id);
            if(!meetingUp.isPresent())
                return new ResponseEntity<Meeting>(HttpStatus.NOT_FOUND);
            meeting.setId(id);
            meetingService.save(meeting);
            return new ResponseEntity<Meeting>(meeting, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Meeting>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Eliminación de Meetings", notes = "Metodo que elimina meetings")
    @ApiResponses({
            @ApiResponse(code=200, message = "Meeting eliminado"),
            @ApiResponse(code=404, message = "Meeting no eliminado")
    })
    public ResponseEntity<Meeting> deleteMeeting(@PathVariable("id")Long id){
        try{
            Optional<Meeting> meetingDelete = meetingService.getById(id);
            if(!meetingDelete.isPresent())
                return new ResponseEntity<Meeting>(HttpStatus.NOT_FOUND);
            meetingService.delete(id);
            return new ResponseEntity<Meeting>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Meeting>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
