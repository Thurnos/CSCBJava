package informatics.logisticcompany.employees;

import informatics.logisticcompany.dto.employee.EmployeeBasicInfoDTO;
import informatics.logisticcompany.dto.employee.EmployeeDTO;
import informatics.logisticcompany.dto.employee.UpdateEmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Service layer for handling business logic related to Employee entities.
 * This class provides methods to interact with the EmployeeRepository for CRUD operations
 * and any additional business processes related to employees.
 */
@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;


    /**
     * Constructs an EmployeeService with an injected EmployeeRepository.
     * @param employeesRepository The repository providing data access operations for employees.
     */
    @Autowired
    public EmployeeService(EmployeeRepository employeesRepository) {
        this.employeeRepository = employeesRepository;
    }


    /**
     * Retrieves all employees from the database.
     * @return A list of all Employee entities.
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Saves a new employee to the database.
     * This method handles the creation of an employee, including persisting the employee
     * entity and any associated operations that should occur upon a new employee's creation.
     *
     * @param employee The Employee entity to be saved.
     * @return The saved Employee entity, now with a generated ID.
     */
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<EmployeeBasicInfoDTO> getAllEmployeesWithBasicInfo() {
        return employeeRepository.findAllEmployeesWithBasicInfo();
    }

    public EmployeeBasicInfoDTO findEmployeeWithBasicInfoById(Long id) {
        return employeeRepository.findEmployeeWithBasicInfoById(id);
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<EmployeeDTO> getAllWithEmployeeDTO() {
        return employeeRepository.findAllWithEmployeeDTO();
    }

    public EmployeeDTO findByIdWIthEmployeeDTO(Long id) {
        return employeeRepository.findByIdWithEmployeeDTO(id);
    }
    public UpdateEmployeeDTO findByIdWithUpdateEmployeeDTO(Long id) { return employeeRepository.findByIdWithUpdateEmployeeDTO(id); }
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

}