package informatics.logisticcompany.logistic_companies;

import informatics.logisticcompany.client.Client;
import informatics.logisticcompany.employees.Employee;
import informatics.logisticcompany.office_branches.OfficeBranch;
import informatics.logisticcompany.shipment.Shipment;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "logistic_companies")
public class LogisticCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logistic_company_id")
    private Long id;

    @Column(name = "logistic_company_name")
    private String name;

    @Column(name = "logistic_company_address")
    private String address;

    @Column(name = "logistic_company_foundation_date")
    private LocalDate foundationDate;

    @OneToMany(mappedBy = "logisticCompany")
    private Set<OfficeBranch> officeBranches;

    @OneToMany(mappedBy = "logisticCompany")
    private Set<Employee> employees;

    @OneToMany(mappedBy = "logisticCompany")
    private Set<Client> clients;

    @OneToMany(mappedBy = "logisticCompany")
    private Set<Shipment> shipments;

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

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public LogisticCompany() {  }

    public LogisticCompany(String name, String address, LocalDate foundationDate) {
        this.name = name;
        this.address = address;
        this.foundationDate = foundationDate;
    }

    @Override
    public String toString() {
        return "LogisticCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", foundationDate=" + foundationDate +
                '}';
    }
}
