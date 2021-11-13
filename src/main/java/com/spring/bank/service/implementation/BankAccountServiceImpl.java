package com.spring.bank.service.implementation;

import com.spring.bank.dto.BankAccountDto;
import com.spring.bank.entity.BankAccount;
import com.spring.bank.mapper.BankAccountMapper;
import com.spring.bank.repository.BankAccountRepository;
import com.spring.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public BankAccountDto getByAccountId(int id) {
        BankAccount bankAccount = bankAccountRepository.getById(id);
        return BankAccountMapper.mapToDtoBA(bankAccount);
    }

    @Override
    public Integer createBankAccount(BankAccountDto bankAccountDto) {
        LocalDateTime localDateTime = LocalDateTime.now();
        if (bankAccountDto.getCreatedAt() == null) {
            bankAccountDto.setCreatedAt(localDateTime);
        }
        return bankAccountRepository.save(BankAccountMapper.mapToEntityBA(bankAccountDto)).getId();
    }

    @Override
    public void delete(BankAccountDto bankAccountDto) {
        bankAccountRepository.delete(BankAccountMapper.mapToEntityBA(bankAccountDto));

    }


    @Override
    public void deleteById(Integer id) {
        BankAccount bankAccount = bankAccountRepository.getById(id);
        bankAccountRepository.delete(bankAccount);

    }
}
