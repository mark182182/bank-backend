package com.example.bankbackend.Services;

import com.example.bankbackend.Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bankbackend.Repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
  @Autowired
  EmployeeRepository employeeRepository;

  @Override
  public List<Employee> getEmployeeById(long id) {
    List<Employee> getEmployee = new ArrayList<>();
    getEmployee.add(employeeRepository.findById(id).get());
    return getEmployee;
  }

  @Override
  public Employee createEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }
}
