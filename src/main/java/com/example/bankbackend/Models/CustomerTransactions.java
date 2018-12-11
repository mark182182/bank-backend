package com.example.bankbackend.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomerTransactions {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ManyToOne
  @JoinColumn(name = "accountId", referencedColumnName = "id")
  private Customer accountId;

  private String dateOfTransaction;
  private String fromAccount;
  private String toAccount;
  private long transferAmount;

  public CustomerTransactions(String dateOfTransaction, String fromAccount, String toAccount, Long transferAmount, Customer accountId) {
    this.dateOfTransaction = dateOfTransaction;
    this.fromAccount = fromAccount;
    this.toAccount = toAccount;
    this.transferAmount = transferAmount;
    this.accountId = accountId;
  }
}
