package com.spirng_demo.services;

import com.spirng_demo.entities.Account;
import com.spirng_demo.repositories.AccountRepository;
import com.spirng_demo.services.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

//Means that i semantically target that class as a service component
@Service
@Primary
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long accountId, Long userId) {
        Account fetchedAccount = this.accountRepository.findById(accountId)
                .orElse(null);

        if (fetchedAccount == null) {
            throw new IllegalArgumentException(String.format("Could not find account with id: %d", accountId));
        }

        if(!fetchedAccount.getUser().getId().equals(userId)){
            throw new IllegalArgumentException("You can not withdraw money from other people accounts!");
        }

        if (fetchedAccount.getBalance().compareTo(amount) < 0) {
            throw new IllegalStateException("You dont have that much money in you account!");
        }

        BigDecimal balanceAfterWithdraw = fetchedAccount.getBalance().subtract(amount);
        fetchedAccount.setBalance(balanceAfterWithdraw);
        this.accountRepository.save(fetchedAccount);
    }

    @Override
    public void transferMoney(BigDecimal amount, Long idFrom, Long idTo) {
        Account accountFrom = this.accountRepository.findById(idFrom)
                .orElse(null);

        Account accountTo = this.accountRepository.findById(idTo)
                .orElse(null);

        if (accountFrom == null) {
            throw new IllegalArgumentException(String.format("Could not find account FROM which to get the amount with id: %d", idFrom));
        }

        if (accountTo == null) {
            throw new IllegalArgumentException(String.format("Could not find account TO transfer with id: %d", idTo));
        }

        if (accountFrom.getBalance().compareTo(amount) < 0){
            throw new IllegalArgumentException("Account FROM which you want to transfer doesnt have enough money!");
        }

        BigDecimal amountAfterTransfer = accountFrom.getBalance().subtract(amount);
        accountFrom.setBalance(amountAfterTransfer);
        this.accountRepository.save(accountFrom);

        amountAfterTransfer = accountTo.getBalance().add(amount);
        accountTo.setBalance(amountAfterTransfer);
        this.accountRepository.save(accountTo);
    }

    @Override
    public void createAccount(Account account) {
        this.accountRepository.save(account);
    }
}
