package com.bancobase.bootcamp.controller;

import com.bancobase.bootcamp.dto.CustomerDTO;
import com.bancobase.bootcamp.dto.CustomerInfoDTO;
import com.bancobase.bootcamp.dto.request.PreCustomerInfo;
import com.bancobase.bootcamp.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
@CrossOrigin(origins = {"*"})
public class CostumerController {
    private CustomerService customerService;

    @Autowired
    public CostumerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public ResponseEntity<List<CustomerInfoDTO>> getCustomers(@RequestParam String name) {
        List<CustomerInfoDTO> customerInfoList = customerService.filterCustomersByName(name);
        return new ResponseEntity<>(customerInfoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a customer with their id")
    public ResponseEntity<CustomerInfoDTO> getCustomerById(@PathVariable Long id) {
        CustomerInfoDTO customerInfo = customerService.getCustomerById(id);
        return new ResponseEntity<>(customerInfo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer (PreCustomerInfo preCustomerInfo) {
        CustomerDTO customer = customerService.createCustomer(preCustomerInfo);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
