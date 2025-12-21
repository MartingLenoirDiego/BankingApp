package org.banking.controller;

import org.banking.dto.DepositRequest;
import org.banking.dto.WithdrawRequest;
import org.banking.model.Transaction;
import org.banking.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/deposit")
    public Transaction deposit(@RequestBody DepositRequest transaction) {
        return transactionService.deposit(transaction.getAccountId(),transaction.getAmount(),transaction.getDescription());
    }

    @PostMapping("/withdraw")
    public Transaction withdraw(@RequestBody WithdrawRequest transaction) {
        return transactionService.withdrawal(transaction.getAccountId(), transaction.getAmount(),transaction.getDescription());
    }

    @GetMapping
    public List<Transaction> getAllTransactions(@RequestParam Long accountId){
        return transactionService.getAllTransactions(accountId);
    }
}
