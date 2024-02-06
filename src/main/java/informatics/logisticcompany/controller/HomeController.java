package informatics.logisticcompany.controller;

import informatics.logisticcompany.dto.client.ClientDTO;
import informatics.logisticcompany.dto.shipment.ShipmentDTO;
import informatics.logisticcompany.dto.user.UserDTO;
import informatics.logisticcompany.shipment.ShipmentService;
import informatics.logisticcompany.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private ShipmentService shipmentService;
    private UserService userService;

    @Autowired
    public HomeController(ShipmentService shipmentService, UserService userService) {
        this.shipmentService = shipmentService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/system")
    public String system() {
        return "system";
    }

    @GetMapping("/orders/list")
    public String orders(Model model) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserDTO userDTO = userService.findUserDTOByUsername(username);
        List<ShipmentDTO> shipmentDTOList = shipmentService.getAllBySenderOrRecipientId(userDTO.getId());

        model.addAttribute("shipments", shipmentDTOList);

        return "/my-orders/my-orders";
    }

    @GetMapping("/requests")
    public String requests() {

        return "/request/requests";
    }
}
