package informatics.logisticcompany.employeesTests;

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

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllEmployees() throws Exception {
        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setFirstName("John");
        employee1.setLastName("Doe");

        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setFirstName("Jane");
        employee2.setLastName("Smith");

        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(employee1, employee2));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Doe"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].firstName").value("Jane"))
                .andExpect(jsonPath("$[1].lastName").value("Smith"));
    }

    @Test
    public void testCreateEmployee() throws Exception {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("Alice");
        newEmployee.setLastName("Johnson");
        newEmployee.setBirthDate(new Date());
        newEmployee.setLogisticCompanyId(1L);
        newEmployee.setOfficeBranchId(2L);
        newEmployee.setPosition(3);

        when(employeeService.createEmployee(newEmployee)).thenReturn(newEmployee);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newEmployee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.users_user_id").exists())  // Assuming your Employee entity has a "users_user_id" field
                .andExpect(jsonPath("$.employee_first_name").value("Alice"))
                .andExpect(jsonPath("$.employee_last_name").value("Johnson"))
                .andExpect(jsonPath("$.employee_birth_date").exists())
                .andExpect(jsonPath("$.logistic_company_id").value(1))
                .andExpect(jsonPath("$.office_branch_id").value(2))
                .andExpect(jsonPath("$.employee_position").value(3));
    }

}
