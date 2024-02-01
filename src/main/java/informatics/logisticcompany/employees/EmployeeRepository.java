package informatics.logisticcompany.employees;

import informatics.logisticcompany.dto.employee.EmployeeBasicInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Repository interface for Employee entities.
 * Extends JpaRepository to provide standard CRUD operations on Employee entities
 * and includes custom query methods for specific business logic.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * Custom query to find employees by their associated company ID.
     * This query joins the employees table with logistic_companies, office_branches,
     * and positions_catalog to fetch comprehensive employee details including
     * their position, office branch, and logistic company name.
     *
     * @param companyId The ID of the logistic company to filter employees by.
     * @return A list of employee details as Object arrays. Each Object array contains
     *         the user's ID, first name, last name, birth date, position name,
     *         office branch name, and logistic company name.
     */
    @Query(value = "SELECT e.users_user_id, e.employee_first_name, e.employee_last_name, e.employee_birth_date, pc.position_name, ob.office_branch_name, lc.logistic_company_name FROM employees e JOIN logistic_companies lc ON e.logistic_company_id = lc.logistic_company_id JOIN office_branches ob ON e.office_branch_id = ob.office_branch_id JOIN positions_catalog pc ON e.employee_position = pc.position_catalog_id WHERE lc.logistic_company_id = :companyId", nativeQuery = true)
    List<Object[]> findEmployeesByCompanyId(@Param("companyId") int companyId);


    @Query("SELECT new informatics.logisticcompany.dto.employee.EmployeeBasicInfoDTO(e.id, e.firstName, e.lastName, e.birthDate) FROM Employee e")
    List<EmployeeBasicInfoDTO> findAllEmployeesWithBasicInfo();

    @Query("SELECT new informatics.logisticcompany.dto.employee.EmployeeBasicInfoDTO(e.id, e.firstName, e.lastName, e.birthDate) FROM Employee e WHERE e.id =:employeeId")
    EmployeeBasicInfoDTO findEmployeeWithBasicInfoById(Long employeeId);

}