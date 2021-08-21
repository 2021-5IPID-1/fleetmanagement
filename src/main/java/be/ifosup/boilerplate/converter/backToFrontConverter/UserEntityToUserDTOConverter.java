package be.ifosup.boilerplate.converter.backToFrontConverter;

import be.ifosup.boilerplate.dto.UserDTO;
import be.ifosup.boilerplate.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserDTOConverter {
    public UserDTO convert(User user) {
        UserDTO userDTO = UserDTO.builder()
                .emailaddress(user.getEmailaddress())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .username(user.getUsername())
                .id(user.getId())
                .build();

        return userDTO;
    }
}
