package com.spring.bank.mapper;

import com.spring.bank.dto.TransactionDto;
import com.spring.bank.entity.Transaction;

import org.modelmapper.ModelMapper;


public class TransactionMapper {
    public static TransactionDto mapToSimpleDto(Transaction transaction) {
        ModelMapper modelMapper = new ModelMapper();
        TransactionDto transactionDto = modelMapper.map(transaction, TransactionDto.class);

        return  transactionDto;

    }


}





