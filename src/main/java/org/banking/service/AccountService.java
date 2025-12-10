package org.banking.service;

import org.banking.model.Account;
import org.banking.model.User;
import org.banking.repository.AccountRepository;
import org.banking.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private UserRepository userRepository;
    private AccountRepository accountRepository;
    private final Logger logger = LoggerFactory.getLogger(AccountService.class);

    public AccountService(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public Account addAccount(Long userId, Account account) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        account.setUser(user);
        Account newAccount = accountRepository.save(account);
        logger.info("Account {} create for user : {}", newAccount.getId(), user.getUsername());
        return newAccount;
    }

    public List<Account> getAccounts(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getAccounts();
    }
}
