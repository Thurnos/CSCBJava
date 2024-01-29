package informatics.logisticcompany.mapper;

import informatics.logisticcompany.dto.user.UserDTO;
import informatics.logisticcompany.users.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO convertToDTO(User user) {
        UserDTO userDto = modelMapper.map(user, UserDTO.class);
        return userDto;
    }

    public User convertToEntity(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }
}
