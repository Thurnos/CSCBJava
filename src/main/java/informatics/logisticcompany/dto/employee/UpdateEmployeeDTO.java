package informatics.logisticcompany.dto.employee;

import informatics.logisticcompany.logistic_companies.LogisticCompany;
import informatics.logisticcompany.office_branches.OfficeBranch;
import informatics.logisticcompany.possitions_catalog.PositionCatalog;

import java.time.LocalDate;

public class UpdateEmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LogisticCompany logisticCompany;
    private OfficeBranch officeBranch;
    private PositionCatalog position;

    public UpdateEmployeeDTO() {
    }

    public UpdateEmployeeDTO(Long id, String firstName, String lastName, LocalDate birthDate, LogisticCompany logisticCompany, OfficeBranch officeBranch, PositionCatalog position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.logisticCompany = logisticCompany;
        this.officeBranch = officeBranch;
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

    public LogisticCompany getLogisticCompany() {
        return logisticCompany;
    }

    public void setLogisticCompany(LogisticCompany logisticCompany) {
        this.logisticCompany = logisticCompany;
    }

    public OfficeBranch getOfficeBranch() {
        return officeBranch;
    }

    public void setOfficeBranch(OfficeBranch officeBranch) {
        this.officeBranch = officeBranch;
    }

    public PositionCatalog getPosition() {
        return position;
    }

    public void setPosition(PositionCatalog position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "UpdateEmployeeDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", logisticCompany=" + logisticCompany +
                ", officeBranch=" + officeBranch +
                ", position=" + position +
                '}';
    }
}
