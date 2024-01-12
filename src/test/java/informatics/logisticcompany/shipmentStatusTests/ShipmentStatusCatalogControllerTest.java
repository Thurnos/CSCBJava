package informatics.logisticcompany.shipmentStatusTests;

import informatics.logisticcompany.shipment_status_cataloc.ShipmentStatusCatalog;
import informatics.logisticcompany.shipment_status_cataloc.ShipmentStatusCatalogController;
import informatics.logisticcompany.shipment_status_cataloc.ShipmentStatusCatalogService;
import org.springframework.boot.test.context.SpringBootTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import informatics.logisticcompany.employees.Employee;
import informatics.logisticcompany.employees.EmployeeController;
import informatics.logisticcompany.employees.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@WebMvcTest(ShipmentStatusCatalogController.class)
public class ShipmentStatusCatalogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ShipmentStatusCatalogService shipmentStatusCatalogService;

    @Test
    public void testCreateShipmentStatusCatalog() throws Exception {
        ShipmentStatusCatalog newShipmentStatusCatalog = new ShipmentStatusCatalog();
        newShipmentStatusCatalog.setName("PENDING");

        when(shipmentStatusCatalogService.createShipmentStatusCatalog(any(ShipmentStatusCatalog.class)))
                .thenReturn(newShipmentStatusCatalog);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/shipment-status-catalogs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newShipmentStatusCatalog)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.shipment_status_catalog_id").exists())
                .andExpect(jsonPath("$.shipment_status_name").value("PENDING"));
    }
}

