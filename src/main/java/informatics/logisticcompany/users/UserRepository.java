package informatics.logisticcompany.users;

import informatics.logisticcompany.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // additional custom queries can be added here

    User findUserByUsername(String username);
    User findUserByEmail(String email);
}