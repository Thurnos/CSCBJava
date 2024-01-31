package informatics.logisticcompany.users;

import informatics.logisticcompany.dto.role.RoleDTO;
import informatics.logisticcompany.dto.user.UserBasicInfo;
import informatics.logisticcompany.dto.user.UserDTO;
import informatics.logisticcompany.dto.user.UserRolesDTO;
import informatics.logisticcompany.roles.Role;
import informatics.logisticcompany.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // additional custom queries can be added here

    User findUserByUsername(String username);
    User findUserByEmail(String email);

    // Get only username and id . . . populate roles in the service layer ( jpql limitation )
    @Query("SELECT new informatics.logisticcompany.dto.user.UserRolesDTO(user.id, user.username, user.email) FROM User user")
    List<UserRolesDTO> findAllUsersWithBasicInfo();

    // Parameter binding @Param =:userId
    @Query("SELECT new informatics.logisticcompany.dto.role.RoleDTO(role.id, role.name) FROM User user JOIN user.roles role WHERE user.id = :userId")
    List<RoleDTO> findRolesByUserId(@Param("userId") Long userId);

    @Query("SELECT new informatics.logisticcompany.dto.user.UserBasicInfo(user.id, user.username, user.email) FROM User user WHERE user.id = :userId")
    UserBasicInfo findUserByIdWithBasicInfo(Long userId);

    @Query("SELECT new informatics.logisticcompany.dto.user.UserRolesDTO(user.id, user.username, user.email) FROM User user WHERE user.id = :userId")
    UserRolesDTO findUserWithBasicInfo(Long userId);

}