package be.ifosup.boilerplate.form;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateUserForm {
    @NotNull(message = "First name obligatoire")
    private String firstname;

    @NotNull(message = "Last name obligatoire")
    private String lastname;

    @NotNull(message = "Email obligatoire")
    @Email
    private String emailaddress;

    @NotNull(message = "Username obligatoire")
    private String username;

    @NotNull(message = "Password obligatoire")
    @Size(min = 10, message = "Min 10 caratères")
    private String password;
}
