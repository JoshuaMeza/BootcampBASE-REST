package com.bancobase.bootcamp.controllers;

import com.bancobase.bootcamp.dto.*;
import com.bancobase.bootcamp.dto.request.PreCustomerInfo;
import com.bancobase.bootcamp.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customers controller")
@CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST})
public class CustomersController {

    private final CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @Operation(summary = "Get all customers and filter by name")
    public ResponseEntity<List<CustomerInfoDTO>> getCustomers(@RequestParam String name) {
        List<CustomerInfoDTO> customers = this.customerService.filterCustomersByName(name);

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create a new customer")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody PreCustomerInfo information) {
        CustomerDTO savedCustomer = this.customerService.createCustomer(information);

        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }
}