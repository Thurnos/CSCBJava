package informatics.logisticcompany.controller.auth;

import informatics.logisticcompany.dto.user.UserDTO;
import informatics.logisticcompany.exception.UserAlreadyExistException;
import informatics.logisticcompany.users.User;
import informatics.logisticcompany.users.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.modelmapper.internal.Errors;
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
     */
    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }


    /**
     * Displays the registration form to the user.
     *
     * @param model The model object to pass data to the view.
     * @return The path to the registration view.
     */
    @GetMapping("/user/registration")
    public String showRegistrationForm(Model model) {
        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "/auth/register";
    }


    /**
     * Processes the user registration form submission.
     *
     * @param userDto The user data transfer object containing the submitted data.
     * @param request The HttpServletRequest object.
     * @param errors Validation errors that may have occurred during form submission.
     * @return The path to the login view if registration is successful; otherwise, returns to the registration form view.
     */
    @PostMapping("/user/registration")
    public String registerUser(@ModelAttribute("user") @Valid UserDTO userDto,
                                     HttpServletRequest request, Errors errors) {

        try {
            User user = userService.registerNewUser(userDto);
        } catch (UserAlreadyExistException e) {

            throw new RuntimeException(e);
        }
        return "/auth/login";
    }
}
