package com.joshphilpott.models;

import lombok.NonNull;

/**
 * Created by pterodactyl on 2/21/17.
 */
public class PaymentDTO {
    @NonNull
    String token;
    @NonNull
    String lastFour;
    @NonNull
    String provider;

}
