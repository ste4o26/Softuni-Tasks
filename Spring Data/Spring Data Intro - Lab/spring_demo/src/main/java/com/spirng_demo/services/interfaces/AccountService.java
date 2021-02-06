package com.spirng_demo.services.interfaces;

import com.spirng_demo.entities.Account;

import java.math.BigDecimal;

public interface AccountService {
    void withdrawMoney(BigDecimal amount, Long accountId, Long userId);
    void transferMoney(BigDecimal amount, Long idFrom, Long idTo);
    void createAccount(Account account);
}
