package informatics.logisticcompany.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controller for handling requests related to employee operations.
 * This class provides endpoints for CRUD operations on employees,
 * leveraging the EmployeeService to interact with the data layer.
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;


    /**
     * Constructor for dependency injection of the EmployeeService.
     * @param employeeService The service handling business logic for employee operations.
     */
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    /**
     * Retrieves a list of all employees.
     * @return A list of Employee objects representing all employees in the database.
     */
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }


    /**
     * Creates a new employee and saves it to the database.
     * @param employee The Employee object to be created, parsed from the request body.
     * @return The created Employee object, including its generated ID and any defaults or changes made during persistence.
     */
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    // Add other controller methods as needed
}