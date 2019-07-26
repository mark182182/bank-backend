package com.example.bankbackend.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {
  @RequestMapping(value = "/api/login")
  public Principal user(Principal principal) {
    return principal;
  }

  @RequestMapping(value = "/api/logout")
  public String logOut() {
    return "You are logged out.";
  }
}
