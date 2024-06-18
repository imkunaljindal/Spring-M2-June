package com.example.GetRide.controller;

import com.example.GetRide.Enum.Gender;
import com.example.GetRide.dto.request.CustomerRequest;
import com.example.GetRide.dto.response.CustomerResponse;
import com.example.GetRide.model.Customer;
import com.example.GetRide.service.CustomerService;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

//    @Autowired
//    CustomerService customerService;

    private final CustomerService customerService;

//    public CustomerController(CustomerService customerService){
//        this.customerService = customerService;
//    }

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.addCustomer(customerRequest);
        return new ResponseEntity(customerResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public CustomerResponse getCustomer(@RequestParam("email") String email) {
        return customerService.getCustomer(email);
    }

    @GetMapping("/gender/{gender}/age/{age}")
    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(@PathVariable("gender") Gender gender,
                                                          @PathVariable("age") int age) {
        return customerService.getAllByGenderAndAgeGreaterThan(gender,age);
    }
}
