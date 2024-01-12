package informatics.logisticcompany.employees;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_user_id")
    private Long id;

    @Column(name = "employee_first_name")
    private String firstName;

    @Column(name = "employee_last_name")
    private String lastName;

    @Column(name = "employee_birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "logistic_company_id")
    private Long logisticCompanyId;

    @Column(name = "office_branch_id")
    private Long officeBranchId;

    @Column(name = "employee_position")
    private Integer position;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getLogisticCompanyId() {
        return logisticCompanyId;
    }

    public void setLogisticCompanyId(Long logisticCompanyId) {
        this.logisticCompanyId = logisticCompanyId;
    }

    public Long getOfficeBranchId() {
        return officeBranchId;
    }

    public void setOfficeBranchId(Long officeBranchId) {
        this.officeBranchId = officeBranchId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", logisticCompanyId=" + logisticCompanyId +
                ", officeBranchId=" + officeBranchId +
                ", position=" + position +
                '}';
    }
}