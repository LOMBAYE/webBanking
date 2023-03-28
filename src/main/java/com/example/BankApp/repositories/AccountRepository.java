package com.example.BankApp.repositories;

import com.example.BankApp.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository< Account, Long> {
}
