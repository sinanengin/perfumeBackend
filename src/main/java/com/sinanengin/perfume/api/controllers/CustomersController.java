package com.sinanengin.perfume.api.controllers;

import com.sinanengin.perfume.business.abstracts.CustomerService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:5173/")
public class CustomersController {
    private final CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping()
    public DataResult<List<Customer>> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/{id}")
    public DataResult<Customer> getCustomerByUserId(@PathVariable int id){
        return customerService.getCustomerByUserId(id);
    }

    @PostMapping()
    public DataResult<Customer> addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
    @DeleteMapping()
    public DataResult<Customer> deleteCustomer(@RequestParam int id){
        return customerService.deleteCustomer(id);
    }

    @PutMapping
    public DataResult<Customer> updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }
}
