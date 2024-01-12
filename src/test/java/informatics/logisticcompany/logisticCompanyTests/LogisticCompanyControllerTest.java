package informatics.logisticcompany.logisticCompanyTests;
import com.fasterxml.jackson.databind.ObjectMapper;
import informatics.logisticcompany.delivery.DeliveryTypeController;
import informatics.logisticcompany.logistic_companies.LogisticCompany;
import informatics.logisticcompany.logistic_companies.LogisticCompanyController;
import informatics.logisticcompany.logistic_companies.LogisticCompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import informatics.logisticcompany.delivery.DeliveryType;
import informatics.logisticcompany.delivery.DeliveryTypeRepository;
import informatics.logisticcompany.delivery.DeliveryTypeService;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@WebMvcTest(LogisticCompanyController.class)
public class LogisticCompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private LogisticCompanyService logisticCompanyService;

    @Test
    public void testCreateCompany() throws Exception {
        LogisticCompany newCompany = new LogisticCompany();
        newCompany.setName("Company X");
        newCompany.setAddress("123 Main St");
        newCompany.setFoundationDate(new Date());

        when(logisticCompanyService.createCompany(any(LogisticCompany.class))).thenReturn(newCompany);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/companies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newCompany)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.logistic_company_id").exists())
                .andExpect(jsonPath("$.logistic_company_name").value("Company X"))
                .andExpect(jsonPath("$.logistic_company_address").value("123 Main St"))
                .andExpect(jsonPath("$.logistic_company_foundation_date").exists());
    }
}

