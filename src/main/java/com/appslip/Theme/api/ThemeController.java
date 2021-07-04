package com.appslip.Theme.api;

import com.appslip.Theme.domain.model.Theme;
import com.appslip.Theme.domain.model.IThemeService;
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
@RequestMapping("/api/themes")
@Api(tags = "Theme", value = "Servicio Web RESTFul de Themes")
public class ThemeController {

    @Autowired
    private IThemeService themeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Listar Themes", notes = "Método para listar todos los themes")
    @ApiResponses({
            @ApiResponse(code=201, message = "Themes encontrados"),
            @ApiResponse(code=404, message = "Themes no encontrados")
    })
    public ResponseEntity<List<Theme>> findAll(){
        try{
            List<Theme> themes = themeService.getAll();
            if(themes.size()>0)
                return new ResponseEntity<List<Theme>>(themes, HttpStatus.OK);
            else
                return new ResponseEntity<List<Theme>>(HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            return new ResponseEntity<List<Theme>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Theme por Id", notes = "Método para encontrar un theme por su respectivo Id")
    @ApiResponses({
            @ApiResponse(code=201, message = "Theme encontrado"),
            @ApiResponse(code=404, message = "Theme no encontrado")
    })
    public ResponseEntity<Theme> findById(@PathVariable("id") Long id){
        try{
            Optional<Theme> theme = themeService.getById(id);
            if(!theme.isPresent())
            return new ResponseEntity<Theme>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<Theme>(theme.get(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Theme>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchByThemeName/{themeName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Themes por themeName", notes = "Método para encontrar themes por su respectivo themeName")
    @ApiResponses({
            @ApiResponse(code=201, message = "Themes encontrados"),
            @ApiResponse(code=404, message = "Themes no encontrados")
    })
    public ResponseEntity<List<Theme>> findByThemeName(@PathVariable("themeName") String themeName){
        try{
            List<Theme> themes = themeService.findByThemeName(themeName);
            if(themes.size()>0)
                return new ResponseEntity<List<Theme>>(themes, HttpStatus.OK);
            else
                return new ResponseEntity<List<Theme>>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<List<Theme>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Registro de Themes", notes = "Metodo que registra temas en base de datos")
    @ApiResponses({
            @ApiResponse(code=201, message = "Theme creado"),
            @ApiResponse(code=404, message = "Theme no creado")
    })
    public ResponseEntity<Theme> insertTheme(@Valid @RequestBody Theme theme){
        try{
            Theme themeNew = themeService.save(theme);
            return ResponseEntity.status(HttpStatus.CREATED).body(themeNew);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Actualización de datos de Themes", notes = "Metodo que actualiza los datos de themes")
    @ApiResponses({
            @ApiResponse(code=200, message = "Datos de Theme actualizados"),
            @ApiResponse(code=404, message = "Theme no encontrado")
    })
    public ResponseEntity<Theme> updateTheme(@PathVariable("id") Long id, @Valid @RequestBody Theme theme){
        try{
            Optional<Theme> themeUp = themeService.getById(id);
            if(!themeUp.isPresent())
                return new ResponseEntity<Theme>(HttpStatus.NOT_FOUND);
            theme.setId(id);
            themeService.save(theme);
            return new ResponseEntity<Theme>(theme, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Theme>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Eliminación de Themes", notes = "Metodo que elimina themes")
    @ApiResponses({
            @ApiResponse(code=200, message = "Theme eliminado"),
            @ApiResponse(code=404, message = "Theme no eliminado")
    })
    public ResponseEntity<Theme> deleteTheme(@PathVariable("id")Long id){
        try{
            Optional<Theme> themeDelete = themeService.getById(id);
            if(!themeDelete.isPresent())
                return new ResponseEntity<Theme>(HttpStatus.NOT_FOUND);
            themeService.delete(id);
            return new ResponseEntity<Theme>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Theme>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
