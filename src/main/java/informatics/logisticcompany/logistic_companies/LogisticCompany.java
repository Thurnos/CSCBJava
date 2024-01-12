package informatics.logisticcompany.logistic_companies;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;

import java.util.Date;

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
    private Date foundationDate;

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

    public Date getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(Date foundationDate) {
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


    // Getters, setters, and constructors
}
