package com.spring.bank.service.implementation;

import com.spring.bank.dto.TransactionDto;
import com.spring.bank.entity.Transaction;
import com.spring.bank.mapper.TransactionMapper;
import com.spring.bank.repository.TransactionRepository;
import com.spring.bank.service.TransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionServiceImpl implements TransactionService {

    TransactionRepository transactionRepository;

    @Override
    public TransactionDto getByTransactionId(int id) {
        Transaction transaction = transactionRepository.getById(id);
        return TransactionMapper.mapToTransactionDto(transaction);
    }

    @Override
    public Integer createTransaction(TransactionDto transactionDto) {
        LocalDateTime localDateTime = LocalDateTime.now();
        if (transactionDto.getCreatedAt() == null) {
            transactionDto.setCreatedAt(localDateTime);
        }
        return transactionRepository.save(TransactionMapper.mapToTransactionEntity(transactionDto)).getId();
    }

    @Override
    public void delete(TransactionDto transactionDto) {
        transactionRepository.delete(TransactionMapper.mapToTransactionEntity(transactionDto));

    }

}
