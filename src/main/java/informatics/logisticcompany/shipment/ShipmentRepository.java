package informatics.logisticcompany.shipment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

//    public List<Shipment> findAllByRecipientLike();
}
