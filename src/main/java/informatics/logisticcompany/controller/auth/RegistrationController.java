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
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/registration")
    public String showRegistrationForm(Model model) {
        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "/auth/register";
    }

    @PostMapping("/user/registration")
    public String registerUser(@ModelAttribute("user") @Valid UserDTO userDto,
                                     HttpServletRequest request, Errors errors) {

        try {
            User user = userService.registerNewUser(userDto);
        } catch (UserAlreadyExistException e) {

            throw new RuntimeException(e);
        }
        return "/logistic-companies/list-logistic-companies";
    }
}
