package informatics.logisticcompany.positionsCatalogTests;


import com.fasterxml.jackson.databind.ObjectMapper;
import informatics.logisticcompany.possitions_catalog.PositionCatalog;
import informatics.logisticcompany.possitions_catalog.PositionCatalogController;
import informatics.logisticcompany.possitions_catalog.PositionCatalogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@WebMvcTest(PositionCatalogController.class)
public class PositionCatalogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PositionCatalogService positionCatalogService;

    @Test
    public void testCreatePosition() throws Exception {
        PositionCatalog newPosition = new PositionCatalog();
        newPosition.setName("Manager");

        when(positionCatalogService.createPosition(any(PositionCatalog.class))).thenReturn(newPosition);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/positions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newPosition)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.position_catalog_id").exists())
                .andExpect(jsonPath("$.position_name").value("Manager"));
    }
}