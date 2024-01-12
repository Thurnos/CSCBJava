package informatics.logisticcompany.employees;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Additional custom queries can be added here if needed
}