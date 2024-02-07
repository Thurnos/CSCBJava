package informatics.logisticcompany.employees;

import informatics.logisticcompany.dto.employee.EmployeeBasicInfoDTO;
import informatics.logisticcompany.dto.employee.EmployeeDTO;
import informatics.logisticcompany.dto.employee.UpdateEmployeeDTO;
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
    @Query("SELECT new informatics.logisticcompany.dto.employee.EmployeeBasicInfoDTO(e.id, e.firstName, e.lastName, e.birthDate) FROM Employee e WHERE e.logisticCompany.id = :companyId")
    List<EmployeeBasicInfoDTO> findEmployeesByCompanyId(@Param("companyId") Long companyId);


    @Query("SELECT new informatics.logisticcompany.dto.employee.EmployeeBasicInfoDTO(e.id, e.firstName, e.lastName, e.birthDate) FROM Employee e")
    List<EmployeeBasicInfoDTO> findAllEmployeesWithBasicInfo();

    @Query("SELECT new informatics.logisticcompany.dto.employee.EmployeeBasicInfoDTO(e.id, e.firstName, e.lastName, e.birthDate) FROM Employee e WHERE e.id =:employeeId")
    EmployeeBasicInfoDTO findEmployeeWithBasicInfoById(Long employeeId);

    @Query("SELECT new informatics.logisticcompany.dto.employee.EmployeeDTO(e.id, e.firstName, e.lastName, e.birthDate, e.logisticCompany.name, e.officeBranch.name, e.position.name) FROM Employee e")
    List<EmployeeDTO> findAllWithEmployeeDTO();

    @Query("SELECT new informatics.logisticcompany.dto.employee.EmployeeDTO(e.id, e.firstName, e.lastName, e.birthDate, e.logisticCompany.name, e.officeBranch.name, e.position.name) FROM Employee e WHERE e.id = :id")
    EmployeeDTO findByIdWithEmployeeDTO(Long id);

    @Query("SELECT new informatics.logisticcompany.dto.employee.UpdateEmployeeDTO(e.id, e.firstName, e.lastName, e.birthDate, e.logisticCompany, e.officeBranch, e.position) FROM Employee e")
    UpdateEmployeeDTO findByIdWithUpdateEmployeeDTO(Long id);

    Employee findEmployeeById(Long id);
    Employee findEmployeeByUsername(String username);

    @Query("SELECT new informatics.logisticcompany.dto.employee.EmployeeDTO(e.id, e.firstName, e.lastName, e.birthDate, e.logisticCompany.name, e.officeBranch.name, e.position.name) FROM Employee e WHERE e.username = :username")
    EmployeeDTO findWithEmployeeDTOByUsername(String username);



}