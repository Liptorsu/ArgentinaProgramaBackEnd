
package ar.com.yoprogramo.api.repositories;

import ar.com.yoprogramo.api.models.Sebastian;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface sebastianRepositories extends JpaRepository<Sebastian, Long> {
    
    public abstract ArrayList<Sebastian> findByApellido(String descripcion);
}
