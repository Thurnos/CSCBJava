package informatics.logisticcompany.shipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    /**
     * Displays a list of all shipments.
     *
     * @param model Model to add attributes to the view, enabling data access.
     * @return The view name to render the list of shipments.
     */
    @GetMapping("/list")
    public String getAllShipments(Model model) {
        List<Shipment> shipmentList = shipmentService.getAllShipments();
        model.addAttribute("shipments", shipmentList);
        return "shipment/list-shipments";
    }

    /**
     * Shows the form for creating a new shipment.
     *
     * @param model Model to pass an empty Shipment object to the form.
     * @return The view name to render the creation form.
     */
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        Shipment shipment = new Shipment();
        model.addAttribute("shipment", shipment);
        return "shipment/create-shipment";
    }

    /**
     * Processes the submission of the shipment creation form.
     *
     * @param shipment The Shipment entity populated from the form submission.
     * @return Redirects to the list of shipments upon successful creation.
     */
    @PostMapping("/save")
    public String saveShipment(@ModelAttribute("shipment") Shipment shipment) {
        shipmentService.createShipment(shipment);
        return "redirect:/shipments/list";
    }

    /**
     * Shows the form for editing an existing shipment.
     *
     * @param id    The ID of the shipment to edit.
     * @param model Model to add the shipment information to the form.
     * @return The view name to render the edit form.
     */
    @GetMapping("/edit/{id}")
    public String editShipment(@PathVariable("id") Long id, Model model) {
        Shipment shipment = shipmentService.findShipmentById(id);
        model.addAttribute("shipment", shipment);
        return "shipment/edit-shipment";
    }

    /**
     * Processes the submission of the shipment edit form.
     *
     * @param updatedShipment The updated Shipment entity from the form submission.
     * @return Redirects to the list of shipments upon successful update.
     */
    @PostMapping("/update")
    public String updateShipment(@ModelAttribute("shipment") Shipment updatedShipment) {
        shipmentService.updateShipment(updatedShipment);
        return "redirect:/shipments/list";
    }

    /**
     * Handles the deletion of a shipment.
     *
     * @param id The ID of the shipment to delete.
     * @return Redirects to the list of shipments upon successful deletion.
     */
    @DeleteMapping("/delete/{id}")
    public String deleteShipment(@PathVariable("id") Long id) {
        shipmentService.deleteShipment(id);
        return "redirect:/shipments/list";
    }
}
