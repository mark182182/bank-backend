package com.example.bankbackend.Services;

import com.example.bankbackend.Models.Customer;
import com.example.bankbackend.Models.CustomerTransactions;
import com.example.bankbackend.Repositories.CustomerRepository;
import com.example.bankbackend.Repositories.CustomerTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerTransactionsServiceImp implements CustomerTransactionsService {
  private CustomerTransactionsRepository customerTransactionsRepository;
  private CustomerRepository customerRepository;

  @Autowired
  public CustomerTransactionsServiceImp(CustomerTransactionsRepository customerTransactionsRepository, CustomerRepository customerRepository) {
    this.customerTransactionsRepository = customerTransactionsRepository;
    this.customerRepository = customerRepository;
  }

  @Override
  public String sendMoney(long moneyAmount, long senderId, long receiverId) {
    CustomerTransactions currentTransaction = new CustomerTransactions();
    List<Customer> senderCustomer = new ArrayList<>();
    List<Customer> receiverCustomer = new ArrayList<>();
    senderCustomer.add(customerRepository.findById(senderId).get());
    receiverCustomer.add(customerRepository.findById(receiverId).get());
    if (senderCustomer.get(0).getAccountBalance() - moneyAmount < 0 || moneyAmount < 0) {
      return "Sorry, you don't have enough money to make the transfer.";
    } else {
      senderCustomer.get(0).setAccountBalance(senderCustomer.get(0).getAccountBalance() - moneyAmount);
      receiverCustomer.get(0).setAccountBalance(receiverCustomer.get(0).getAccountBalance() + moneyAmount);
      customerRepository.save(receiverCustomer.get(0));
      currentTransaction.setFromAccount(String.valueOf(senderId));
      currentTransaction.setToAccount(String.valueOf(receiverId));
      currentTransaction.setTransferAmount(moneyAmount);
      currentTransaction.setDateOfTransaction(new Date().toString());
      customerTransactionsRepository.save(currentTransaction);
    }
    return String.format("Money: %d sent successfully.", moneyAmount);
  }

  @Override
  public List<CustomerTransactions> getAllTransactionsById(long customerId) {
    List<CustomerTransactions> transactionList = new ArrayList<>();
    List<CustomerTransactions> filteredTransactions = new ArrayList<>();
    customerTransactionsRepository.findAll().forEach(transactionList::add);
    transactionList.forEach(currentTransaction -> {
      if (currentTransaction.getFromAccount().equals(String.valueOf(customerId))) {
        filteredTransactions.add(currentTransaction);
      }
    });
    return filteredTransactions;
  }

  @Override
  public List<CustomerTransactions> getTransactionById(long customerId, long transactionId) {
    List<CustomerTransactions> transactionList = new ArrayList<>();
    List<CustomerTransactions> filteredTransactions = new ArrayList<>();
    List<CustomerTransactions> transactionById = new ArrayList<>();
    customerTransactionsRepository.findAll().forEach(transactionList::add);
    transactionList.forEach(currentTransaction -> {
      if (currentTransaction.getFromAccount().equals(String.valueOf(customerId))) {
        filteredTransactions.add(currentTransaction);
      }
    });
    for (int i = 0; i < filteredTransactions.size(); i++) {
      if (filteredTransactions.get(i).getId() == (transactionId)) {
        transactionById.add(filteredTransactions.get(i));
      }
    }
    return transactionById;
  }
}
