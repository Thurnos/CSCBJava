package informatics.logisticcompany.clientTests;


import informatics.logisticcompany.client.Client;
import informatics.logisticcompany.client.ClientRepository;
import informatics.logisticcompany.client.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@DataJpaTest
public class ClientServiceTest {

    @Autowired
    private ClientRepository clientRepository;

    @MockBean
    private ClientService clientService;

    @Test
    public void testGetAllClients() {
        Client client1 = new Client();
        client1.setId(1);
        client1.setFirstName("John");
        client1.setLastName("Doe");

        Client client2 = new Client();
        client2.setId(2);
        client2.setFirstName("Jane");
        client2.setLastName("Smith");

        when(clientService.getAllClients()).thenReturn(Arrays.asList(client1, client2));

        List<Client> clients = clientService.getAllClients();

        assertEquals(2, clients.size());
        assertEquals("John", clients.get(0).getFirstName());
        assertEquals("Jane", clients.get(1).getFirstName());
    }

    // Add more tests for other service methods if needed
}

