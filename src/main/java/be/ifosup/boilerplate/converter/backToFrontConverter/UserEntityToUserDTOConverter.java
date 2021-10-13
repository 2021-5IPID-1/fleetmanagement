package be.ifosup.boilerplate.converter.backToFrontConverter;

import be.ifosup.boilerplate.constants.RoleEnum;
import be.ifosup.boilerplate.dto.UserDTO;
import be.ifosup.boilerplate.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserDTOConverter {
    public UserDTO convert(User user) {
        UserDTO.UserDTOBuilder userDTOBuilder = UserDTO.builder()
                .emailaddress(user.getEmailaddress())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .username(user.getUsername())
                .id(user.getId());

        if(user.getRoles() != null && user.getRoles().size() > 0) {
            userDTOBuilder.role(user.getRoles().stream().findFirst().orElse(null).toString());
        }

        return userDTOBuilder.build();
    }
}
