package informatics.logisticcompany.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling client-related operations.
 * This class provides REST endpoints for managing clients within the system,
 * including operations for retrieving all clients and adding new clients.
 */
@RestController
@RequestMapping("/api/clients")
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
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
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

    // Add other controller methods as needed
}
