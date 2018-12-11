package com.example.bankbackend.Services;

import com.example.bankbackend.Models.Customer;

import java.util.List;

public interface CustomerService {
  List<Customer> findById(long accountId);

  List<Customer> getAllAccounts();

  Customer addAccount(Customer customer);
}
