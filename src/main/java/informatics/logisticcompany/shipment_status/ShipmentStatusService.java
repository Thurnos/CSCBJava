package informatics.logisticcompany.shipment_status;

import informatics.logisticcompany.dto.shipment_status.ShipmentStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentStatusService {

    private final ShipmentStatusRepository shipmentStatusRepository;

    @Autowired
    public ShipmentStatusService(ShipmentStatusRepository shipmentStatusRepository) {
        this.shipmentStatusRepository = shipmentStatusRepository;
    }

    public List<ShipmentStatusDTO> getAllWithShipmentStatusDTO() {
        return shipmentStatusRepository.findAllWithShipmentStatusDTO();
    }

    public ShipmentStatus findShipmentStatusById(Long id){
        return shipmentStatusRepository.findShipmentStatusById(id);
    }
}
