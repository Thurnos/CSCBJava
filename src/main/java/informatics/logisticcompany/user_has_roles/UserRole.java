package informatics.logisticcompany.user_has_roles;
import informatics.logisticcompany.roles.Role;
import informatics.logisticcompany.users.User;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;
@Entity
@Table(name = "user_roles")
public class UserRole {
    @Id
    @ManyToOne
    @JoinColumn(name = "users_user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "roles_role_id")
    private Role role;

    // Constructors, getters, and setters

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "user=" + user +
                ", role=" + role +
                '}';
    }
}

