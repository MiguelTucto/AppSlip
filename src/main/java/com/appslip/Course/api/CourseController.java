package com.appslip.Course.api;

import com.appslip.Course.domain.model.Course;
import com.appslip.Course.domain.model.ICourseService;
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
@RequestMapping("/api/courses")
@Api(tags = "Course", value = "Servicio Web RESTFul de Courses")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Listar Courses", notes = "Método para listar todos los courses")
    @ApiResponses({
            @ApiResponse(code=201, message = "Courses encontrados"),
            @ApiResponse(code=404, message = "Courses no encontrados")
    })
    public ResponseEntity<List<Course>> findAll(){
        try{
            List<Course> courses = courseService.getAll();
            if(courses.size()>0)
                return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
            else
                return new ResponseEntity<List<Course>>(HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            return new ResponseEntity<List<Course>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Course por Id", notes = "Método para encontrar un course por su respectivo Id")
    @ApiResponses({
            @ApiResponse(code=201, message = "Course encontrado"),
            @ApiResponse(code=404, message = "Course no encontrado")
    })
    public ResponseEntity<Course> findById(@PathVariable("id") Long id){
        try{
            Optional<Course> course = courseService.getById(id);
            if(!course.isPresent())
                return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<Course>(course.get(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Course>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchByCourseName/{courseName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Courses por courseName", notes = "Método para encontrar courses por su respectivo courseName")
    @ApiResponses({
            @ApiResponse(code=201, message = "Courses encontrados"),
            @ApiResponse(code=404, message = "Courses no encontrados")
    })
    public ResponseEntity<List<Course>> findByCourseName(@PathVariable("courseName") String courseName){
        try{
            List<Course> courses = courseService.findByCourseName(courseName);
            if(courses.size()>0)
                return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
            else
                return new ResponseEntity<List<Course>>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<List<Course>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Registro de Courses", notes = "Metodo que registra cursos en base de datos")
    @ApiResponses({
            @ApiResponse(code=201, message = "Course creado"),
            @ApiResponse(code=404, message = "Course no creado")
    })
    public ResponseEntity<Course> insertCourse(@Valid @RequestBody Course course){
        try{
            Course courseNew = courseService.save(course);
            return ResponseEntity.status(HttpStatus.CREATED).body(courseNew);
        }catch(Exception e){
            return new ResponseEntity<Course>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Actualización de datos de Courses", notes = "Metodo que actualiza los datos de cursos")
    @ApiResponses({
            @ApiResponse(code=200, message = "Datos de Course actualizados"),
            @ApiResponse(code=404, message = "Course no encontrado")
    })
    public ResponseEntity<Course> updateCourse(@PathVariable("id") Long id, @Valid @RequestBody Course course){
        try{
            Optional<Course> courseUp = courseService.getById(id);
            if(!courseUp.isPresent())
                return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
            course.setId(id);
            courseService.save(course);
            return new ResponseEntity<Course>(course, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Course>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Eliminación de Courses", notes = "Metodo que elimina courses")
    @ApiResponses({
            @ApiResponse(code=200, message = "Course eliminado"),
            @ApiResponse(code=404, message = "Course no eliminado")
    })
    public ResponseEntity<Course> deleteCourse(@PathVariable("id")Long id){
        try{
            Optional<Course> courseDelete = courseService.getById(id);
            if(!courseDelete.isPresent())
                return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
            courseService.delete(id);
            return new ResponseEntity<Course>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Course>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
