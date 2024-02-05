package informatics.logisticcompany.client;
import informatics.logisticcompany.dto.client.ClientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query("SELECT u.userId, u.username, u.email, c.clientFirstName, c.clientLastName, c.clientAddress, c.clientPhoneNumber, lc.logisticCompanyName " +
            "FROM Client c " +
            "JOIN User u ON c.user.userId = u.userId " +
            "JOIN LogisticCompany lc ON c.logisticCompany.logisticCompanyId = lc.logisticCompanyId " +
            "WHERE lc.logisticCompanyName = :companyName")
    List<Object[]> findClientsByLogisticCompanyName(@Param("companyName") String companyName);

}
