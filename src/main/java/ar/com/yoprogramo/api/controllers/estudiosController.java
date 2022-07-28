
package ar.com.yoprogramo.api.controllers;

import ar.com.yoprogramo.api.models.Estudios;
import ar.com.yoprogramo.api.services.estudiosService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "https://frontendargprg.web.app")
@RequestMapping("/api/sebastian/estudios")
public class estudiosController {
    @Autowired
    estudiosService estudiosService;
    @GetMapping("/all")
    public ArrayList<Estudios>getAllEstudios(){
        return estudiosService.GetAllEstudios();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public Estudios estudiosSave(@RequestBody Estudios estudio){
        return estudiosService.saveEstudio(estudio);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public void updateEstudios(@RequestBody Estudios p){
        
        estudiosService.saveAndFlush(p);
    }
    @GetMapping(value ="/{id}")
    public Object getEstudioByID(@PathVariable Long id){
        return estudiosService.getEstudiosByID(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
        public void removeEstudio(@PathVariable long id){
             estudiosService.removeEstudio(id);
        }
    }
    

