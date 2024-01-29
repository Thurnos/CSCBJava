package informatics.logisticcompany.dto.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserDTO {

    @NotNull(message = "Username cannot be null!")
    @NotEmpty(message = "Username cannot be empty!")
    private String username;

    @NotNull(message = "First name cannot be null!")
    @NotEmpty(message = "First name cannot be empty!")
    private String firstName;

    @NotNull(message = "Last name cannot be null!")
    @NotEmpty(message = "Last name cannot be empty!")
    private String lastName;

    @NotNull(message = "Password cannot be null!")
    @NotEmpty(message = "Password cannot be empty!")
    private String password;

    private String matchingPassword;

    @NotNull(message = "Email cannot be null!")
    @NotEmpty(message = "Email cannot be empty!")
    private String email;

    public UserDTO() {
    }

    public UserDTO(String username, String firstName, String lastName, String password, String matchingPassword, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", matchingPassword='" + matchingPassword + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
