package com.spring.bank.dto;

import com.spring.bank.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BankAccountDto {


    private Integer id;
    private int balance;
    private LocalDateTime createdAt;
    private User user;
    private Set<TransactionDto> transactions;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccountDto that = (BankAccountDto) o;
        return balance == that.balance && Objects.equals(id, that.id) && Objects.equals(createdAt, that.createdAt) && Objects.equals(user, that.user) && Objects.equals(transactions, that.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, createdAt, user, transactions);
    }
}
