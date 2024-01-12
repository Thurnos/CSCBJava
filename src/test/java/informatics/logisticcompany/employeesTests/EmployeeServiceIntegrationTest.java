package informatics.logisticcompany.employeesTests;

import informatics.logisticcompany.employees.Employee;
import informatics.logisticcompany.employees.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class EmployeeServiceIntegrationTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testCreateAndGetEmployee() {
        // Create a new employee
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("Bob");
        newEmployee.setLastName("Johnson");
        newEmployee.setBirthDate(new Date());
        newEmployee.setLogisticCompanyId(1L);
        newEmployee.setOfficeBranchId(2L);
        newEmployee.setPosition(3);

        // Save the employee to the database
        Employee savedEmployee = employeeService.createEmployee(newEmployee);

        // Retrieve the employee from the database
        List<Employee> allEmployees = employeeService.getAllEmployees();

        // Check if the saved employee is present in the list
        assertNotNull(savedEmployee);
        assertEquals(1, allEmployees.size());
        assertEquals("Bob", savedEmployee.getFirstName());
        assertEquals("Johnson", savedEmployee.getLastName());
        // Add more assertions based on your entity structure
    }
}
