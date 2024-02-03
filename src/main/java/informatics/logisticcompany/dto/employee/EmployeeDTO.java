package informatics.logisticcompany.dto.employee;

import java.time.LocalDate;

public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String logisticCompanyName;
    private String officeBranchName;
    private String position;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String firstName, String lastName, LocalDate birthDate, String logisticCompanyName, String officeBranchName, String position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.logisticCompanyName = logisticCompanyName;
        this.officeBranchName = officeBranchName;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getLogisticCompanyName() {
        return logisticCompanyName;
    }

    public void setLogisticCompanyName(String logisticCompanyName) {
        this.logisticCompanyName = logisticCompanyName;
    }

    public String getOfficeBranchName() {
        return officeBranchName;
    }

    public void setOfficeBranchName(String officeBranchName) {
        this.officeBranchName = officeBranchName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", logisticCompanyName='" + logisticCompanyName + '\'' +
                ", officeBranchName='" + officeBranchName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
