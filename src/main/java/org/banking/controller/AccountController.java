package org.banking.controller;

import org.banking.model.Account;
import org.banking.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Account> addAccount(@PathVariable Long userId, @RequestBody Account account) {
        Account savedAccount = accountService.addAccount(userId, account);
        return ResponseEntity.ok(savedAccount);
    }

    @GetMapping()
    public ResponseEntity<List<Account>> getAccountsForUser(@RequestParam Long userId) {
        return ResponseEntity.ok(accountService.getAccounts(userId));
    }
}
