package com.example.bankbackend.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String customerName;
  private String customerAddress;
  private boolean isPremiumCustomer;
  private long accountBalance;

  public Customer(String customerName, String customerAddress, boolean isPremiumCustomer) {
    this.customerName = customerName;
    this.customerAddress = customerAddress;
    this.isPremiumCustomer = isPremiumCustomer;
  }
}
