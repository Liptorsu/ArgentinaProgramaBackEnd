
package ar.com.yoprogramo.api.repositories;

import ar.com.yoprogramo.api.models.Estudios;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface estudiosRepositories extends JpaRepository<Estudios, Long> {
    
    public abstract ArrayList<Estudios> findByTitulo(String titulo);


}
