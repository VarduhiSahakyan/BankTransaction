package com.spring.bank.service;

import com.spring.bank.dto.BankAccountDto;

public interface BankAccountService {

    BankAccountDto getByAccountId(int id);

    Integer createBankAccount(BankAccountDto bankAccountDto) ;

    void delete(BankAccountDto bankAccountDto);

    void deleteById(Integer id);

}
