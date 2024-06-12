package com.example.GetRide.service;

import com.example.GetRide.dto.request.CustomerRequest;
import com.example.GetRide.model.Customer;
import com.example.GetRide.repository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRespository customerRespository;

    public String addCustomer(CustomerRequest customerRequest) {
        // dto -> entity
        Customer customer = new Customer();
        customer.setAge(customerRequest.getAge());
        customer.setName(customerRequest.getName());
        customer.setGender(customerRequest.getGender());
        customer.setEmailId(customerRequest.getEmailId());

        Customer savedCustomer = customerRespository.save(customer);
        return "Customer added successfully";
    }

    public Customer getCustomer(String email) {
        return customerRespository.findByEmailId(email);
    }

    public List<Customer> getAllByGenderAndAgeGreaterThan(String gender, int age) {
        return  customerRespository.getAllByGenderAndAgeGreaterThan(gender,age);
    }
}
