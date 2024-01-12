package informatics.logisticcompany.shipment_status_cataloc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipment-status-catalogs")
public class ShipmentStatusCatalogController {
    private final ShipmentStatusCatalogService shipmentStatusCatalogService;

    @Autowired
    public ShipmentStatusCatalogController(ShipmentStatusCatalogService shipmentStatusCatalogService) {
        this.shipmentStatusCatalogService = shipmentStatusCatalogService;
    }

    @GetMapping
    public List<ShipmentStatusCatalog> getAllShipmentStatusCatalogs() {
        return shipmentStatusCatalogService.getAllShipmentStatusCatalogs();
    }

    @PostMapping
    public ShipmentStatusCatalog createShipmentStatusCatalog(@RequestBody ShipmentStatusCatalog shipmentStatusCatalog) {
        return shipmentStatusCatalogService.createShipmentStatusCatalog(shipmentStatusCatalog);
    }
}