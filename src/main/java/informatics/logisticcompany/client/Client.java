package informatics.logisticcompany.client;

import informatics.logisticcompany.logistic_companies.LogisticCompany;
import informatics.logisticcompany.shipment.Shipment;
import informatics.logisticcompany.users.User;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "clients")
@PrimaryKeyJoinColumn(name = "users_user_id")
public class Client extends User {

    @Column(name = "client_first_name")
    private String firstname;

    @Column(name = "client_last_name")
    private String lastName;

    @Column(name = "client_address")
    private String address;

    @Column(name = "client_phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "logistic_company_id")
    private LogisticCompany logisticCompany;

    // TODO: Ne sum siguren dali ne trqbva da se razmenqt
    @OneToMany(mappedBy = "sender")
    private Set<Shipment> sentShipments;

    // TODO: Ne sum siguren dali ne trqbva da se razmenqt
    @OneToMany(mappedBy = "recipient")
    private Set<Shipment> receivedShipments;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LogisticCompany getLogisticCompany() {
        return logisticCompany;
    }

    public void setLogisticCompany(LogisticCompany logisticCompany) {
        this.logisticCompany = logisticCompany;
    }

    public Client() {  }

    public Client(String username, String email, String password, Boolean enabled, String firstname, String lastName, String address, String phoneNumber, LogisticCompany logisticCompany) {
        super(username, email, password, enabled);
        this.firstname = firstname;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.logisticCompany = logisticCompany;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", logisticCompany=" + logisticCompany +
                '}';
    }
}
