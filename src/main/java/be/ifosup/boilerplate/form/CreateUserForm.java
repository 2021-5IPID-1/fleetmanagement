package be.ifosup.boilerplate.form;

import lombok.Data;

@Data
public class CreateUserForm {
    private String firstname;
    private String lastname;
    private String emailaddress;
    private String username;
    private String password;
}
