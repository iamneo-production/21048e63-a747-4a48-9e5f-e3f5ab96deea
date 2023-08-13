package com.hackathon.interestrateservice.Modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "interest_rate_master")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InterestRateModal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="INTEREST_RATE_ID")
    private int interestRateId;

    @Column(name ="FROM_DAYS")
    private int fromDays;

    @Column(name ="TO_DAYS")
    private int toDays;

    @Column(name ="INTEREST_RATE")
    private double interestRate;

    @Column(name ="CREATE_DATE")
    private String createDate;

    @Column(name ="MODIFIED_DATE")
    private String modifiedDate;

}
