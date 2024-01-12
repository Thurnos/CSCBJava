package informatics.logisticcompany.deliveryTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import informatics.logisticcompany.delivery.DeliveryTypeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import informatics.logisticcompany.delivery.DeliveryType;
import informatics.logisticcompany.delivery.DeliveryTypeRepository;
import informatics.logisticcompany.delivery.DeliveryTypeService;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DeliveryTypeController.class)
@AutoConfigureMockMvc
public class DeliveryTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeliveryTypeService deliveryTypeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DeliveryTypeRepository deliveryTypeRepository;

    @Test
    public void testCreateDeliveryType() throws Exception {
        DeliveryType deliveryType = new DeliveryType();
        deliveryType.setName("Standard");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/delivery-types")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(deliveryType)))
                .andExpect(status().isOk());

        // Verify that the deliveryType is saved in the database
        DeliveryType savedDeliveryType = deliveryTypeRepository.findByName("Standard");
        assertNotNull(savedDeliveryType);
        assertEquals("Standard", savedDeliveryType.getName());

        // Access the ID of the saved entity
        int savedId = savedDeliveryType.getId();
        assertNotNull(savedId);
    }

    // Add more tests for other controller methods if needed
}
