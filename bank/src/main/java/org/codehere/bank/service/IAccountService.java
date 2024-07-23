package org.codehere.bank.service;

import org.codehere.bank.dto.AccountDto;

import java.math.BigDecimal;

public interface IAccountService {

    Long createAccount(AccountDto accountDto);

    AccountDto fetchAccountDetails(Long accountNumber);

    AccountDto updateAccountDetails(AccountDto accountDto);

    AccountDto withdraw(Long accountNumber, BigDecimal amount);

    AccountDto deposit(Long accountNumber, BigDecimal amount);

}
