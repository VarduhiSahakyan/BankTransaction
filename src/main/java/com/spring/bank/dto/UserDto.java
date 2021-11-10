package com.spring.bank.dto;

import com.spring.bank.entity.enums.Role;
import java.time.LocalDate;
import java.util.Set;


public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Set<TransactionDto> transactionDtoSet;
    private int age;
    private String username;
    private String password;
    private LocalDate createdAt;
    private Role role;
    private Set<BankAccountDto> bankAccounts;



    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastName, Set<TransactionDto> transactions, int age,
                   String username, String password, Role role, Set<BankAccountDto> bankAccounts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.transactionDtoSet = transactions;
        this.age = age;
        this.username = username;
        this.password = password;
        this.role = role;
        this.bankAccounts = bankAccounts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<TransactionDto> getTransactionDtoSet() {
        return transactionDtoSet;
    }

    public void setTransactionDtoSet(Set<TransactionDto> transactionDtoSet) {
        this.transactionDtoSet = transactionDtoSet;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Set<BankAccountDto> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Set<BankAccountDto> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
