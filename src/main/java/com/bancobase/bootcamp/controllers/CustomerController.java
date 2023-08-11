package com.bancobase.bootcamp.controllers;

import com.bancobase.bootcamp.dto.CustomerInfoDTO;
import com.bancobase.bootcamp.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@Tag(name = "Customer controller")
@CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST})
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a customer with their id")
    public ResponseEntity<CustomerInfoDTO> getCustomerById(@PathVariable Long id) {
        CustomerInfoDTO customerInfo = customerService.getCustomerById(id);
        return new ResponseEntity<>(customerInfo, HttpStatus.OK);
    }
}
