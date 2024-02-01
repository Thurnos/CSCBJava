package informatics.logisticcompany.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * RestController for managing delivery types within the application.
 * This controller handles API requests for CRUD operations on delivery types,
 * leveraging the DeliveryTypeService for business logic execution.
 */
@RestController
@RequestMapping("/api/delivery-types")
public class DeliveryTypeController {
    private final DeliveryTypeService deliveryTypeService;


    /**
     * Autowired constructor for dependency injection of DeliveryTypeService.
     * Spring automatically injects the DeliveryTypeService instance at runtime.
     *
     * @param deliveryTypeService The service layer handling business logic for delivery types.
     */
    @Autowired
    public DeliveryTypeController(DeliveryTypeService deliveryTypeService) {
        this.deliveryTypeService = deliveryTypeService;
    }


    /**
     * Retrieves all delivery types from the database.
     * This method handles GET requests to /api/delivery-types and returns a list of all delivery types.
     *
     * @return A list of DeliveryType entities.
     */
    @GetMapping
    public List<DeliveryType> getAllDeliveryTypes() {
        return deliveryTypeService.getAllDeliveryTypes();
    }


    /**
     * Creates a new delivery type.
     * This method handles POST requests to /api/delivery-types, saving a new delivery type to the database.
     *
     * @param deliveryType The DeliveryType entity to be created.
     * @return The created DeliveryType entity.
     */
    @PostMapping
    public DeliveryType createDeliveryType(@RequestBody DeliveryType deliveryType) {
        return deliveryTypeService.createDeliveryType(deliveryType);
    }

}
