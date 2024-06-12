package com.example.GetRide.controller;

import com.example.GetRide.dto.request.CustomerRequest;
import com.example.GetRide.model.Customer;
import com.example.GetRide.service.CustomerService;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest) {
        String response = customerService.addCustomer(customerRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public Customer getCustomer(@RequestParam("email") String email) {
        return customerService.getCustomer(email);
    }

    @GetMapping("/get-by-age-gender")
    public List<Customer> getAllByGenderAndAgeGreaterThan(@RequestParam("gender") String gender,
                                                          @RequestParam("age") int age) {
        return customerService.getAllByGenderAndAgeGreaterThan(gender,age);
    }
}
