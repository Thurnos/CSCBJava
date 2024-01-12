package informatics.logisticcompany.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryTypeService {
    private final DeliveryTypeRepository deliveryTypeRepository;

    @Autowired
    public DeliveryTypeService(DeliveryTypeRepository deliveryTypeRepository) {
        this.deliveryTypeRepository = deliveryTypeRepository;
    }

    public List<DeliveryType> getAllDeliveryTypes() {
        return deliveryTypeRepository.findAll();
    }

    public DeliveryType createDeliveryType(DeliveryType deliveryType) {
        return deliveryTypeRepository.save(deliveryType);
    }

    // Add other service methods as needed
}
