
package ar.com.yoprogramo.api.security.repository;

import ar.com.yoprogramo.api.security.Entity.Rol;
import ar.com.yoprogramo.api.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional <Rol> findByRolNombre(RolNombre rolNombre);
}
