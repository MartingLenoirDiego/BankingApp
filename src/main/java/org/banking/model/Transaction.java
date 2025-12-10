package org.banking.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;

    private Double amount;
    private LocalDate date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Transaction() {
        this.date = LocalDate.from(LocalDateTime.now());
    }
    public Transaction(Long id, Double amount, LocalDate date,String description, Account account) {
        this.id = id;
        this.amount = amount;
        this.date = LocalDate.from(LocalDateTime.now());
        this.account = account;
        this.description = description;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
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
