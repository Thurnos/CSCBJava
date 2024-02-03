package informatics.logisticcompany.controller.auth;

import informatics.logisticcompany.dto.user.UserDTO;
import informatics.logisticcompany.dto.user.UserRegisterDTO;
import informatics.logisticcompany.users.User;
import informatics.logisticcompany.users.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final UserService userService;

    /**
     * Constructs a RegistrationController with a UserService.
     *
     * @param userService The service for user-related operations, injected by Spring.
     *
     */
    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/auth/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("userRegister", new UserRegisterDTO());
        return "/auth/register";
    }

    @PostMapping("/auth/register")
    public String processRegistration(@Valid @ModelAttribute("userRegister") UserRegisterDTO user,
                                      Model model) {
        String username = user.getUsername();

        UserDTO existing = userService.findUserDTOByUsername(username);
        if (existing != null) {
            model.addAttribute("registrationError", "Username already exists.");
            return "/auth/register";
        }

        userService.registerUser(user);

        model.addAttribute("registrationSuccessful", "Successful registration!");
        return "/auth/login";
    }
}
