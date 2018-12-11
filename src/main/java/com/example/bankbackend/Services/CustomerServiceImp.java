package com.example.bankbackend.Services;

import com.example.bankbackend.Models.Customer;
import com.example.bankbackend.Models.CustomerDTO;
import com.example.bankbackend.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
  @Autowired
  CustomerRepository customerRepository;

  @Override
  public List<Customer> findById(long accountId) {
    List<Customer> customer = new ArrayList<>();
    customer.add(customerRepository.findById(accountId).get());
    return customer;
  }

  @Override
  public List<Customer> getAllAccounts() {
    List<Customer> customerList = new ArrayList<>();
    customerRepository.findAll().forEach(customerList::add);
    return customerList;
  }

  @Override
  public Customer addAccount(Customer customer) {
    return customerRepository.save(customer);
  }
}
