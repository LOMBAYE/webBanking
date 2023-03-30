package com.example.BankApp.controllers;

import com.example.BankApp.entities.Account;
import com.example.BankApp.entities.Customer;
import com.example.BankApp.repositories.AccountRepository;
import com.example.BankApp.repositories.CustomerRepository;
import com.example.BankApp.services.AccountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")

public class AccountController {

    @Autowired
    private AccountService accountService;
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }


    @PostMapping("/accounts/{idCustomer}")
    public Account createAccount(@PathVariable Long idCustomer,@RequestBody  Account account) {
       // log.info(idCustomer);
        //log.info(account.getBalance());
        return  accountService.createAccount(account,idCustomer);
    }
    @PutMapping("/accounts/{id}")
    public Account updateAccount(@PathVariable Long id,@RequestBody Account account) {
        return accountService.updateAccount(id,account);
    }

}