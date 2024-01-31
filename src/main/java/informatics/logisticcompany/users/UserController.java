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

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/list")
    public String getAllUsers(Model model) {
        List<UserRolesDTO> users = userService.findALlUsersWithRoles();

        model.addAttribute("users", users);

        return "/user/list-users";
    }

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

    @PostMapping("/update")
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:/users/list";
    }

}
