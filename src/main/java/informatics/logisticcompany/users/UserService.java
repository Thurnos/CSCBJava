package informatics.logisticcompany.users;

import informatics.logisticcompany.dto.role.RoleDTO;
import informatics.logisticcompany.dto.user.UserBasicInfo;
import informatics.logisticcompany.dto.user.UserDTO;
import informatics.logisticcompany.dto.user.UserRolesDTO;
import informatics.logisticcompany.exception.UserAlreadyExistException;
import informatics.logisticcompany.mapper.UserMapper;
import informatics.logisticcompany.roles.Role;
import informatics.logisticcompany.roles.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service layer for user management. Handles CRUD operations for users,
 * loading user details for security, and user registration processes.
 */
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    /**
     * Constructs UserService with UserRepository, UserMapper, and PasswordEncoder.
     *
     * @param userRepository Repository for user data access.
     * @param userMapper Mapper for converting between User entities and DTOs.
     * @param passwordEncoder Encoder for hashing passwords.
     */
    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }


    /**
     * Finds a user by ID and returns their basic information.
     *
     * @param userId The ID of the user to find.
     * @return UserBasicInfo containing the basic details of the user.
     */
    public UserBasicInfo findUserByIdWithBasicInfo(Long userId) {
        return userRepository.findUserByIdWithBasicInfo(userId);
    }

    public List<RoleDTO> findRolesByUserId(Long id) {
        return userRepository.findRolesByUserId(id);
    }

    public UserRolesDTO findUserWithBasicInfo(Long id) {
        return userRepository.findUserWithBasicInfo(id);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }


    // -----------------------------------


    /**
     * Retrieves all users with basic information and their associated roles from the UserRepository.
     *
     * @return List of UserRolesDTO objects containing users and their roles.
     */
    public List<UserRolesDTO> findALlUsersWithRoles() {
        List<UserRolesDTO> users = userRepository.findAllUsersWithBasicInfo();

        users.forEach(user -> {
            List<RoleDTO> roles = userRepository.findRolesByUserId(user.getId());
            user.setRoles(roles);
        });

        return users;
    }

    /**
     * Retrieves a user with basic information and their associated roles by their ID from the UserRepository.
     *
     * @param id The ID of the user.
     * @return UserRolesDTO object containing user information and roles.
     */
    public UserRolesDTO findUserWithRoles(Long id) {
        UserRolesDTO user = userRepository.findUserWithBasicInfo(id);
        List<RoleDTO> roles = userRepository.findRolesByUserId(id);
        user.setRoles(roles);
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Retrieves a user by their username from the UserRepository.
     *
     * @param username The username of the user to be retrieved.
     * @return The User object associated with the provided username.
     */
    public User findBy(String username) {
        return userRepository.findUserByUsername(username);
    }


    /**
     * Loads a user by their email address and constructs a UserDetails object for Spring Security.
     *
     * @param email The email address of the user to be loaded.
     * @return UserDetails object representing the user.
     * @throws UsernameNotFoundException If the user is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findUserByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid email or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    /**
     * Maps a collection of roles to Spring Security GrantedAuthority objects.
     *
     * @param roles The collection of roles to be mapped.
     * @return A collection of GrantedAuthority objects representing the roles.
     */
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    /**
     * Registers a new user with the given user DTO details. Throws UserAlreadyExistException
     * if the email already exists.
     *
     * @param userDto The user DTO containing new user details.
     * @return The registered User entity.
     * @throws UserAlreadyExistException If the email already exists.
     */
    public User registerNewUser(UserDTO userDto) throws UserAlreadyExistException {
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistException("The email address is already in use: " +
                    userDto.getEmail());
        }

// TODO: Add default role
        User user = userMapper.convertToEntity(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Checks if an email address already exists in the UserRepository.
     *
     * @param email The email address to be checked.
     * @return True if the email address exists, false otherwise.
     */
    private boolean emailExists(String email) {
        return userRepository.findUserByEmail(email) != null;
    }
}
