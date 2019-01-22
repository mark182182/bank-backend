package com.example.bankbackend.Services;

import com.example.bankbackend.Models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
  List<Employee> getEmployeeById(long id);
  Employee createEmployee (Employee employee);
}
