package informatics.logisticcompany.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    /**
     * Displays the login form to the user.
     * This method handles the GET request to the login page, returning the view name of the login form.
     *
     * @return The path to the login view, allowing the user to enter their credentials.
     */
    @GetMapping("/user/login")
    public String showLoginForm() {
        return "/auth/login";
    }

}
