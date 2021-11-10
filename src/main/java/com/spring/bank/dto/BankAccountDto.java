package com.spring.bank.dto;

import com.spring.bank.entity.User;

import java.time.LocalDate;
import java.util.Set;

public class BankAccountDto {


    private Integer id;
    private int balance;
    private LocalDate createdAt;
    private User user;
    private Set<TransactionDto> transactions;

    public BankAccountDto() {
    }

    public BankAccountDto(Integer id, int balance, LocalDate createdAt, User user) {
        this.id = id;
        this.balance = balance;
        this.createdAt = createdAt;
        this.user = user;
    }

    public BankAccountDto(Integer id, int balance, LocalDate createdAt,
                          User user, Set<TransactionDto> transactions) {
        this.id = id;
        this.balance = balance;
        this.createdAt = createdAt;
        this.user = user;
        this.transactions = transactions;
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

    public Set<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionDto> transactions) {
        this.transactions = transactions;
    }

}
