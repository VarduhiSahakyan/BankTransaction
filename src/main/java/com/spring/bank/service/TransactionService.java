package com.spring.bank.service;

import com.spring.bank.dto.TransactionDto;

public interface TransactionService {

    TransactionDto getByTransactionId(int id);

    Integer createTransaction(TransactionDto transactionDto);

    void delete(TransactionDto transactionDto);


}
