package com.spring.bank.dto;

import com.spring.bank.entity.User;

import java.time.LocalDate;

public class TransactionDto {

    private Integer id;
    private LocalDate createdAt;
    private String transactionType;
    private String transactionStatus;
    private Double transactionSum;
    private User user;

    public TransactionDto() {
    }

    public TransactionDto(Integer id, LocalDate createdAt, String transactionType,
                          String transactionStatus, Double transactionSum, User user) {
        this.id = id;
        this.createdAt = createdAt;
        this.transactionType = transactionType;
        this.transactionStatus = transactionStatus;
        this.transactionSum = transactionSum;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Double getTransactionSum() {
        return transactionSum;
    }

    public void setTransactionSum(Double transactionSum) {
        this.transactionSum = transactionSum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
