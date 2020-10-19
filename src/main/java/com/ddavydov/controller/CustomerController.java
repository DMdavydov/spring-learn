package com.ddavydov.controller;

import com.ddavydov.entity.Customer;
import com.ddavydov.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> customerList = customerService.getCustomers();

        model.addAttribute("customers", customerList);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model model) {

        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        if (customerService.getCustomer(customer.getId()) == null) {
            customerService.saveCustomer(customer);
        }
        customerService.updateCustomer(customer);

        return "redirect:/customers/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") Long id, Model model) {

        Customer customer = customerService.getCustomer(id);

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") Long id) {

        customerService.deleteCustomer(id);

        return "redirect:/customers/list";
    }
}
