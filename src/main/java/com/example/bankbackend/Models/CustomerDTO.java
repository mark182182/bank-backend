package com.example.bankbackend.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO {
  private String customerName;
  private String customerAddress;
  private boolean isPremiumCustomer;
  private long accountBalance;

  public CustomerDTO(String customerName, String customerAddress, boolean isPremiumCustomer) {
    this.customerName = customerName;
    this.customerAddress = customerAddress;
    this.isPremiumCustomer = isPremiumCustomer;
  }
}
