package com.hackathon.fixeddepositservice.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="fixed_deposits_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FixedDepositsModal {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="DEPOSIT_ID")
        private int depositId;

        @Column(name="CUSTOMER_ID")
        private int customerId;

        @Column(name="DEPOSIT_TENURE")
        private int depositTenure;

        @Column(name="INTEREST_RATE")
        private double interestRate;

        @Column(name="DEPOSIT_AMOUNT")
        private double depositAmount;

        @Column(name="MATURED_AMOUNT")
        private double maturedAmount;

        @Column(name="INTEREST_AMOUNT")
        private double interestAmount;

        @Column(name="DEPOSIT_START_DATE")
        private String depositStartDate;

        @Column(name="MATURITY_DATE")
        private String maturityDate;

        @Column(name="IS_ACTIVE")
        private String active;

        @Column(name="IS_DEPOSIT_MATURED")
        private String depositMatured;
        
       
        
        private FixedDepositsModal(Builder builder) {
            // Assign builder values to instance variables
            this.customerId = builder.customerId;
            this.depositTenure = builder.depositTenure;
            this.depositStartDate = builder.depositStartDate;
            this.depositAmount = builder.depositAmount;
            this.active = builder.active;
            this.depositMatured = builder.depositMatured;
            this.maturedAmount = builder.maturedAmount;
            this.interestAmount = builder.interestAmount;
            this.maturityDate = builder.maturityDate;
            this.interestRate = builder.interestRate;
     
        }

        // Other getter methods and business logic methods

        // Nested Builder class
        public static class Builder {
            private int customerId;
            private int depositTenure;
            private String depositStartDate;
            private double depositAmount;
            private String active;
            private String depositMatured;
            private double maturedAmount;
            private double interestAmount;
            private String maturityDate;
            private double interestRate;
          

            public Builder customerId(int customerId) {
                this.customerId = customerId;
                return this;
            }

            public Builder depositStartDate(String depositStartDate) {
                this.depositStartDate = depositStartDate;
                return this;
            }
            
            public Builder depositTenure(int depositTenure) {
                this.depositTenure = depositTenure;
                return this;
            }
            public Builder depositAmount(double depositAmount) {
                this.depositAmount = depositAmount;
                return this;
            }

            public Builder active(String active) {
                this.active = active;
                return this;
            }

            public Builder depositMatured(String depositMatured) {
                this.depositMatured = depositMatured;
                return this;
            }

            public Builder maturedAmount(double maturedAmount) {
                this.maturedAmount = maturedAmount;
                return this;
            }

            public Builder interestAmount(double interestAmount) {
                this.interestAmount = interestAmount;
                return this;
            }

            public Builder maturityDate(String maturityDate) {
                this.maturityDate = maturityDate;
                return this;
            }

            public Builder interestRate(double interestRate) {
                this.interestRate = interestRate;
                return this;
            }


            // Other builder methods

            public FixedDepositsModal build() {
                return new FixedDepositsModal(this);
            }
        }


//            public static class Builder {
//                private int customerId;
//                private int depositTenure;
//                private String depositStartDate;
//                private double depositAmount;
//                private String active;
//                private String depositMatured;
//                private double maturedAmount;
//                private double interestAmount;
//                private String maturityDate;
//                private double interestRate;
//
//                public Builder customerId(int customerId) {
//                    this.customerId = customerId;
//                    return this;
//                }
//
//                public Builder depositTenure(int depositTenure) {
//                    this.depositTenure = depositTenure;
//                    return this;
//                }
//
//                public Builder depositStartDate(String depositStartDate) {
//                    this.depositStartDate = depositStartDate;
//                    return this;
//                }
//
//                // Other builder methods
//
//                public FixedDepositsModal build() {
//                    return new FixedDepositsModal(this);
//                }
//            }
//            
//            // Other fields and methods of the class
//
//            private FixedDepositsModal(Builder builder) {
//                // Initialize your FixedDepositsModal instance using builder values
//            }
       

  
}
