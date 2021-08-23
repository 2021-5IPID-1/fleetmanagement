package be.ifosup.boilerplate.validator.email;

import be.ifosup.boilerplate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    private final UserRepository userRepository;

    @Autowired
    public UniqueEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !userRepository.existsByEmailaddress(email);
    }
}
