package com.spring.bank.mapper;

import com.spring.bank.dto.BankAccountDto;
import com.spring.bank.entity.BankAccount;

import java.util.stream.Collectors;


public final class BankAccountMapper {
    public static BankAccountDto mapToDtoBA(BankAccount bankAccount) {
        BankAccountDto bankAccountDto = new BankAccountDto();
        bankAccountDto.setId(bankAccount.getId());
        bankAccountDto.setBalance(bankAccount.getBalance());
        bankAccountDto.setUser(bankAccount.getUser());
        bankAccountDto.setTransactions(bankAccount.getTransactions()
                .stream()
                .map(TransactionMapper::mapToTransactionDto)
                .collect(Collectors.toSet()));
        return bankAccountDto;

    } public static BankAccount mapToEntityBA(BankAccountDto accountDto) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(accountDto.getId());
        bankAccount.setBalance(accountDto.getBalance());
        bankAccount.setUser(accountDto.getUser());
        bankAccount.setTransactions(accountDto.getTransactions()
                .stream()
                .map(TransactionMapper::mapToTransactionEntity)
                .collect(Collectors.toSet()));
        return bankAccount;
    }


}