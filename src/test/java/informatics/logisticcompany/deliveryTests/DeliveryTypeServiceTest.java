package informatics.logisticcompany.deliveryTests;

import informatics.logisticcompany.delivery.DeliveryType;
import informatics.logisticcompany.delivery.DeliveryTypeRepository;
import informatics.logisticcompany.delivery.DeliveryTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@DataJpaTest
public class DeliveryTypeServiceTest {

    @Autowired
    private DeliveryTypeRepository deliveryTypeRepository;

    @Autowired
    private DeliveryTypeService deliveryTypeService;

    @Test
    public void testCreateDeliveryType() {
        DeliveryType deliveryType = new DeliveryType();
        deliveryType.setName("Express");

        // Create and save the deliveryType
        DeliveryType savedDeliveryType = deliveryTypeService.createDeliveryType(deliveryType);

        assertNotNull(savedDeliveryType);
        assertNotNull(savedDeliveryType.getId());
        assertEquals("Express", savedDeliveryType.getName());

        // Access the ID of the saved entity
        int savedId = savedDeliveryType.getId();
        assertNotNull(savedId);
    }

    // Add more tests for other service methods if needed
}

