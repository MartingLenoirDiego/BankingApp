package org.banking.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;

    private Double amount;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Transaction() {

    }
    public Transaction(Long id, Double amount, LocalDate date, Account account) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.account = account;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
}
