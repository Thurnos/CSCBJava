package informatics.logisticcompany.shipment_status_cataloc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentStatusCatalogRepository extends JpaRepository<ShipmentStatusCatalog, Long> {
    // additional custom queries can be added here
}
