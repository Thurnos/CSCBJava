package informatics.logisticcompany.logistic_companies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticCompanyRepository extends JpaRepository<LogisticCompany, Long> {
    // additional custom queries can be added here
}