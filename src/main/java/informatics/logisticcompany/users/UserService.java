package informatics.logisticcompany.users;

import informatics.logisticcompany.client.Client;
import informatics.logisticcompany.client.ClientRepository;
import informatics.logisticcompany.dto.logistic_companies.LogisticCompanyDTO;
import informatics.logisticcompany.dto.role.RoleDTO;
import informatics.logisticcompany.dto.user.UserBasicInfo;
import informatics.logisticcompany.dto.user.UserDTO;
import informatics.logisticcompany.dto.user.UserRegisterDTO;
import informatics.logisticcompany.dto.user.UserRolesDTO;
import informatics.logisticcompany.exception.UserAlreadyExistException;
import informatics.logisticcompany.logistic_companies.LogisticCompany;
import informatics.logisticcompany.logistic_companies.LogisticCompanyRepository;
import informatics.logisticcompany.mapper.LogisticCompanyMapper;
import informatics.logisticcompany.mapper.RoleMapper;
import informatics.logisticcompany.mapper.UserMapper;
import informatics.logisticcompany.roles.Role;
import informatics.logisticcompany.roles.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service layer for user management. Handles CRUD operations for users,
 * loading user details for security, and user registration processes.
 */
@Service
public class UserService implements UserDetailsService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;
    private final ClientRepository clientRepository;
    private final LogisticCompanyRepository logisticCompanyRepository;
    private final LogisticCompanyMapper logisticCompanyMapper;
    private final RoleMapper roleMapper;

    /**
     * Constructs UserService with UserRepository, UserMapper, and PasswordEncoder.
     *
     * @param userRepository Repository for user data access.
     * @param userMapper Mapper for converting between User entities and DTOs.
     */

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository, ClientRepository clientRepository, LogisticCompanyRepository logisticCompanyRepository, LogisticCompanyMapper logisticCompanyMapper, RoleMapper roleMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
        this.clientRepository = clientRepository;
        this.logisticCompanyRepository = logisticCompanyRepository;
        this.logisticCompanyMapper = logisticCompanyMapper;
        this.roleMapper = roleMapper;
    }


    // UserService Extends UserDetailsService
    // The service class has a method to find the user by email
    // This is used by Spring Security to find a user during the login process


    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
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

    public UserDTO findUserDTOByUsername(String username) {
        return userRepository.findUserDTOByUsername(username);
    }

    public void registerUser(UserRegisterDTO userRegisterDTO) {

        Client client = new Client();

        client.setUsername(userRegisterDTO.getUsername());
        client.setFirstname(userRegisterDTO.getFirstName());
        client.setLastName(userRegisterDTO.getLastName());
        client.setEmail(userRegisterDTO.getEmail());
        client.setPassword(bCryptPasswordEncoder.encode(userRegisterDTO.getPassword()));
        client.setPhoneNumber(userRegisterDTO.getPhoneNumber());
        client.setAddress(userRegisterDTO.getAddress());
        client.setEnabled(true);

        RoleDTO roleDTO = roleRepository.findRoleByName("CLIENT");
        Role role = roleMapper.convertToEntity(roleDTO);

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        LogisticCompanyDTO logisticCompanyDTO = logisticCompanyRepository.findLogisticCompanyById(1l);
        LogisticCompany logisticCompany = logisticCompanyMapper.convertToEntity(logisticCompanyDTO);

        client.setRoles(roles);
        client.setLogisticCompany(logisticCompany);

        clientRepository.save(client);
    }

}
