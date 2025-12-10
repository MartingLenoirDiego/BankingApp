package org.banking.controller;

import org.banking.model.Transaction;
import org.banking.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private TransactionService transactionService;
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/{accountId}")
    public ResponseEntity<Transaction> addTransaction(@PathVariable Long accountId, @RequestBody Transaction transactionRequest) {
        Transaction saved = transactionService.addTransaction(
                accountId,
                transactionRequest.getAmount(),
                transactionRequest.getDescription()
        );
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getTransactions(@RequestParam Long accountId) {
        return ResponseEntity.ok(transactionService.getTransactions(accountId));
    }
}
