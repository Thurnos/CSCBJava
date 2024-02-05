package informatics.logisticcompany.shipment_status;

import informatics.logisticcompany.dto.shipment_status.ShipmentStatusDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentStatusRepository extends JpaRepository<ShipmentStatus, Long> {

    @Query("SELECT new informatics.logisticcompany.dto.shipment_status.ShipmentStatusDTO(s.id, s.lastUpdated, s.notes, s.shipmentStatus.name) FROM ShipmentStatus s")
    List<ShipmentStatusDTO> findAllWithShipmentStatusDTO();
}
