package com.spring.bank.mapper;

import com.spring.bank.dto.UserDto;
import com.spring.bank.entity.User;

import java.util.stream.Collectors;


public final class UserMapper   {
    private UserMapper() {
    }

    public static UserDto mapToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setAge(user.getAge());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        userDto.setCreatedAt(user.getCreateAt());

        userDto.setTransactionDtoSet(user.getTransactions()
                .stream()
                .map(TransactionMapper::mapToTransactionDto)
                .collect(Collectors.toSet()));


        userDto.setBankAccounts(user.getBankAccounts()
                .stream().
                map(BankAccountMapper::mapToDtoBA)
                .collect(Collectors.toSet()));



        return userDto;

    }


    public static User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAge(userDto.getAge());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        user.setCreateAt(userDto.getCreatedAt());
        user.setTransactions(userDto.getTransactionDtoSet()
                .stream()
                .map(TransactionMapper::mapToTransactionEntity)
                .collect(Collectors.toSet()));
        user.setBankAccounts(userDto.getBankAccounts()
                .stream()
                .map(BankAccountMapper::mapToEntityBA)
                .collect(Collectors.toSet()));
        return user;


    }
}
