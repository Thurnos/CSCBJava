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

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

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

    public List<UserRolesDTO> findALlUsersWithRoles() {
        List<UserRolesDTO> users = userRepository.findAllUsersWithBasicInfo();

        users.forEach(user -> {
            List<RoleDTO> roles = userRepository.findRolesByUserId(user.getId());
            user.setRoles(roles);
        });

        return users;
    }

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

    public User findBy(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findUserByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid email or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

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

    private boolean emailExists(String email) {
        return userRepository.findUserByEmail(email) != null;
    }
}
