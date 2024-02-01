package informatics.logisticcompany.employees;

import informatics.logisticcompany.dto.employee.EmployeeBasicInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


/**
 * Controller for handling requests related to employee operations.
 * This class provides endpoints for CRUD operations on employees,
 * leveraging the EmployeeService to interact with the data layer.
 */
@Controller
@RequestMapping("/employees")
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

    @GetMapping("/list")
    public String getAllEmployees(Model model) {
        List<EmployeeBasicInfoDTO> employees = employeeService.getAllEmployeesWithBasicInfo();

        model.addAttribute("employees", employees);

        return "/employee/list-employees";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") Long id, Model model) {
        EmployeeBasicInfoDTO employee = employeeService.findEmployeeWithBasicInfoById(id);
        model.addAttribute("employee", employee);
        return "/employee/edit-employee";
    }

    @PostMapping("/update")
    public String saveEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "/employee/create-employee";
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees/list";
    }

}