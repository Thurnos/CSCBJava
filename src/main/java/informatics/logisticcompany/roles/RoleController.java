package informatics.logisticcompany.roles;
import informatics.logisticcompany.dto.role.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @GetMapping("/list")
    public String getAllRoles(Model model) {
        List<RoleDTO> roleDTOList = roleService.getAllRoles();
        model.addAttribute("roles", roleDTOList);
        return "administration/list-roles";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        RoleDTO roleDTO = new RoleDTO();
        model.addAttribute("role", roleDTO);
        return "/administration/create-role";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        RoleDTO roleDTO = roleService.findByIdDTO(id);
        model.addAttribute("role", roleDTO);
        return "/administration/edit-role";
    }

    @PostMapping("/edit")
    public String updateRole(@ModelAttribute RoleDTO roleDTO) {
        roleService.updateRoleDTO(roleDTO);
        return "redirect:/roles/list";
    }

    @PostMapping("/create")
    public String createRole(@ModelAttribute("role") RoleDTO roleDTO) {
        roleService.createRoleDTO(roleDTO);
        return "redirect:/roles/list";
    }
    @PostMapping("/delete/{id}")
    public String deleteRole(@PathVariable("id") Long id) {
        roleService.deleteById(id);
        return "redirect:/roles/list";
    }
}
