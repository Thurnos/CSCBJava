package informatics.logisticcompany.logistic_companies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogisticCompanyService {
    private final LogisticCompanyRepository logisticCompanyRepository;

    @Autowired
    public LogisticCompanyService(LogisticCompanyRepository logisticCompanyRepository) {
        this.logisticCompanyRepository = logisticCompanyRepository;
    }

    public List<LogisticCompany> getAllCompanies() {
        return logisticCompanyRepository.findAll();
    }

    public LogisticCompany createCompany(LogisticCompany company) {
        return logisticCompanyRepository.save(company);
    }
}
