package informatics.logisticcompany.controller;

import informatics.logisticcompany.client.ClientService;
import informatics.logisticcompany.dto.client.ClientDTO;
import informatics.logisticcompany.dto.shipment.ShipmentDTO;
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


    @Autowired
    public RequestController(ClientService clientService, ShipmentService shipmentService) {
        this.clientService = clientService;
        this.shipmentService = shipmentService;
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
}
