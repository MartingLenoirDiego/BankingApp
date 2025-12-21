package org.banking.service.impl;

import org.banking.model.Account;
import org.banking.model.DepositTransaction;
import org.banking.model.Transaction;
import org.banking.model.WithdrawalTransaction;
import org.banking.repository.AccountRepository;
import org.banking.repository.TransactionRepository;
import org.banking.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private static final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);
    public TransactionServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction deposit(Long accountId, Double amount, String description){
        if(amount <= 0){
            log.error("Amount must be greater than zero");
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("account not found"));
        account.setBalance(account.getBalance()+amount);

        DepositTransaction depositTransaction = new DepositTransaction(amount, description, account);
        try {
            transactionRepository.save(depositTransaction);
            log.info("deposit transaction success.");
        }catch (Exception e){
            log.error("deposit failed");
            throw new RuntimeException("deposit failed");
        }

        return depositTransaction;
    }

    @Override
    public Transaction withdrawal(Long accountId, Double amount, String description){
        if(amount <= 0){
            log.error("Amount must be greater than zero");
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("account not found"));
        account.setBalance(account.getBalance()-amount);
        WithdrawalTransaction withdrawalTransaction = new WithdrawalTransaction(amount, description, account);
        transactionRepository.save(withdrawalTransaction);
        log.info("withdrawal transaction success.");
        return withdrawalTransaction;
    }

    @Override
    public List<Transaction> getAllTransactions(Long accountId){
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("account not found"));
        return transactionRepository.findByAccount(account);
    }
}
