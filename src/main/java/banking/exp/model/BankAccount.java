
package banking.exp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

    @Data
    @Entity
    public class BankAccount {

        @Id
        private int accountNumber;

        private String name;

        private double balance;
    }

