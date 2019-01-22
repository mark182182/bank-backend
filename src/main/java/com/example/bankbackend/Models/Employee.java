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
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String employeeName;
  private String employeePassword;

  public Employee(long id, String employeeName, String employeePassword) {
    this.id = id;
    this.employeeName = employeeName;
    this.employeePassword = employeePassword;
  }

}
