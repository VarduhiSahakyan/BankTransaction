package com.spring.bank.mapper;

import com.spring.bank.dto.TransactionDto;
import com.spring.bank.entity.Transaction;

import org.modelmapper.ModelMapper;


public final class TransactionMapper {
    public static TransactionDto mapToTransactionDto(Transaction transaction) {
        ModelMapper modelMapper = new ModelMapper();
        TransactionDto transactionDto = modelMapper.map(transaction, TransactionDto.class);

        return  transactionDto;

    }


    public static Transaction mapToTransactionEntity(TransactionDto transactionDto) {
        ModelMapper modelMapper = new ModelMapper();
        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);


        return transaction;
    }

}





