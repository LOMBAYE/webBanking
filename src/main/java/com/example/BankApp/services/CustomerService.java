package com.example.BankApp.services;


import com.example.BankApp.entities.Account;
import com.example.BankApp.entities.Customer;
import com.example.BankApp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setFirstname(customer.getFirstname());
            existingCustomer.setLastname(customer.getLastname());
            existingCustomer.setPhone(customer.getPhone());
            customerRepository.save(existingCustomer);
        }
        return existingCustomer;
    }

   // public List<Account> getAccountsForCustomer(Long customerId){
     //   Customer customer=customerRepository.findById(customerId).orElseThrow();
      //  return customerRepository.findAccountsByCustomerId(customer.getId());
   // }
    public boolean deleteCustomer(Long id) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        if (existingCustomer != null) {
            customerRepository.delete(existingCustomer);
            return true;
        }
        return false;
    }
}
