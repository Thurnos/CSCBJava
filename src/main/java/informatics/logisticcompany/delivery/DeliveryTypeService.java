package informatics.logisticcompany.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing delivery types within the application.
 * This service provides methods for CRUD operations on delivery types,
 * leveraging the DeliveryTypeRepository for data access.
 */
@Service
public class DeliveryTypeService {
    private final DeliveryTypeRepository deliveryTypeRepository;


    /**
     * Constructs a DeliveryTypeService with a repository for delivery type operations.
     * The repository is injected by Spring's dependency injection mechanism.
     *
     * @param deliveryTypeRepository The repository used for accessing delivery type data.
     */
    @Autowired
    public DeliveryTypeService(DeliveryTypeRepository deliveryTypeRepository) {
        this.deliveryTypeRepository = deliveryTypeRepository;
    }


    /**
     * Retrieves all delivery types from the database.
     *
     * @return A list of all delivery types available in the database.
     */
    public List<DeliveryType> getAllDeliveryTypes() {
        return deliveryTypeRepository.findAll();
    }


    /**
     * Creates a new delivery type and saves it to the database.
     * This method persists a new delivery type entity using the repository.
     *
     * @param deliveryType The delivery type entity to be saved.
     * @return The saved delivery type entity, now including a generated ID and any other changes made during the save process.
     */
    public DeliveryType createDeliveryType(DeliveryType deliveryType) {
        return deliveryTypeRepository.save(deliveryType);
    }

    // Add other service methods as needed
}
