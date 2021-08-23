package be.ifosup.boilerplate.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UpdateUserForm extends UserForm {
    private Long id;
}
