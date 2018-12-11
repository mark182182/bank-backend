package com.example.bankbackend.Controllers;

import com.example.bankbackend.Models.Customer;
import com.example.bankbackend.Models.CustomerDTO;
import com.example.bankbackend.Services.CustomerService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/api/accounts")
public class HomeController {
  @Autowired
  CustomerService customerService;

  @PostMapping("/add")
  @ResponseBody
  String addNewCustomer(@RequestBody Customer newCustomer) {
    System.out.println(newCustomer.getCustomerName() + newCustomer.getCustomerAddress() + newCustomer.isPremiumCustomer());
    customerService.addAccount(newCustomer);
    return "Saved into database";
  }

  @GetMapping("/all")
  @ResponseBody
  public String viewAllAccounts() {
    List<Customer> customerList = customerService.getAllAccounts();
    return JSONObject.valueToString(customerList);
  }

  @GetMapping("/{id}")
  @ResponseBody
  public String viewAccount(@PathVariable(name = "id") long accountId) {
    List<Customer> customer = customerService.findById(accountId);
    return JSONObject.valueToString(customer);
  }
}
