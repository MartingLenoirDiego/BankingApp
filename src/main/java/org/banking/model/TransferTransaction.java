package org.banking.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("TRANSFER")
public class TransferTransaction extends Transaction {

    @ManyToOne
    @JoinColumn(name = "target_account_id")
    private Account targetAccount;

    protected TransferTransaction() {
    }

    public TransferTransaction(Double amount, String description, Account account, Account targetAccount) {
        setAmount(amount);
        setDescription(description);
        setAccount(account);
        this.targetAccount=targetAccount;
    }

    public Account getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(Account targetAccount) {
        this.targetAccount = targetAccount;
    }

    public TransactionType getType() {
        return TransactionType.TRANSFERT;
    }
}
