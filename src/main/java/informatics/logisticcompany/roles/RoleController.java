package informatics.logisticcompany.roles;
import informatics.logisticcompany.dto.role.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controller for handling web requests related to roles.
 * Provides functionalities to create, list, edit, and delete roles through a web interface.
 */
@Controller
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;


    /**
     * Constructs the RoleController with the necessary service.
     *
     * @param roleService The service handling business logic for role operations.
     */
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * Handles the creation of a new role entity.
     *
     * @param role The role entity to be created.
     * @return The created Role entity.
     */
    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }


    /**
     * Displays a list of all roles in the system.
     *
     * @param model The model for passing data to the view.
     * @return The view name to render the list of roles.
     */
    @GetMapping("/list")
    public String getAllRoles(Model model) {
        List<RoleDTO> roleDTOList = roleService.getAllRoles();
        model.addAttribute("roles", roleDTOList);
        return "administration/list-roles";
    }

    /**
     * Shows the form for creating a new role.
     *
     * @param model The model to pass an empty RoleDTO object to the form.
     * @return The view name for the role creation form.
     */
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        RoleDTO roleDTO = new RoleDTO();
        model.addAttribute("role", roleDTO);
        return "/administration/create-role";
    }


    /**
     * Shows the form for editing an existing role.
     *
     * @param id The ID of the role to edit.
     * @param model The model to pass the RoleDTO object to the form.
     * @return The view name for the role edit form.
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        RoleDTO roleDTO = roleService.findByIdDTO(id);
        model.addAttribute("role", roleDTO);
        return "/administration/edit-role";
    }

    /**
     * Updates an existing role based on the provided RoleDTO data.
     *
     * @param roleDTO The RoleDTO with updated data.
     * @return Redirects to the list of roles view.
     */
    @PostMapping("/edit")
    public String updateRole(@ModelAttribute RoleDTO roleDTO) {
        roleService.updateRoleDTO(roleDTO);
        return "redirect:/roles/list";
    }

    /**
     * Creates a new role from the provided RoleDTO data.
     *
     * @param roleDTO The RoleDTO for the new role.
     * @return Redirects to the list of roles view.
     */
    @PostMapping("/create")
    public String createRole(@ModelAttribute("role") RoleDTO roleDTO) {
        roleService.createRoleDTO(roleDTO);
        return "redirect:/roles/list";
    }

    /**
     * Deletes a role by its ID.
     *
     * @param id The ID of the role to delete.
     * @return Redirects to the list of roles view.
     */
    @PostMapping("/delete/{id}")
    public String deleteRole(@PathVariable("id") Long id) {
        roleService.deleteById(id);
        return "redirect:/roles/list";
    }
}
