package com.example.BankApp.services;


import com.example.BankApp.entities.Account;
import com.example.BankApp.entities.Customer;
import com.example.BankApp.repositories.AccountRepository;
import com.example.BankApp.repositories.CustomerRepository;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public Account createAccount(Account account, Long idCustomer) {
        Customer parent = customerRepository.findById(idCustomer).orElseThrow(null);
        account.setCustomer(parent);
        return accountRepository.save(account);
    }
    public Account updateAccount(Long id, Account account) {
        Account existingAccount = accountRepository.findById(id).orElse(null);
        if (existingAccount != null) {
            existingAccount.setAccountNum(account.getAccountNum());
            existingAccount.setBalance(account.getBalance());
            accountRepository.save(existingAccount);
        }
        return existingAccount;
    }

}
