package informatics.logisticcompany.client;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_user_id")
    private int id;

    @Column(name = "client_first_name")
    private String firstName;

    @Column(name = "client_last_name")
    private String lastName;

    @Column(name = "client_address")
    private String address;

    @Column(name = "client_phone_number")
    private String phoneNumber;

    @Column(name = "logistic_company_id")
    private Long logisticCompanyId;

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLogisticCompanyId(Long logisticCompanyId) {
        this.logisticCompanyId = logisticCompanyId;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Long getLogisticCompanyId() {
        return logisticCompanyId;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", logisticCompanyId=" + logisticCompanyId +
                '}';
    }

    // Constructors, getters, and setters
}
