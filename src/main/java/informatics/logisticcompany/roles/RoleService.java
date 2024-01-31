package informatics.logisticcompany.roles;

import informatics.logisticcompany.dto.role.RoleDTO;
import informatics.logisticcompany.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public List<RoleDTO> getAllRoles() {
        List<Role> roles = roleRepository.findAll();

        return roles.stream()
                .map(roleMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
    public Role createRoleDTO(RoleDTO roleDTO) {
       return roleRepository.save(roleMapper.convertToEntity(roleDTO));
    }

    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    public RoleDTO findByIdDTO(Long id) {
        return roleMapper.convertToDTO(roleRepository.findRoleById(id));
    }

    public Role updateRoleDTO(@ModelAttribute RoleDTO roleDTO) {
        return roleRepository.save(roleMapper.convertToEntity(roleDTO));
    }

    public List<RoleDTO> findAllRolesWithRoleDTO() {
        return roleRepository.findAllRoles();
    }
}
