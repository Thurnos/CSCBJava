package informatics.logisticcompany.roleTests;
import com.fasterxml.jackson.databind.ObjectMapper;
import informatics.logisticcompany.delivery.DeliveryTypeController;
import informatics.logisticcompany.roles.Role;
import informatics.logisticcompany.roles.RoleController;
import informatics.logisticcompany.roles.RoleService;
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
@WebMvcTest(RoleController.class)
public class RoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RoleService roleService;

    @Test
    public void testCreateRole() throws Exception {
        Role newRole = new Role();
        newRole.setName("Admin");

        when(roleService.createRole(any(Role.class))).thenReturn(newRole);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/roles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newRole)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.role_id").exists())
                .andExpect(jsonPath("$.role_name").value("Admin"));
    }
}
