package informatics.logisticcompany.dto.user;

import informatics.logisticcompany.dto.role.RoleDTO;
import informatics.logisticcompany.roles.Role;

import java.util.List;
import java.util.Set;

public class UserRolesDTO {

    private Long id;
    private String username;
    private String email;
    private List<RoleDTO> roles;

    public UserRolesDTO() {
    }

    public UserRolesDTO(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public UserRolesDTO(Long id, String username, String email, List<RoleDTO> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserRolesDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
