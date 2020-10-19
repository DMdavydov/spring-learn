package com.ddavydov.service;

import com.ddavydov.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final HashMap<Long, Customer> customers = new HashMap<>();
    private final AtomicLong atomicLong = new AtomicLong(1);

    public List<Customer> getCustomers() {
        return new ArrayList<>(customers.values());
    }

    public Customer getCustomer(Long id) {
        return customers.get(id);
    }

    public Customer saveCustomer(Customer customer) {
        customer.setId(atomicLong.get());
        return customers.put(atomicLong.getAndIncrement(), customer);
    }

    public Customer updateCustomer(Customer customer) {
        return customers.replace(customer.getId(), customer);
    }

    public void deleteCustomer(Long id) {
        customers.remove(id);
    }
}
