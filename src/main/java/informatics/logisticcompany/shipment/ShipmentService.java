package informatics.logisticcompany.shipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    /**
     * Retrieves all shipments from the repository.
     *
     * @return A List of all Shipment entities stored in the database.
     */
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    /**
     * Creates a new shipment by saving it to the repository.
     *
     * @param shipment The Shipment entity to be saved.
     * @return The saved Shipment entity, including any modifications made during the save process (e.g., generated ID).
     */
    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    /**
     * Finds a shipment by its ID.
     *
     * @param shipmentId The ID of the shipment to find.
     * @return The Shipment entity with the specified ID, or null if not found.
     */
    public Shipment findShipmentById(Long shipmentId) {
        return shipmentRepository.findById(shipmentId).orElse(null);
    }

    /**
     * Updates an existing shipment.
     *
     * @param updatedShipment The updated shipment information.
     * @return The updated Shipment entity.
     */
    public Shipment updateShipment(Shipment updatedShipment) {
        return shipmentRepository.save(updatedShipment);
    }

    /**
     * Deletes a shipment by its ID.
     *
     * @param shipmentId The ID of the shipment to delete.
     */
    public void deleteShipment(Long shipmentId) {
        shipmentRepository.deleteById(shipmentId);
    }
}
