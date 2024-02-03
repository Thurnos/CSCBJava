package informatics.logisticcompany.roles;

import informatics.logisticcompany.dto.role.RoleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // additional custom queries can be added here

    Role findRoleById(Long id);

    @Query("SELECT new informatics.logisticcompany.dto.role.RoleDTO(role.id, role.name) FROM Role role")
    List<RoleDTO> findAllRoles();

    @Query("SELECT new informatics.logisticcompany.dto.role.RoleDTO(r.id, r.name) FROM Role r WHERE r.name =:name")
    RoleDTO findRoleByName(String name);
}

