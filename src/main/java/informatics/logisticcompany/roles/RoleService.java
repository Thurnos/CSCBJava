package informatics.logisticcompany.roles;

import informatics.logisticcompany.dto.role.RoleDTO;
import informatics.logisticcompany.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service layer for managing roles.
 * Handles business logic for role-related operations, including CRUD functionalities and DTO conversions.
 */
@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    /**
     * Constructs the RoleService with necessary dependencies for role management.
     *
     * @param roleRepository The repository for role data access.
     * @param roleMapper The mapper for converting between Role entities and RoleDTOs.
     */
    @Autowired
    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    /**
     * Retrieves all roles and converts them to RoleDTOs.
     *
     * @return A list of RoleDTOs.
     */
    public List<RoleDTO> getAllRoles() {
        List<Role> roles = roleRepository.findAll();

        return roles.stream()
                .map(roleMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Creates a new role in the database.
     *
     * @param role The Role entity to be saved.
     * @return The saved Role entity.
     */
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    /**
     * Creates a new role based on the provided RoleDTO.
     *
     * @param roleDTO The RoleDTO to convert to an entity and save.
     * @return The saved Role entity.
     */
    public Role createRoleDTO(RoleDTO roleDTO) {
       return roleRepository.save(roleMapper.convertToEntity(roleDTO));
    }

    /**
     * Deletes a role by its ID.
     *
     * @param id The ID of the role to delete.
     */
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    /**
     * Finds a role by its ID and converts it to a RoleDTO.
     *
     * @param id The ID of the role.
     * @return The RoleDTO.
     */
    public RoleDTO findByIdDTO(Long id) {
        return roleMapper.convertToDTO(roleRepository.findRoleById(id));
    }

    /**
     * Updates an existing role based on the provided RoleDTO.
     *
     * @param roleDTO The RoleDTO with updated data.
     * @return The updated Role entity.
     */
    public Role updateRoleDTO(@ModelAttribute RoleDTO roleDTO) {
        return roleRepository.save(roleMapper.convertToEntity(roleDTO));
    }

    public List<RoleDTO> findAllRolesWithRoleDTO() {
        return roleRepository.findAllRoles();
    }
}
