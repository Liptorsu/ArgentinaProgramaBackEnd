
package ar.com.yoprogramo.api.services;

import ar.com.yoprogramo.api.models.Estudios;
import ar.com.yoprogramo.api.repositories.estudiosRepositories;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class estudiosService {
    
    @Autowired
    estudiosRepositories estudiosRepositories;
        public ArrayList<Estudios>GetAllEstudios(){
        return (ArrayList<Estudios>) estudiosRepositories.findAll();
    }
    public Estudios saveEstudios(Estudios estudios){
        return estudiosRepositories.save(estudios);
    }

    public Optional<Estudios> getEstudiosByID(Long id) {
    return estudiosRepositories.findById(id);
    }


    public ArrayList<Estudios> getEstudiosByTitulo(String titulo) {
        return estudiosRepositories.findByTitulo(titulo);
    }
    public boolean removeEstudio(Long id) {
    try {
        estudiosRepositories.deleteById(id);
        return true;
        
    }    catch(Exception e){
        return false;
    }
    }


    public Estudios saveAndFlush(Estudios p) {
        return estudiosRepositories.saveAndFlush(p);
    }

    public Estudios saveEstudio(Estudios estudio) {
        return estudiosRepositories.save(estudio);
        }
}

