package informatics.logisticcompany.logistic_companies;

import informatics.logisticcompany.dto.logistic_companies.LogisticCompanyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
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

    @Query("SELECT new informatics.logisticcompany.dto.logistic_companies.LogisticCompanyDTO(" +
            "lc.id, lc.name, lc.address, lc.foundationDate) FROM LogisticCompany lc WHERE lc.id = :id")
    LogisticCompanyDTO findByIdWithLogisticCompanyDTO(Long id);

    @Query(value = "SELECT " +
            "lc.logistic_company_id, " +
            "lc.logistic_company_name, " +
            "SUM(s.shipment_total) " +
            "FROM shipments s " +
            "INNER JOIN logistic_companies lc ON s.logistic_company_id = lc.logistic_company_id " +
            "WHERE s.shipment_created BETWEEN :startDate AND :endDate " +
            "GROUP BY lc.logistic_company_id, lc.logistic_company_name",
            nativeQuery = true)
    List<Object[]> findLogisticCompanyDeliveryCostsBetween(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate);

    @Query("SELECT new informatics.logisticcompany.dto.logistic_companies.LogisticCompanyDTO(lc.id, lc.name, lc.address, lc.foundationDate) FROM LogisticCompany lc")
    List<LogisticCompanyDTO> findAllWithLogisticCompanyDTO();


}
