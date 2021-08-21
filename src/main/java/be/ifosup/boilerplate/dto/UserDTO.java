package be.ifosup.boilerplate.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String lastname;
    private String firstname;
    private String emailaddress;
    private String role;
}
