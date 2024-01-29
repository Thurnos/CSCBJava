package informatics.logisticcompany.logistic_companies;

import informatics.logisticcompany.dto.logistic_companies.LogisticCompanyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogisticCompanyRepository extends JpaRepository<LogisticCompany, Long> {
    // additional custom queries can be added here

    List<LogisticCompany> findAllByOrderByNameAsc();

}
