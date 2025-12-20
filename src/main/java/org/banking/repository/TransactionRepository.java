package org.banking.repository;

import org.banking.model.Account;
import org.banking.model.DepositTransaction;
import org.banking.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccount(Account account);

    @Query("SELECT t FROM DepositTransaction t WHERE t.account = :account")
    List<DepositTransaction> findDepositsByAccount(@Param("account") Account account);
}

