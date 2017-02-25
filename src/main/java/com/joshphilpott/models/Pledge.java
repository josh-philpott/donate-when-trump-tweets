package com.joshphilpott.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by pterodactyl on 2/21/17.
 */
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class Pledge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Charty Ein
    public String charityEin;

    public String charityName;

    public BigDecimal amount;

    public BigDecimal max;

    @GeneratedValue(strategy = GenerationType.AUTO)
    //We use start date to determine when we should start counting tweets for this user
    //This value should be updated every time the pledge is executed. In order to calculate the next donation amount,
    //tweets will be counted from lastExecutionDate to currentExecutionDate
    Date lastExecutionDate;

}
