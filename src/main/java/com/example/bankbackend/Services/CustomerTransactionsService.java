package com.example.bankbackend.Services;

import com.example.bankbackend.Models.CustomerTransactions;

import java.util.List;

public interface CustomerTransactionsService {
  String sendMoney(long moneyAmount, long senderId, long receiverId);

  List<CustomerTransactions> getAllTransactionsById(long customerId);

  List<CustomerTransactions> getTransactionById(long customerId, long transactionId);
}
