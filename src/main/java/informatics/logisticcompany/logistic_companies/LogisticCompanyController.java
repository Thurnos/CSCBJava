package informatics.logisticcompany.logistic_companies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class LogisticCompanyController {
    private final LogisticCompanyService logisticCompanyService;

    @Autowired
    public LogisticCompanyController(LogisticCompanyService logisticCompanyService) {
        this.logisticCompanyService = logisticCompanyService;
    }

    @GetMapping
    public List<LogisticCompany> getAllCompanies() {
        return logisticCompanyService.getAllCompanies();
    }

    @PostMapping
    public LogisticCompany createCompany(@RequestBody LogisticCompany company) {
        return logisticCompanyService.createCompany(company);
    }
}