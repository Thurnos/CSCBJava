package informatics.logisticcompany.users;

import informatics.logisticcompany.dto.role.RoleDTO;
import informatics.logisticcompany.dto.user.UserBasicInfo;
import informatics.logisticcompany.dto.user.UserDTO;
import informatics.logisticcompany.dto.user.UserRolesDTO;
import informatics.logisticcompany.roles.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing user-related operations.
 * This class provides web endpoints for user management tasks such as
 * listing users, editing user details, and updating user information.
 */
@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    /**
     * Constructs UserController with UserService and RoleService.
     *
     * @param userService The service handling user operations.
     * @param roleService The service handling role operations.
     */
    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    /**
     * Creates a user with the specified details.
     *
     * @param user The user to create.
     * @return The created User object.
     */
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * Displays a list of all users along with their roles.
     *
     * @param model The model for the view to add attributes to.
     * @return The view name for listing users.
     */
    @GetMapping("/list")
    public String getAllUsers(Model model) {
        List<UserRolesDTO> users = userService.findALlUsersWithRoles();

        model.addAttribute("users", users);

        return "/user/list-users";
    }


    /**
     * Shows the form for editing a user's details.
     *
     * @param id The ID of the user to edit.
     * @param model The model to pass data to the view.
     * @return The view name for editing a user.
     */
    // Mapping the value of the id in the url
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        UserRolesDTO user = userService.findUserWithRoles(id);

        List<RoleDTO> roleList = roleService.findAllRolesWithRoleDTO();

        // user contains currently assigned roles
        // roles is a list of all available roles
        model.addAttribute("user", user);
        model.addAttribute("roleList", roleList);

        return "/user/edit-user";
    }

    /**
     * Updates a user with the given details.
     *
     * @param user The user details to update.
     * @return Redirects to the user list view.
     */
    @PostMapping("/update")
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:/users/list";
    }

}
