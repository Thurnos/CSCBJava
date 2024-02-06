package informatics.logisticcompany.employees;

import java.time.LocalDate;

public interface EmployeeBasicInfoProjection {
    int getId();
    String getFirstName();
    String getLastName();
    LocalDate getBirthDate();
}
