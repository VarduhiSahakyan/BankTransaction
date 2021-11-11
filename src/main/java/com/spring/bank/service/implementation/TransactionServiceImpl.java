package com.spring.bank.service.implementation;

import com.spring.bank.dto.TransactionDto;
import com.spring.bank.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {
    @Override
    public TransactionDto getByTransactionId(int id) {
        return null;
    }

    @Override
    public Integer createTransaction(TransactionDto transactionDto) {
        return null;
    }

    @Override
    public void delete(TransactionDto transactionDto) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
