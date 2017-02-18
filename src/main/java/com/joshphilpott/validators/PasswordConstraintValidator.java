package com.joshphilpott.validators;

import com.google.common.base.Joiner;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Created by pterodactyl on 2/18/17.
 *
 * Based on tutorial from http://www.baeldung.com/registration-password-strength-and-rules
 */
public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public void initialize(ValidPassword arg){
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context){
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 30),
                new CharacterRule(EnglishCharacterData.Special, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new WhitespaceRule()));

        RuleResult result = validator.validate(new PasswordData(password));

        if (result.isValid()) {
            return true;
        }else {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    Joiner.on("").join(validator.getMessages(result)))
                    .addConstraintViolation();
            return false;
        }
    }
}
