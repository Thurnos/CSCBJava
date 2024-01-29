package informatics.logisticcompany.logistic_companies;

import informatics.logisticcompany.dto.logistic_companies.LogisticCompanyDTO;
import informatics.logisticcompany.mapper.LogisticCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogisticCompanyService {
    private final LogisticCompanyRepository logisticCompanyRepository;
    private final LogisticCompanyMapper logisticCompanyMapper;

    @Autowired
    public LogisticCompanyService(LogisticCompanyRepository logisticCompanyRepository, LogisticCompanyMapper logisticCompanyMapper) {
        this.logisticCompanyRepository = logisticCompanyRepository;
        this.logisticCompanyMapper = logisticCompanyMapper;
    }

//    public List<LogisticCompany> getAllCompanies() {
//        return logisticCompanyRepository.findAll();
//    }

    public List<LogisticCompanyDTO> getAllCompanies() {

        List<LogisticCompany> logisticCompanies =  logisticCompanyRepository.findAllByOrderByNameAsc();

        return logisticCompanies.stream()
                .map(logisticCompanyMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    public LogisticCompany createCompany(LogisticCompany company) {
        return logisticCompanyRepository.save(company);
    }
}
