package informatics.logisticcompany.client;
import informatics.logisticcompany.dto.client.ClientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT new informatics.logisticcompany.dto.client.ClientDTO(c.id, c.firstname, c.lastName, c.address, c.phoneNumber) FROM Client c")
    List<ClientDTO> findAllWithClientDTO();
}
