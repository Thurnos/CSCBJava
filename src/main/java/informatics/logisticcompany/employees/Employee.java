package informatics.logisticcompany.employees;

import informatics.logisticcompany.logistic_companies.LogisticCompany;
import informatics.logisticcompany.office_branches.OfficeBranch;
import informatics.logisticcompany.possitions_catalog.PositionCatalog;
import informatics.logisticcompany.shipment.Shipment;
import informatics.logisticcompany.users.User;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employees")
@PrimaryKeyJoinColumn(name = "users_user_id")
public class Employee extends User {

    @Column(name = "employee_first_name")
    private String firstName;

    @Column(name = "employee_last_name")
    private String lastName;

    @Column(name = "employee_birth_date")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "logistic_company_id")
    private LogisticCompany logisticCompany;

    @ManyToOne
    @JoinColumn(name = "office_branch_id")
    private OfficeBranch officeBranch;

    @ManyToOne
    @JoinColumn(name = "employee_position")
    private PositionCatalog position;

    @OneToMany(mappedBy = "registeredBy")
    private Set<Shipment> registeredShipments;

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

    public Employee() {  }

    public Employee(String username, String email, String password, Boolean enabled, String firstName, String lastName, LocalDate birthDate, LogisticCompany logisticCompany, OfficeBranch officeBranch, PositionCatalog position) {
        super(username, email, password, enabled);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.logisticCompany = logisticCompany;
        this.officeBranch = officeBranch;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", logisticCompany=" + logisticCompany +
                ", officeBranch=" + officeBranch +
                ", position=" + position +
                '}';
    }
}