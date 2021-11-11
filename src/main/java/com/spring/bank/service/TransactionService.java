package com.spring.bank.service;

import com.spring.bank.dto.TransactionDto;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

    TransactionDto getByTransactionId(int id);

    Integer createTransaction(TransactionDto transactionDto);

    void delete(TransactionDto transactionDto);

    void deleteById(Integer id);
}
