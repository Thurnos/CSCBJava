package informatics.logisticcompany.mapper;

import informatics.logisticcompany.dto.role.RoleDTO;
import informatics.logisticcompany.roles.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    private final ModelMapper modelMapper;


    /**
     * Constructs a RoleMapper with an injected ModelMapper for object mapping.
     *
     * @param modelMapper The ModelMapper instance used for converting objects.
     */
    @Autowired
    public RoleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    /**
     * Converts a Role entity to a RoleDTO.
     *
     * @param role The Role entity to convert.
     * @return A RoleDTO representing the role's data.
     */
    public RoleDTO convertToDTO(Role role) {
        RoleDTO roleDTO = modelMapper.map(role, RoleDTO.class);
        return roleDTO;
    }


    /**
     * Converts a RoleDTO to a Role entity.
     *
     * @param roleDTO The RoleDTO to convert.
     * @return A Role entity populated with the DTO's data.
     */
    public Role convertToEntity(RoleDTO roleDTO) {
        Role role = modelMapper.map(roleDTO, Role.class);
        return role;
    }
}
