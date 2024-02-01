package informatics.logisticcompany.logistic_companies;

import informatics.logisticcompany.dto.logistic_companies.LogisticCompanyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Repository interface for LogisticCompany entities.
 * Extends JpaRepository to leverage Spring Data JPA's standard CRUD operations
 * and add custom queries for logistic companies.
 */
@Repository
public interface LogisticCompanyRepository extends JpaRepository<LogisticCompany, Long> {


    /**
     * Finds all LogisticCompany entities and orders them by name in ascending order.
     * This method is useful for displaying logistic companies in a sorted manner,
     * making it easier for users to navigate through lists of companies.
     *
     * @return A List of LogisticCompany entities sorted by name in ascending order.
     */
    List<LogisticCompany> findAllByOrderByNameAsc();

}
