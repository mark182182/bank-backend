package com.example.bankbackend.Controllers;

import com.example.bankbackend.Models.CustomerTransactions;
import com.example.bankbackend.Services.CustomerTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
  private CustomerTransactionsService customerTransactionsService;

  @Autowired
  public TransactionController(CustomerTransactionsService customerTransactionsService) {
    this.customerTransactionsService = customerTransactionsService;
  }

  @PostMapping("/send")
  public String makeTransaction(@RequestParam("moneyAmount") long moneyAmount, @RequestParam("senderId") long senderId, @RequestParam("receiverId") long receiverId)

  {
    return customerTransactionsService.sendMoney(moneyAmount, senderId, receiverId);
  }

  @GetMapping("/{id}/all")
  public List getAllDollaz(@PathVariable(name = "id") long customerId) {
    List<CustomerTransactions> transactionsList = customerTransactionsService.getAllTransactionsById(customerId);
    return transactionsList;
  }

  @GetMapping("/{id}/{transactionId}")
  public List getDollazById(@PathVariable(name = "id") long customerId, @PathVariable(name = "transactionId") long transactionId) {
    List<CustomerTransactions> transactionById = customerTransactionsService.getTransactionById(customerId, transactionId);
    return transactionById;
  }

}
