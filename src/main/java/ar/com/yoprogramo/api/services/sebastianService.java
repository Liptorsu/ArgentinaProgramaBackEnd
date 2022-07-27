
package ar.com.yoprogramo.api.services;

import ar.com.yoprogramo.api.models.Sebastian;
import ar.com.yoprogramo.api.repositories.sebastianRepositories;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sebastianService {
    
    @Autowired
    sebastianRepositories sebastianRepositories;
        public ArrayList<Sebastian>GetAllSebastians(){
        return (ArrayList<Sebastian>) sebastianRepositories.findAll();
    }
    public Sebastian savePerson(Sebastian sebastian){
        return sebastianRepositories.save(sebastian);
    }

    public Optional<Sebastian> getPersonByID(Long id) {
    return sebastianRepositories.findById(id);
    }


    public ArrayList<Sebastian> getPersonByApellido(String apellido) {
        return sebastianRepositories.findByApellido(apellido);
    }

    public boolean removePerson(Long id) {
    try {
        sebastianRepositories.deleteById(id);
        return true;
        
    }    catch(Exception e){
        return false;
    }
    }

    public Sebastian saveAndFlush(Sebastian p) {
        return sebastianRepositories.saveAndFlush(p);
    }
}

