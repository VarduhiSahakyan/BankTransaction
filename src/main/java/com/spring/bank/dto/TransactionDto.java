package com.spring.bank.dto;

import com.spring.bank.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor

public class TransactionDto {

    private Integer id;
    private LocalDateTime createdAt;
    private String transactionType;
    private String transactionStatus;
    private Double transactionSum;
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDto that = (TransactionDto) o;
        return Objects.equals(id, that.id) && Objects.equals(createdAt, that.createdAt) && Objects.equals(transactionType, that.transactionType) && Objects.equals(transactionStatus, that.transactionStatus) && Objects.equals(transactionSum, that.transactionSum) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, transactionType, transactionStatus, transactionSum, user);
    }
}
