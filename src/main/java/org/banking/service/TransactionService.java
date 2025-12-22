package org.banking.service;

import org.banking.model.Transaction;

import java.util.List;

public interface TransactionService{

    Transaction deposit(Long accountId, Double amount, String description);

    Transaction withdrawal(Long accountId, Double amount, String description);

    Transaction transfer(Long accountId,Long accountTarget, Double amount, String description);

    List<Transaction> getAllTransactions(Long accountId);
}