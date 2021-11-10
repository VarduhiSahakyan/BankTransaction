package com.spring.bank.dto;

import com.spring.bank.entity.enums.Role;
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

public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Set<TransactionDto> transactionDtoSet;
    private int age;
    private String username;
    private String password;
    private LocalDateTime createdAt;
    private Role role;
    private Set<BankAccountDto> bankAccounts;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return age == userDto.age && Objects.equals(id, userDto.id) && Objects.equals(firstName, userDto.firstName) && Objects.equals(lastName, userDto.lastName) && Objects.equals(transactionDtoSet, userDto.transactionDtoSet) && Objects.equals(username, userDto.username) && Objects.equals(password, userDto.password) && Objects.equals(createdAt, userDto.createdAt) && role == userDto.role && Objects.equals(bankAccounts, userDto.bankAccounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, transactionDtoSet, age, username, password, createdAt, role, bankAccounts);
    }
}
