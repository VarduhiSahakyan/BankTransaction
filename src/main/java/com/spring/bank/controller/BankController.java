package com.spring.bank.controller;

import com.spring.bank.dto.BankAccountDto;
import com.spring.bank.dto.UserDto;
import com.spring.bank.entity.BankAccount;
import com.spring.bank.entity.User;
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

    @PostMapping("/user/{id}")
    public long createUser(@PathVariable int id, @RequestBody UserDto user) {

        return userService.createUser(user);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable int id, @RequestBody UserDto userDto) {

        userService.createUser(userDto);
    }

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable String id) {

        return userService.getById(Integer.parseInt(id));
    }
    @PostMapping("/create_bank_account/{id}")
    public Integer createBankAccount(@PathVariable int id, @RequestBody BankAccountDto bankAccountDto){
        return bankAccountService.createBankAccount(bankAccountDto);


    }


}
