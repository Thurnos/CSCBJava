package informatics.logisticcompany.logistic_companies;

import informatics.logisticcompany.dto.logistic_companies.LogisticCompanyDTO;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/**
 * Controller for managing logistic company operations.
 * This class handles web requests related to logistic companies, providing functionalities
 * for listing, creating, and saving logistic companies via a web interface.
 */
@Controller
@RequestMapping("/logistic-companies")
public class LogisticCompanyController {
    private final LogisticCompanyService logisticCompanyService;

    private final ModelMapper modelMapper;

    /**
     * Constructs the LogisticCompanyController with necessary dependencies.
     *
     * @param logisticCompanyService Service layer for logistic company operations.
     * @param modelMapper            ModelMapper for converting between entity and DTO classes.
     */
    public LogisticCompanyController(LogisticCompanyService logisticCompanyService, ModelMapper modelMapper) {
        this.logisticCompanyService = logisticCompanyService;
        this.modelMapper = modelMapper;
    }


    /**
     * Displays a list of all logistic companies.
     *
     * @param model Model to add attributes to the view, enabling data access.
     * @return The view name to render the list of logistic companies.
     */
    @GetMapping("/list")
    public String getAllCompanies(Model model) {

        List<LogisticCompanyDTO> logisticCompanyDTOList = logisticCompanyService.getAllCompanies();

        model.addAttribute("companies", logisticCompanyDTOList);

        return "logistic-companies/list-logistic-companies";
    }


    /**
     * Shows the form for creating a new logistic company.
     *
     * @param model Model to pass an empty LogisticCompany object to the form.
     * @return The view name to render the creation form.
     */
    @GetMapping("/create")
    public String showCreateForm(Model model) {

        LogisticCompany logisticCompany = new LogisticCompany();

        model.addAttribute("logisticCompany", logisticCompany);

        return "/logistic-companies/create-logistic-companies";
    }


    /**
     * Processes the submission of the logistic company creation form.
     *
     * @param logisticCompany The LogisticCompany entity populated from the form submission.
     * @return Redirects to the list of logistic companies upon successful creation.
     */
    @PostMapping("/save")
    public String saveLogisticCompany(@ModelAttribute("logisticCompany") LogisticCompany logisticCompany) {
        logisticCompanyService.createCompany(logisticCompany);

        return "redirect:/logistic-companies/list";
    }

//    @PostMapping("/create")
//    public LogisticCompany createCompany(@RequestBody LogisticCompany company) {
//        return logisticCompanyService.createCompany(company);
//    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteLogisticCompany(@RequestParam("id") Long id) {
        logisticCompanyService.deleteCompany(id);
        return ResponseEntity.ok("Logistic Company with ID " + id + " has been deleted.");
    }




}