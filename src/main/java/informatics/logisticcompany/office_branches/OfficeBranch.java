package informatics.logisticcompany.office_branches;
import informatics.logisticcompany.employees.Employee;
import informatics.logisticcompany.logistic_companies.LogisticCompany;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "office_branches")
public class OfficeBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "office_branch_id")
    private Long id;

    @Column(name = "office_branch_name")
    private String name;

    @Column(name = "office_branch_address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "logistic_company_id")
    private LogisticCompany logisticCompany;

    @OneToMany(mappedBy = "officeBranch")
    private Set<Employee> employees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LogisticCompany getLogisticCompany() {
        return logisticCompany;
    }

    public void setLogisticCompany(LogisticCompany logisticCompany) {
        this.logisticCompany = logisticCompany;
    }

    public OfficeBranch() {  }

    public OfficeBranch(String name, String address, LogisticCompany logisticCompany) {
        this.name = name;
        this.address = address;
        this.logisticCompany = logisticCompany;
    }

    @Override
    public String toString() {
        return "OfficeBranch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", logisticCompany=" + logisticCompany +
                '}';
    }
}