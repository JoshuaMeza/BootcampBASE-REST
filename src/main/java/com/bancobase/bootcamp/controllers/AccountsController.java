package com.bancobase.bootcamp.controllers;

import com.bancobase.bootcamp.dto.AccountDTO;
import com.bancobase.bootcamp.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@Tag(name = "Accounts controller")
@CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST})
public class AccountsController {
    private final AccountService accountService;

    public AccountsController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/customer/{id}")
    @Operation(summary = "Get all accounts of customer")
    public ResponseEntity<List<AccountDTO>> getAccountsByCustomerId(@PathVariable Long id) {
        List<AccountDTO> accounts = accountService.getAllAccountsByCustomerId(id);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}
