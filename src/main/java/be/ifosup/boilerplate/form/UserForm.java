package be.ifosup.boilerplate.form;

import be.ifosup.boilerplate.validator.email.UniqueEmail;
import be.ifosup.boilerplate.validator.username.UniqueUsername;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserForm {
    @NotEmpty(message = "First name obligatoire")
    private String firstname;

    @NotEmpty(message = "Last name obligatoire")
    private String lastname;
}
