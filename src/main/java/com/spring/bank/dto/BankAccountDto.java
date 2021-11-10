package com.spring.bank.dto;

import com.spring.bank.entity.User;

import java.time.LocalDate;

public class BankAccountDto {


    private Integer id;
    private int balance;
    private LocalDate createdAt;
    private User user;

    public BankAccountDto() {
    }

    public BankAccountDto(Integer id, int balance, LocalDate createdAt, User user) {
        this.id = id;
        this.balance = balance;
        this.createdAt = createdAt;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
