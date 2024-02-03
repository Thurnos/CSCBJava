package informatics.logisticcompany.logistic_companies;

import informatics.logisticcompany.dto.logistic_companies.LogisticCompanyDTO;
import informatics.logisticcompany.mapper.LogisticCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Service class for handling business logic related to logistic companies.
 * This class provides methods for retrieving and manipulating logistic company data,
 * leveraging the LogisticCompanyRepository for data access and the LogisticCompanyMapper for DTO conversion.
 */
@Service
public class LogisticCompanyService {
    private final LogisticCompanyRepository logisticCompanyRepository;
    private final LogisticCompanyMapper logisticCompanyMapper;



    /**
     * Constructs a LogisticCompanyService with the necessary dependencies.
     *
     * @param logisticCompanyRepository The repository for accessing logistic company data.
     * @param logisticCompanyMapper The mapper for converting between logistic company entities and DTOs.
     */
    @Autowired
    public LogisticCompanyService(LogisticCompanyRepository logisticCompanyRepository, LogisticCompanyMapper logisticCompanyMapper) {
        this.logisticCompanyRepository = logisticCompanyRepository;
        this.logisticCompanyMapper = logisticCompanyMapper;
    }

//    public List<LogisticCompany> getAllCompanies() {
//        return logisticCompanyRepository.findAll();
//    }


    /**
     * Retrieves all logistic companies, sorted by name in ascending order, and converts them to DTOs.
     *
     * @return A list of LogisticCompanyDTO objects representing all logistic companies.
     */
    public List<LogisticCompanyDTO> getAllWithLogisticCompanyDTO() {
        return logisticCompanyRepository.findAllWithLogisticCompanyDTO();
    }

    /**
     * Saves a new logistic company to the database.
     *
     * @param company The LogisticCompany entity to be saved.
     * @return The saved LogisticCompany entity, including any automatic updates applied during save (e.g., generated ID).
     */
    public LogisticCompany createCompany(LogisticCompany company) {
        return logisticCompanyRepository.save(company);
    }

    public LogisticCompanyDTO findByIdWithLogisticCompanyDTO(Long id) {
        return logisticCompanyRepository.findByIdWithLogisticCompanyDTO(id);
    }

    public void deleteCompany(Long companyId) {
        logisticCompanyRepository.deleteById(companyId);
    }

    public LogisticCompany saveCompany(LogisticCompany company) {
        return logisticCompanyRepository.save(company);
    }



}