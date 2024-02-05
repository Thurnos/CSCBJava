package informatics.logisticcompany.delivery;

import informatics.logisticcompany.dto.delivery_type.DeliveryTypeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryTypeRepository extends JpaRepository<DeliveryType, Long> {

    /**
     * Finds a delivery type by its name.
     *
     * @param name The name of the delivery type to find.
     * @return The DeliveryType entity if found, or null otherwise.
     */
    DeliveryType findByName(String name);

    @Query("SELECT new informatics.logisticcompany.dto.delivery_type.DeliveryTypeDTO(d.id, d.name) FROM DeliveryType d")
    List<DeliveryTypeDTO> findAllWithDeliveryTypeDTO();
}
