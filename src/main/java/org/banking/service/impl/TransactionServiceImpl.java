package org.banking.service.impl;

import org.banking.model.Account;
import org.banking.model.DepositTransaction;
import org.banking.model.Transaction;
import org.banking.repository.AccountRepository;
import org.banking.repository.TransactionRepository;
import org.banking.service.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    public TransactionServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction deposit(Long accountId, Double amount, String description){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("account not found"));
        account.setBalance(account.getBalance()+amount);

        DepositTransaction depositTransaction = new DepositTransaction(amount, description, account);
        transactionRepository.save(depositTransaction);
        return depositTransaction;
    }

    @Override
    public List<Transaction> getAllTransactions(Long accountId){
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("account not found"));
        return transactionRepository.findByAccount(account);
    }
}
