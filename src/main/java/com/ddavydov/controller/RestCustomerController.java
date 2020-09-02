package com.ddavydov.controller;

import com.ddavydov.entity.Customer;
import com.ddavydov.exception.CustomerNotFoundException;
import com.ddavydov.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class RestCustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> listCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer showForm(@PathVariable("customerId") int id) {
        Customer customer = customerService.getCustomer(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found - " + id);
        }
        return customer;
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping
    public Customer showFormForUpdate(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/{customerId}")
    public void delete(@PathVariable("customerId") int id) {
        Customer customer = customerService.getCustomer(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found - " + id);
        }
        customerService.deleteCustomer(id);
    }
}
