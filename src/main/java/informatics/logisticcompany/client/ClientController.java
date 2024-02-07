package informatics.logisticcompany.client;

import informatics.logisticcompany.dto.logistic_companies.LogisticCompanyDTO;
import informatics.logisticcompany.logistic_companies.LogisticCompany;
import informatics.logisticcompany.logistic_companies.LogisticCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for handling client-related operations.
 * This class provides REST endpoints for managing clients within the system,
 * including operations for retrieving all clients and adding new clients.
 */
@Controller
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    private final LogisticCompanyService logisticCompanyService;

    /**
     * Autowires the ClientService to enable business operations related to clients.
     *
     * @param clientService The service layer for client operations, injected by Spring.
     */
    @Autowired
    public ClientController(ClientService clientService, LogisticCompanyService logisticCompanyService) {
        this.clientService = clientService;
        this.logisticCompanyService = logisticCompanyService;
    }

    /**
     * Retrieves all clients from the database.
     *
     * @return A list of all clients.
     */
    @GetMapping("/list")
    public String getAllClients(Model model) {
        List<Client> clients = clientService.getAllClients() ;
        model.addAttribute("clientList", clients);
        return "/client/list-clients";
    }


    /**
     * Creates a new client and saves it to the database.
     *
     * @param client The client object to be created.
     * @return The created client with its generated ID.
     */

    @PostMapping("/create")
    public String createClient(@ModelAttribute Client client) {
        LogisticCompany logisticCompany = logisticCompanyService.getLogisticCompanyById(client.getLogisticCompany().getId());
        client.setLogisticCompany(logisticCompany);
        clientService.createClient(client);
        return "redirect:/clients/list";
    }



    @GetMapping("/create")
    public String showCreateClientForm(Model model) {
        model.addAttribute("client", new Client());
        List<LogisticCompanyDTO> listCompanies = logisticCompanyService.getAllWithLogisticCompanyDTO();
        model.addAttribute("companyList",listCompanies);
        return "client/create-client";
    }





    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
        return "redirect:/clients/list";
    }

    @GetMapping("/edit/{id}")
    public String editClient(@PathVariable Long id, Model model) {
        Optional<Client> clientOptional = clientService.findById(id);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            model.addAttribute("client", client);
            return "client/edit-clients";
        } else {
            // Handle case where client with given id is not found
            return "error"; // Redirect to error page or return appropriate response
        }
    }

    @PostMapping("/edit")
    public String saveClient(@ModelAttribute Client updatedClient) {
        Client client = clientService.getClientById(updatedClient.getId());
        client.setFirstname(updatedClient.getFirstname());
        client.setLastName(updatedClient.getLastName());
        client.setAddress(updatedClient.getAddress());
        client.setPhoneNumber(updatedClient.getPhoneNumber());

        clientService.saveClient(client);
        return "redirect:/clients/list"; // Redirect to client list page after editing
    }

}
