package informatics.logisticcompany.shipment_status_cataloc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentStatusCatalogService {
    private final ShipmentStatusCatalogRepository shipmentStatusCatalogRepository;

    @Autowired
    public ShipmentStatusCatalogService(ShipmentStatusCatalogRepository shipmentStatusCatalogRepository) {
        this.shipmentStatusCatalogRepository = shipmentStatusCatalogRepository;
    }

    public List<ShipmentStatusCatalog> getAllShipmentStatusCatalogs() {
        return shipmentStatusCatalogRepository.findAll();
    }

    public ShipmentStatusCatalog createShipmentStatusCatalog(ShipmentStatusCatalog shipmentStatusCatalog) {
        return shipmentStatusCatalogRepository.save(shipmentStatusCatalog);
    }
}