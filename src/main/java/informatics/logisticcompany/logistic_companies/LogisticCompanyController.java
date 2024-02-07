package informatics.logisticcompany.logistic_companies;

import informatics.logisticcompany.dto.logistic_companies.LogisticCompanyDTO;
import informatics.logisticcompany.dto.logistic_companies.LogisticCompanyWithCostDTO;
import informatics.logisticcompany.mapper.LogisticCompanyMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    private final LogisticCompanyMapper logisticCompanyMapper;

    /**
     * Constructs the LogisticCompanyController with necessary dependencies.
     *
     * @param logisticCompanyService Service layer for logistic company operations.
     */
    public LogisticCompanyController(LogisticCompanyService logisticCompanyService, LogisticCompanyMapper logisticCompanyMapper) {
        this.logisticCompanyService = logisticCompanyService;
        this.logisticCompanyMapper = logisticCompanyMapper;
    }


    /**
     * Displays a list of all logistic companies.
     *
     * @param model Model to add attributes to the view, enabling data access.
     * @return The view name to render the list of logistic companies.
     */
    @GetMapping("/list")
    public String getAllCompanies(Model model) {

        List<LogisticCompanyDTO> logisticCompanyDTOList = logisticCompanyService.getAllWithLogisticCompanyDTO();

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

    @GetMapping("/logistic-companies/delivery-costs")
    public List<LogisticCompanyWithCostDTO> getLogisticCompanyDeliveryCostsBetween(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return logisticCompanyService.findLogisticCompanyDeliveryCostsBetween(startDate, endDate);
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        LogisticCompanyDTO logisticCompanyDTO = logisticCompanyService.findByIdWithLogisticCompanyDTO(id);
        model.addAttribute("logisticCompany", logisticCompanyDTO);

        return "/logistic-companies/edit-logistic-company";
    }

    @PostMapping("/edit")
    public String updateLogisticCompany(@ModelAttribute LogisticCompanyDTO logisticCompanyDTO) {
        LogisticCompany logisticCompany = logisticCompanyMapper.convertToEntity(logisticCompanyDTO);
        logisticCompanyService.saveCompany(logisticCompany);
        return "redirect:/logistic-companies/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteLogisticCompany(@PathVariable("id") Long id) {
        logisticCompanyService.deleteCompany(id);
        return "redirect:/logistic-companies/list";
    }

}