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
@RequestMapping("/customer")
public class CustomerController {

//    private final CustomerService customerService;
//
//    @GetMapping("/list")
//    public String listCustomers(Model model) {
//        List<Customer> customerList = customerService.getCustomers();
//
//        model.addAttribute("customers", customerList);
//
//        return "list-customers";
//    }
//
//    @GetMapping("/showFormForAdd")
//    public String showForm(Model model) {
//
//        Customer customer = new Customer();
//
//        model.addAttribute("customer", customer);
//
//        return "customer-form";
//    }
//
//    @PostMapping("/saveCustomer")
//    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
//
//        customerService.saveCustomer(customer);
//
//        return "redirect:/customer/list";
//    }
//
//    @GetMapping("/showFormForUpdate")
//    public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
//
//        Customer customer = customerService.getCustomer(id);
//
//        model.addAttribute("customer", customer);
//
//        return "customer-form";
//    }
//
//    @GetMapping("/delete")
//    public String delete(@RequestParam("customerId") int id) {
//
//        customerService.deleteCustomer(id);
//
//        return "redirect:/customer/list";
//    }
}
