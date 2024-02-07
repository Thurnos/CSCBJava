package informatics.logisticcompany.shipment;

import informatics.logisticcompany.client.ClientService;
import informatics.logisticcompany.delivery.DeliveryTypeService;
import informatics.logisticcompany.dto.client.ClientDTO;
import informatics.logisticcompany.dto.delivery_type.DeliveryTypeDTO;
import informatics.logisticcompany.dto.employee.EmployeeDTO;
import informatics.logisticcompany.dto.logistic_companies.LogisticCompanyDTO;
import informatics.logisticcompany.dto.pricing_tier.PricingTierDTO;
import informatics.logisticcompany.dto.shipment.ShipmentDTO;
import informatics.logisticcompany.dto.shipment_status.ShipmentStatusDTO;
import informatics.logisticcompany.employees.Employee;
import informatics.logisticcompany.employees.EmployeeService;
import informatics.logisticcompany.logistic_companies.LogisticCompanyService;
import informatics.logisticcompany.pricing_tier.PricingTierController;
import informatics.logisticcompany.pricing_tier.PricingTierService;
import informatics.logisticcompany.shipment_status.ShipmentStatus;
import informatics.logisticcompany.shipment_status.ShipmentStatusService;
import informatics.logisticcompany.shipment_status_cataloc.ShipmentStatusCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;
    private final ClientService clientService;
    private final EmployeeService employeeService;
    private final DeliveryTypeService deliveryTypeService;
    private final ShipmentStatusService shipmentStatusService;
    private final LogisticCompanyService logisticCompanyService;
    private final PricingTierService pricingTierService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService, ClientService clientService, EmployeeService employeeService, DeliveryTypeService deliveryTypeService, ShipmentStatusService shipmentStatusService, LogisticCompanyService logisticCompanyService, PricingTierService pricingTierService) {
        this.shipmentService = shipmentService;
        this.clientService = clientService;
        this.employeeService = employeeService;
        this.deliveryTypeService = deliveryTypeService;
        this.shipmentStatusService = shipmentStatusService;
        this.logisticCompanyService = logisticCompanyService;
        this.pricingTierService = pricingTierService;
    }

    /**
     * Displays a list of all shipments.
     *
     * @param model Model to add attributes to the view, enabling data access.
     * @return The view name to render the list of shipments.
     */
    @GetMapping("/list")
    public String getAllShipments(Model model) {
        List<ShipmentDTO> shipmentList = shipmentService.getAllShipmentsWithShipmentDTO();
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

        List<ClientDTO> clientDTOList = clientService.getAllClientsWithClientDTO();
        List<DeliveryTypeDTO> deliveryTypeDTOList = deliveryTypeService.getAllWithDeliveryTypeDTO();
        List<ShipmentStatusDTO> shipmentStatusDTOList = shipmentStatusService.getAllWithShipmentStatusDTO();
        List<PricingTierDTO> pricingTierDTOList = pricingTierService.getAllWithPricingTierDTO();
        List<LogisticCompanyDTO> logisticCompanyDTOList = logisticCompanyService.getAllWithLogisticCompanyDTO();

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        Employee employee = employeeService.findEmployeeByUsername(username);
        EmployeeDTO employeeDTO = employeeService.findEmployeeWithEmployeeDTOByUsername(username);

        model.addAttribute("clientList", clientDTOList);
        model.addAttribute("deliveryTypeList", deliveryTypeDTOList);
        model.addAttribute("shipmentStatusList", shipmentStatusDTOList);
        model.addAttribute("pricingTierList", pricingTierDTOList);
        model.addAttribute("logisticCompaniesList", logisticCompanyDTOList);
        model.addAttribute("employee", employeeDTO);

        return "/shipment/create-shipment";
    }
    /**
     * Processes the submission of the shipment creation form.
     *
     * @param shipment The Shipment entity populated from the form submission.
     * @return Redirects to the list of shipments upon successful creation.
     */
    @PostMapping("/create")
    public String saveShipment(@ModelAttribute("shipment") Shipment shipment) {

        BigDecimal totalPrice = BigDecimal.ZERO;
        BigDecimal shipmentWeight = shipment.getWeight();
        BigDecimal tierCostPerUnit = shipment.getPricingTier().getCostPerUnitWeight();
        BigDecimal baseCost = shipment.getPricingTier().getBaseCost();

        // TODO IF EXPRESS + VALUE

        totalPrice = shipmentWeight.multiply(tierCostPerUnit).add(baseCost);

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Employee employee = employeeService.findEmployeeByUsername(username);

        shipment.setTotal(totalPrice);

        shipment.setUuid(UUID.randomUUID());
        shipment.setCreated(LocalDateTime.now());
        shipment.setRegisteredBy(employee);
        shipmentService.save(shipment);

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

        ShipmentDTO shipmentDTO = shipmentService.findByIdWithShipmentDTO(id);
        List<ClientDTO> clientDTOList = clientService.getAllClientsWithClientDTO();
        List<DeliveryTypeDTO> deliveryTypeDTOList = deliveryTypeService.getAllWithDeliveryTypeDTO();
        List<ShipmentStatusDTO> shipmentStatusDTOList = shipmentStatusService.getAllWithShipmentStatusDTO();
        List<PricingTierDTO> pricingTierDTOList = pricingTierService.getAllWithPricingTierDTO();
        List<LogisticCompanyDTO> logisticCompanyDTOList = logisticCompanyService.getAllWithLogisticCompanyDTO();

        model.addAttribute("clientList", clientDTOList);
        model.addAttribute("deliveryTypeList", deliveryTypeDTOList);
        model.addAttribute("shipmentStatusList", shipmentStatusDTOList);
        model.addAttribute("pricingTierList", pricingTierDTOList);
        model.addAttribute("logisticCompaniesList", logisticCompanyDTOList);
        model.addAttribute("shipment", shipmentDTO);

        return "/shipment/edit-shipment";
    }

    @PostMapping("/edit")
    public String updateShipment(@ModelAttribute("shipment") Shipment shipment) {

        Shipment entity = shipmentService.findShipmentById(shipment.getId());

        shipment.setCreated(entity.getCreated());
        shipment.setTotal(entity.getTotal());
        shipment.setUuid(entity.getUuid());
        shipment.setRegisteredBy(entity.getRegisteredBy());

        shipmentService.updateShipment(shipment);
        return "redirect:/shipments/list";
    }

    /**
     * Handles the deletion of a shipment.
     *
     * @param id The ID of the shipment to delete.
     * @return Redirects to the list of shipments upon successful deletion.
     */
    @GetMapping("/delete/{id}")
    public String deleteShipment(@PathVariable("id") Long id) {
        shipmentService.deleteShipment(id);
        return "redirect:/shipments/list";
    }

    @GetMapping("/edit-status/{id}")
    public String showUpdateStatusForm(@PathVariable("id") Long id, Model model) {

        informatics.logisticcompany.dto.shipment.ShipmentStatusDTO shipmentStatusDTO = shipmentService.findByIdWithShipmentStatusDTO(id);
        List<ShipmentStatusDTO> shipmentStatusDTOList = shipmentStatusService.getAllWithShipmentStatusDTO();

        model.addAttribute("shipment", shipmentStatusDTO);
        model.addAttribute("statusList", shipmentStatusDTOList);

        return "/shipment/edit-status";
    }

    @PostMapping("/edit-status")
    public String updateShipmentStatus(@ModelAttribute("shipment") Shipment shipment) {

        Shipment entity = shipmentService.findShipmentById(shipment.getId());
        ShipmentStatus shipmentStatus = shipmentStatusService.findShipmentStatusById(shipment.getShipmentStatus().getId());

        entity.setShipmentStatus(shipmentStatus);

        shipmentService.save(entity);
        return "redirect:/shipments/list";
    }
}
