package com.spring.bank.controller;

import com.spring.bank.dto.BankAccountDto;
import com.spring.bank.dto.UserDto;
import com.spring.bank.service.BankAccountService;
import com.spring.bank.service.TransactionService;
import com.spring.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank")
public class BankController {


    @Autowired
    UserService userService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    BankAccountService bankAccountService;

    @PostMapping("/user/create/{id}")
    public long createUser( @RequestBody UserDto user) {

        return userService.createUser(user);
    }

    @PutMapping("/user/update/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody UserDto userDto) {

        userService.createUser(userDto);
    }

    @GetMapping("/user/get/{id}")
    public UserDto getUserById(@PathVariable Integer id) {

        return userService.getById(id);
    }

    @PostMapping("/create_bank_account/{id}")
    public Integer createBankAccount(@PathVariable Integer id, @RequestBody BankAccountDto bankAccountDto) {
        return bankAccountService.createBankAccount(bankAccountDto);

    }


}
