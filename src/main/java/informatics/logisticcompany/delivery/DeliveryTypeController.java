package informatics.logisticcompany.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery-types")
public class DeliveryTypeController {
    private final DeliveryTypeService deliveryTypeService;

    @Autowired
    public DeliveryTypeController(DeliveryTypeService deliveryTypeService) {
        this.deliveryTypeService = deliveryTypeService;
    }

    @GetMapping
    public List<DeliveryType> getAllDeliveryTypes() {
        return deliveryTypeService.getAllDeliveryTypes();
    }

    @PostMapping
    public DeliveryType createDeliveryType(@RequestBody DeliveryType deliveryType) {
        return deliveryTypeService.createDeliveryType(deliveryType);
    }

    // Add other controller methods as needed
}
