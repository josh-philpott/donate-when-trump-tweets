package com.joshphilpott.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by pterodactyl on 2/18/17.
 */
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String username;
    private String password;
    @OneToOne
    private CreditCard creditCard;
}


