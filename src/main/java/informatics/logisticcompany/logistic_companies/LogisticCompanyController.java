package informatics.logisticcompany.logistic_companies;

import informatics.logisticcompany.dto.logistic_companies.LogisticCompanyDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/logistic-companies")
public class LogisticCompanyController {
    private final LogisticCompanyService logisticCompanyService;
    private final ModelMapper modelMapper;

    public LogisticCompanyController(LogisticCompanyService logisticCompanyService, ModelMapper modelMapper) {
        this.logisticCompanyService = logisticCompanyService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/list")
    public String getAllCompanies(Model model) {

        List<LogisticCompanyDTO> logisticCompanyDTOList = logisticCompanyService.getAllCompanies();

        model.addAttribute("companies", logisticCompanyDTOList);

        return "logistic-companies/list-logistic-companies";
    }

    @GetMapping("/create")
    public String createLogisticCompany(Model mode) {

        LogisticCompany logisticCompany = new LogisticCompany();

        mode.addAttribute("logisticCompany", logisticCompany);

        return "/logistic-companies/create-logistic-companies";
    }

//    @PostMapping("/create")
//    public LogisticCompany createCompany(@RequestBody LogisticCompany company) {
//        return logisticCompanyService.createCompany(company);
//    }
}