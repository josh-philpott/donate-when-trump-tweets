package com.joshphilpott.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by pterodactyl on 2/18/17.
 */
@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({ FIELD, TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
/**
 * From tutorial at http://www.baeldung.com/registration-password-strength-and-rules
 */
public @interface ValidPassword {
    String message() default "Invalid Password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
