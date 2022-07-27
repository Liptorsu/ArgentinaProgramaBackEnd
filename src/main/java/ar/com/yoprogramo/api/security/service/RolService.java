
package ar.com.yoprogramo.api.security.service;

import ar.com.yoprogramo.api.security.Entity.Rol;
import ar.com.yoprogramo.api.security.enums.RolNombre;
import ar.com.yoprogramo.api.security.repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional <Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
