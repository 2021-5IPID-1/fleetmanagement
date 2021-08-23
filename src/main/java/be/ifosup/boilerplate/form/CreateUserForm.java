package be.ifosup.boilerplate.form;

import be.ifosup.boilerplate.validator.email.UniqueEmail;
import be.ifosup.boilerplate.validator.username.UniqueUsername;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateUserForm {
    @NotEmpty(message = "First name obligatoire")
    private String firstname;

    @NotEmpty(message = "Last name obligatoire")
    private String lastname;

    @NotEmpty(message = "Email obligatoire")
    @Email
    @UniqueEmail
    private String emailaddress;

    @NotEmpty(message = "Username obligatoire")
    @UniqueUsername
    private String username;

    @NotEmpty(message = "Password obligatoire")
    @Size(min = 10, message = "Min 10 caratères")
    private String password;
}
