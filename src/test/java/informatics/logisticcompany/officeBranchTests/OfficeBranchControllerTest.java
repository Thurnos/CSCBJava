package informatics.logisticcompany.officeBranchTests;
import com.fasterxml.jackson.databind.ObjectMapper;
import informatics.logisticcompany.delivery.DeliveryTypeController;
import informatics.logisticcompany.office_branches.OfficeBranch;
import informatics.logisticcompany.office_branches.OfficeBranchController;
import informatics.logisticcompany.office_branches.OfficeBranchService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@WebMvcTest(OfficeBranchController.class)
public class OfficeBranchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private OfficeBranchService officeBranchService;

    @Test
    public void testCreateOfficeBranch() throws Exception {
        OfficeBranch newOfficeBranch = new OfficeBranch();
        // Set the attributes of the newOfficeBranch object

        when(officeBranchService.createOfficeBranch(any(OfficeBranch.class)))
                .thenReturn(newOfficeBranch);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/office-branches")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newOfficeBranch)))
                .andExpect(status().isOk())
                // Add additional assertions based on your object structure
                .andExpect(jsonPath("$.office_branch_id").exists())
                .andExpect(jsonPath("$.office_branch_name").value(newOfficeBranch.getName()))
                .andExpect(jsonPath("$.office_branch_address").value(newOfficeBranch.getAddress()))
                .andExpect(jsonPath("$.logistic_company_id").value(newOfficeBranch.getLogisticCompany().getId()));
    }
}
