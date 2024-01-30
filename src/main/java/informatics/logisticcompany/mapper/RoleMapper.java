package informatics.logisticcompany.mapper;

import informatics.logisticcompany.dto.role.RoleDTO;
import informatics.logisticcompany.roles.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public RoleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RoleDTO convertToDTO(Role role) {
        RoleDTO roleDTO = modelMapper.map(role, RoleDTO.class);
        return roleDTO;
    }

    public Role convertToEntity(RoleDTO roleDTO) {
        Role role = modelMapper.map(roleDTO, Role.class);
        return role;
    }
}
