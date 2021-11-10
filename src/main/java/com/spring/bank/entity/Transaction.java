package com.spring.bank.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@RequiredArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;


    @Column(name = "transaction_status")
    private String transactionStatus;

    @Column(name = "transaction_sum")
    private Double transactionSum;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;


    public void setId(Integer id) {
        this.id = id;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public void setTransactionSum(Double transactionSum) {
        this.transactionSum = transactionSum;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Transaction that = (Transaction) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
