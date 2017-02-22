package com.joshphilpott.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

/**
 * Created by pterodactyl on 2/21/17.
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    String token;
    @Pattern(regexp="[\\d]{4}")
    String lastFour;
    @NonNull
    String provider;
}
