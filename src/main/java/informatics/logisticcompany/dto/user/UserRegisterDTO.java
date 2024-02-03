package informatics.logisticcompany.dto.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {

    @NotNull(message = "Username cannot be null!")
    @Size(min = 3, message = "Username should be at least 3 chars long!")
    private String username;

    @NotNull(message = "Password cannot be null!")
    @Size(min = 3, message = "Password should be at least 3 chars long!")
    private String password;

    @NotNull(message = "First name cannot be null!")
    @Size(min = 3, message = "First name has to be at least 3 chars long!")
    private String firstName;

    @NotNull(message = "Last name cannot be null!")
    @Size(min = 3, message = "Last name has to be at least 3 chars long!")
    private String lastName;

    @NotNull(message = "E-mail cannot be null!")
    @Size(min = 1, message = "E-mail has to be at least 1 char long!")
    private String email;

    @NotNull(message = "Phone number cannot be null!")
    private String phoneNumber;

    @NotNull(message = "Address cannot be null!")
    private String address;

    public UserRegisterDTO() {
    }

    public UserRegisterDTO(String username, String password, String firstName, String lastName, String email, String phoneNumber, String address) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserRegisterDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
