package informatics.logisticcompany.userTests;


import com.fasterxml.jackson.core.type.TypeReference;
import informatics.logisticcompany.users.User;
import informatics.logisticcompany.users.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() throws Exception {
        // Given
        User user = new User();
        user.setUsername("testUser");
        user.setEmail("test@example.com");
        user.setPassword("testPassword");

        // When
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
                        .content("{ \"username\": \"testUser\", \"email\": \"test@example.com\", \"password\": \"testPassword\" }")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Then
        assertThat(result.getResponse().getContentAsString()).isEqualToIgnoringWhitespace("{\"username\":\"testUser\",\"email\":\"test@example.com\",\"password\":\"testPassword\",\"enabled\":false}");
    }

    @Test
    public void testGetAllUsers() throws Exception {


        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Then
        String responseJson = result.getResponse().getContentAsString();
        List<User> users = objectMapper.readValue(responseJson, new TypeReference<List<User>>() {
        });

        assertThat(users).hasSize(5); // Adjust the size based on the number of users you expect
        assertThat(users).extracting(User::getUsername).contains("testUser1", "testUser2");
    }
}
