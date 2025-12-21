package org.banking.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("WITHDRAWAL")
public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction() {}

    public WithdrawalTransaction(Double amount,String description, Account account) {
        setAmount(amount);
        setDescription(description);
        setAccount(account);
    }

    @Override
    public TransactionType getType() {
        return TransactionType.WITHDRAWAL;
    }
}
