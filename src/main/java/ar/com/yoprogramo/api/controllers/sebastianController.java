
package ar.com.yoprogramo.api.controllers;

import ar.com.yoprogramo.api.models.Sebastian;
import ar.com.yoprogramo.api.services.sebastianService;
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
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontendargprg.web.app")
@RequestMapping("/api/sebastian")
public class sebastianController {
    @Autowired
    sebastianService sebastianService;
    @GetMapping("/all")
    public ArrayList<Sebastian>getAllsebastian(){
        return sebastianService.GetAllSebastians();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public Sebastian sebastianSave(@RequestBody Sebastian sebastian){
        return sebastianService.savePerson(sebastian);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public void updatePerson(@RequestBody Sebastian p){
        
        sebastianService.saveAndFlush(p);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public String removePerson(@PathVariable("id") Long id){
        if(sebastianService.removePerson(id)){
            return "Se elimino a la persona de id " + id + " correctamente";
        }
        else{
            return "La persona no existe o no pudo ser eliminada";
        }
    }
}
