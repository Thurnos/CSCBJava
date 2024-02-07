package informatics.logisticcompany.controller;

import informatics.logisticcompany.client.ClientService;
import informatics.logisticcompany.dto.client.ClientDTO;
import informatics.logisticcompany.dto.employee.EmployeeBasicInfoDTO;
import informatics.logisticcompany.dto.logistic_companies.LogisticCompanyDTO;
import informatics.logisticcompany.dto.shipment.ShipmentDTO;
import informatics.logisticcompany.employees.EmployeeBasicInfoProjection;
import informatics.logisticcompany.employees.EmployeeService;
import informatics.logisticcompany.logistic_companies.LogisticCompanyService;
import informatics.logisticcompany.shipment.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/requests")
public class RequestController {

    private ClientService clientService;
    private ShipmentService shipmentService;
    private LogisticCompanyService logisticCompanyService;
    private EmployeeService employeeService;

    @Autowired
    public RequestController(ClientService clientService, ShipmentService shipmentService, LogisticCompanyService logisticCompanyService, EmployeeService employeeService) {
        this.clientService = clientService;
        this.shipmentService = shipmentService;
        this.logisticCompanyService = logisticCompanyService;
        this.employeeService = employeeService;
    }

    @GetMapping("/sent-by-client")
    public String sendByClient(Model model) {

        List<ClientDTO> clientDTOList = clientService.getAllClientsWithClientDTO();
        model.addAttribute("clientList", clientDTOList);

        return "/request/send-by-client";
    }

    @PostMapping("/getShipmentsByClient")
    public String getShipments(@RequestParam Long clientId, Model model) {
        List<ClientDTO> clientDTOList = clientService.getAllClientsWithClientDTO();
        List<ShipmentDTO> shipmentDTOList = shipmentService.getAllBySenderId(clientId);

        model.addAttribute("clientList", clientDTOList);
        model.addAttribute("shipments", shipmentDTOList);

        return "/request/send-by-client";
    }

    @GetMapping("/received-by-client")
    public String receivedBy(Model model) {

        List<ClientDTO> clientDTOList = clientService.getAllClientsWithClientDTO();
        model.addAttribute("clientList", clientDTOList);

        return "/request/received-by-client";
    }

    @PostMapping("/getShipmentsByClientReceived")
    public String getShipmentsReceivedBy(@RequestParam Long clientId, Model model) {
        List<ClientDTO> clientDTOList = clientService.getAllClientsWithClientDTO();
        List<ShipmentDTO> shipmentDTOList = shipmentService.getAllByRecipientId(clientId);

        model.addAttribute("clientList", clientDTOList);
        model.addAttribute("shipments", shipmentDTOList);

        return "/request/received-by-client";
    }

    @GetMapping("/employees-by-company")
    public String showEmployeesByCompanyPage(Model model) {
        List<LogisticCompanyDTO> logisticCompanyDTOList = logisticCompanyService.getAllWithLogisticCompanyDTO();
        model.addAttribute("companyList", logisticCompanyDTOList);

        return "/request/employees-by-company";
    }

    @PostMapping("/employees-by-company")
    public String getEmployeesByCompany(@RequestParam("companyId") Long companyId, Model model) {

        List<LogisticCompanyDTO> logisticCompanyDTOList = logisticCompanyService.getAllWithLogisticCompanyDTO();
        List<EmployeeBasicInfoDTO> employeeBasicInfoProjections = employeeService.findEmployeesByCompanyId(companyId);

        model.addAttribute("companyList", logisticCompanyDTOList);
        model.addAttribute("employeeList", employeeBasicInfoProjections);

        return "/request/employees-by-company";

    }

    @GetMapping("/sent-but-not-received")
    public String showSendButNotReceivedPage(Model model) {

        List<ShipmentDTO> shipmentDTOList = shipmentService.findShipmentsNotDelivered();
        model.addAttribute("shipmentList", shipmentDTOList);

        return "/request/sent-but-not-received";
    }
}
