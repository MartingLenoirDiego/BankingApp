package org.banking.service;

import org.banking.model.Account;
import org.banking.model.Transaction;
import org.banking.repository.AccountRepository;
import org.banking.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    public TransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Transaction addTransaction(Long accountId, double amount,String description) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        accountRepository.save(account);
        Transaction t = new Transaction();
        t.setAmount(amount);
        t.setAccount(account);
        t.setDescription(description);
        return transactionRepository.save(t);
    }

    public List<Transaction> getTransactions(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }


}
