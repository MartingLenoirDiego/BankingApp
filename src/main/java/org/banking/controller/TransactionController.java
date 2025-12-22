package org.banking.controller;

import org.banking.dto.DepositRequest;
import org.banking.dto.TransferRequest;
import org.banking.dto.WithdrawRequest;
import org.banking.model.Transaction;
import org.banking.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/deposit")
    public Transaction deposit(@RequestBody DepositRequest transaction) {
        logger.info("Received deposit request: accountId={}, amount={}", transaction.getAccountId(), transaction.getAmount());
        return transactionService.deposit(transaction.getAccountId(),transaction.getAmount(),transaction.getDescription());
    }

    @PostMapping("/withdraw")
    public Transaction withdraw(@RequestBody WithdrawRequest transaction) {
        logger.info("Withdraw request: accountId={}, amount={}", transaction.getAccountId(), transaction.getAmount());
        return transactionService.withdrawal(transaction.getAccountId(), transaction.getAmount(),transaction.getDescription());
    }

    @PostMapping("/transfer")
    public Transaction transfer(@RequestBody TransferRequest transaction) {
        logger.info("Transaction request: accountId={}, target={}, amount={}", transaction.getAccountId(),transaction.getTargetAccountId(), transaction.getAmount());
        return transactionService.transfer(transaction.getAccountId(),transaction.getTargetAccountId(),transaction.getAmount(),transaction.getDescription());
    }

    @GetMapping
    public List<Transaction> getAllTransactions(@RequestParam Long accountId){
        return transactionService.getAllTransactions(accountId);
    }
}
