package informatics.logisticcompany.shipment;

import informatics.logisticcompany.dto.shipment.ShipmentDTO;
import informatics.logisticcompany.dto.shipment.ShipmentStatusDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    @Query("SELECT new informatics.logisticcompany.dto.shipment.ShipmentDTO(s.id, s.uuid, s.destination, s.weight, s.created, s.total, s.sender.firstname, s.recipient.firstname, s.registeredBy.firstName, s.deliveryType.name, s.shipmentStatus.shipmentStatus.name, s.logisticCompany.name, s.pricingTier.id) FROM Shipment s")
    List<ShipmentDTO> findAllShipmentsWithShipmentDTO();

    @Query("SELECT new informatics.logisticcompany.dto.shipment.ShipmentDTO(s.id, s.uuid, s.destination, s.weight, s.created, s.total, s.sender.firstname, s.recipient.firstname, s.registeredBy.firstName, s.deliveryType.name, s.shipmentStatus.shipmentStatus.name, s.logisticCompany.name, s.pricingTier.id) FROM Shipment s WHERE s.id = :id")
    ShipmentDTO findByIdWithShipmentDTO(Long id);

    @Query("SELECT new informatics.logisticcompany.dto.shipment.ShipmentStatusDTO(s.id, s.sender.firstname, s.recipient.firstname, s.shipmentStatus) FROM Shipment s WHERE s.id = :id")
    ShipmentStatusDTO findShipmentWithShipmentStatusDTO(Long id);

    @Query("SELECT new informatics.logisticcompany.dto.shipment.ShipmentDTO(s.id, s.uuid, s.destination, s.weight, s.created, s.total, s.sender.firstname, s.recipient.firstname, s.registeredBy.firstName, s.deliveryType.name, s.shipmentStatus.shipmentStatus.name, s.logisticCompany.name, s.pricingTier.id) FROM Shipment s WHERE s.sender.id = :id OR s.recipient.id = :id")
    List<ShipmentDTO> findBySenderOrRecipient(Long id);

    @Query("SELECT new informatics.logisticcompany.dto.shipment.ShipmentDTO(s.id, s.uuid, s.destination, s.weight, s.created, s.total, s.sender.firstname, s.recipient.firstname, s.registeredBy.firstName, s.deliveryType.name, s.shipmentStatus.shipmentStatus.name, s.logisticCompany.name, s.pricingTier.id) FROM Shipment s WHERE s.sender.id = :id")
    List<ShipmentDTO> findBySenderId(Long id);

    @Query("SELECT new informatics.logisticcompany.dto.shipment.ShipmentDTO(s.id, s.uuid, s.destination, s.weight, s.created, s.total, s.sender.firstname, s.recipient.firstname, s.registeredBy.firstName, s.deliveryType.name, s.shipmentStatus.shipmentStatus.name, s.logisticCompany.name, s.pricingTier.id) FROM Shipment s WHERE s.recipient.id = :id")
    List<ShipmentDTO> findByRecipientId(Long id);
}
