package informatics.logisticcompany.userRoleTests;
import com.fasterxml.jackson.databind.ObjectMapper;
import informatics.logisticcompany.delivery.DeliveryTypeController;
import informatics.logisticcompany.user_has_roles.UserRole;
import informatics.logisticcompany.user_has_roles.UserRoleController;
import informatics.logisticcompany.user_has_roles.UserRoleService;
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
@WebMvcTest(UserRoleController.class)
public class UserRoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserRoleService userRoleService;

    @Test
    public void testCreateUserRole() throws Exception {
        UserRole newUserRole = new UserRole();
        // Set the user and role objects accordingly

        when(userRoleService.createUserRole(any(UserRole.class)))
                .thenReturn(newUserRole);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/user-roles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUserRole)))
                .andExpect(status().isOk())
                // Add additional assertions based on your object structure
                .andExpect(jsonPath("$.users_user_id").exists())
                .andExpect(jsonPath("$.roles_role_id").exists());
    }
}