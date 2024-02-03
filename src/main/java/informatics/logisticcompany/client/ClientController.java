package informatics.logisticcompany.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling client-related operations.
 * This class provides REST endpoints for managing clients within the system,
 * including operations for retrieving all clients and adding new clients.
 */
@Controller
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;


    /**
     * Autowires the ClientService to enable business operations related to clients.
     *
     * @param clientService The service layer for client operations, injected by Spring.
     */
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    /**
     * Retrieves all clients from the database.
     *
     * @return A list of all clients.
     */
    @GetMapping("/list")
    public String getAllClients(Model model) {
        List<Client> clients = clientService.getAllClients() ;
        model.addAttribute("client-list", clients);
        return "/clients/list-clients";
    }


    /**
     * Creates a new client and saves it to the database.
     *
     * @param client The client object to be created.
     * @return The created client with its generated ID.
     */
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }




    @PostMapping("/clients/create")
    public String createAllClient(Client client) {
        clientService.createClient(client);
        return "redirect:/clients/list"; // Redirect to the client list page after creating a client
    }


    @PostMapping("/update")
    public String saveClient(Client client) {
        clientService.createClient(client);
        return "redirect:/clients/list";
    }


    @DeleteMapping("/delete")
    public String deleteClient(@RequestParam("id") Long id) {
        clientService.deleteClientById(id);
        return "deleted";
    }

}
