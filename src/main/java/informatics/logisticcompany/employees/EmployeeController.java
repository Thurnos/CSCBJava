package informatics.logisticcompany.employees;

import informatics.logisticcompany.dto.employee.EmployeeBasicInfoDTO;
import informatics.logisticcompany.dto.employee.EmployeeDTO;
import informatics.logisticcompany.dto.employee.UpdateEmployeeDTO;
import informatics.logisticcompany.dto.logistic_companies.LogisticCompanyDTO;
import informatics.logisticcompany.dto.office_branch.OfficeBranchDTO;
import informatics.logisticcompany.dto.position.PositionDTO;
import informatics.logisticcompany.logistic_companies.LogisticCompanyService;
import informatics.logisticcompany.mapper.EmployeeMapper;
import informatics.logisticcompany.office_branches.OfficeBranchService;
import informatics.logisticcompany.possitions_catalog.PositionCatalogService;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private final LogisticCompanyService logisticCompanyService;
    private final OfficeBranchService officeBranchService;
    private final PositionCatalogService positionCatalogService;
    private final EmployeeMapper employeeMapper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     * Constructor for dependency injection of the EmployeeService.
     * @param employeeService The service handling business logic for employee operations.
     */
    @Autowired
    public EmployeeController(EmployeeService employeeService, LogisticCompanyService logisticCompanyService, OfficeBranchService officeBranchService, PositionCatalogService positionCatalogService, EmployeeMapper employeeMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.employeeService = employeeService;
        this.logisticCompanyService = logisticCompanyService;
        this.officeBranchService = officeBranchService;
        this.positionCatalogService = positionCatalogService;
        this.employeeMapper = employeeMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
        List<EmployeeDTO> employees = employeeService.getAllWithEmployeeDTO();

        model.addAttribute("employeeList", employees);

        return "/employee/list-employees";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") Long id, Model model) {

        EmployeeDTO employeeDTO = employeeService.findByIdWIthEmployeeDTO(id);
        List<LogisticCompanyDTO> logisticCompanyDTOList = logisticCompanyService.getAllWithLogisticCompanyDTO();
        List<OfficeBranchDTO> officeBranchDTOList = officeBranchService.getAllWithOfficeBranchDTO();
        List<PositionDTO> positionDTOList = positionCatalogService.getAllWithPositionDTO();

        model.addAttribute("employee", employeeDTO);
        model.addAttribute("logisticCompanies", logisticCompanyDTOList);
        model.addAttribute("officeBranches", officeBranchDTOList);
        model.addAttribute("positionCatalog", positionDTOList);

        return "/employee/edit-employee";
    }

    @PostMapping("/edit")
    public String saveEmployee(@ModelAttribute UpdateEmployeeDTO updateEmployeeDTO) {

        //TODO Employee
        Employee employee = employeeService.findEmployeeById(updateEmployeeDTO.getId());
        employee.setFirstName(updateEmployeeDTO.getFirstName());
        employee.setFirstName(updateEmployeeDTO.getLastName());
        employee.setBirthDate(updateEmployeeDTO.getBirthDate());
        employee.setLogisticCompany(updateEmployeeDTO.getLogisticCompany());
        employee.setOfficeBranch(updateEmployeeDTO.getOfficeBranch());
        employee.setPosition(updateEmployeeDTO.getPosition());

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

        List<LogisticCompanyDTO> logisticCompanyDTOList = logisticCompanyService.getAllWithLogisticCompanyDTO();
        List<OfficeBranchDTO> officeBranchDTOList = officeBranchService.getAllWithOfficeBranchDTO();
        List<PositionDTO> positionDTOList = positionCatalogService.getAllWithPositionDTO();

        model.addAttribute("logisticCompanies", logisticCompanyDTOList);
        model.addAttribute("officeBranches", officeBranchDTOList);
        model.addAttribute("positionCatalog", positionDTOList);

        return "/employee/create-employee";
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute("employee") Employee employee) {

        String password = bCryptPasswordEncoder.encode(employee.getPassword());
        employee.setPassword(password);

        employeeService.saveEmployee(employee);
        return "redirect:/employees/list";
    }

}