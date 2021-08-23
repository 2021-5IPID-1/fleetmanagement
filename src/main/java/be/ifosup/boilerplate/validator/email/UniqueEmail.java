package be.ifosup.boilerplate.validator.email;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UniqueEmailValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
    String message() default "Email address already exist";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
