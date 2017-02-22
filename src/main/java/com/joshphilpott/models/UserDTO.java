package com.joshphilpott.models;

import com.joshphilpott.validators.ValidPassword;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * Gets USER details from registratin and validates fields.
 * This object is not saved because password hashing winds up being validated.
 *
 * Haste makes waste.
 */
@NoArgsConstructor
@ToString
@Setter
@Getter
public class UserDTO {
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String username;
    @ValidPassword
    private String password;



    public User getUser(){
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
}
