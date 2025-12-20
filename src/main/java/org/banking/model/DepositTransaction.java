package org.banking.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DEPOSIT")
public class DepositTransaction extends Transaction {

    public DepositTransaction() {}

    public DepositTransaction(Double amount, String description, Account account) {
        setAmount(amount);
        setDescription(description);
        setAccount(account);
    }

}
