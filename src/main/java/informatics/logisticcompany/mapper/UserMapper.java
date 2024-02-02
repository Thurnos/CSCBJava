package informatics.logisticcompany.mapper;

import informatics.logisticcompany.dto.user.UserDTO;
import informatics.logisticcompany.dto.user.UserRolesDTO;
import informatics.logisticcompany.users.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;


    /**
     * Constructs a UserMapper with an injected ModelMapper instance.
     * This enables automated and customizable object mapping between User entities and UserDTOs.
     *
     * @param modelMapper The ModelMapper instance for object conversions.
     */
    @Autowired
    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    /**
     * Converts a User entity to a UserDTO.
     *
     * @param user The User entity to convert.
     * @return A UserDTO that represents the user's data.
     */
    public UserDTO convertToDTO(User user) {
        UserDTO userDto = modelMapper.map(user, UserDTO.class);
        return userDto;
    }


    /**
     * Converts a UserDTO to a User entity.
     *
     * @param userDTO The UserDTO to convert.
     * @return A User entity populated with the DTO's data.
     */
    public User convertToEntity(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }

    public User convertUserRolesToEntity(UserRolesDTO userRolesDTO) {
        User user = modelMapper.map(userRolesDTO, User.class);
        return user;
    }
}
