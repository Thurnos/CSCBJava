package informatics.logisticcompany.client;

import informatics.logisticcompany.dto.client.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;


    /**
     * Constructs a ClientService with the necessary ClientRepository.
     *
     * @param clientRepository The repository responsible for data operations of clients, injected by Spring.
     */
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Retrieves all clients from the repository.
     *
     * @return A List of all Client entities stored in the database.
     */
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    /**
     * Creates a new client by saving it to the repository.
     * This method ensures that the client information is persisted in the database.
     *
     * @param client The Client entity to be saved.
     * @return The saved Client entity, including any modifications made during the save process (e.g., generated ID).
     */
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public boolean deleteClientById(Long clientId) {
        Optional<Client> clientOptional = clientRepository.findById(clientId);

        if (clientOptional.isPresent()) {
            clientRepository.deleteById(clientId);
            return true;
        }

        return false;
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }


    public void deleteClient(Long id) {clientRepository.deleteById(id);}

    public List<ClientDTO> getAllClientsWithClientDTO() {return clientRepository.findAllWithClientDTO();}

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    public void updateClient(Long id, Client updatedClient) {
        // Assuming ClientRepository has a method to save the updated client
        clientRepository.save(updatedClient);
    }

    public Client getClientById(Long id){return clientRepository.findClientById(id);}
}
