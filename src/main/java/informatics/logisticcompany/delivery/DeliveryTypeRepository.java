package informatics.logisticcompany.delivery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryTypeRepository extends JpaRepository<DeliveryType, Long> {

    /**
     * Finds a delivery type by its name.
     *
     * @param name The name of the delivery type to find.
     * @return The DeliveryType entity if found, or null otherwise.
     */
    DeliveryType findByName(String name);
}
