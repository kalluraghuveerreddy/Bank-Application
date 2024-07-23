package org.codehere.bank.service.impl;

import lombok.AllArgsConstructor;
import org.codehere.bank.dto.AccountDto;
import org.codehere.bank.entity.Account;
import org.codehere.bank.mapper.AccountMapper;
import org.codehere.bank.repository.AccountRepository;
import org.codehere.bank.service.IAccountService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    @Override
    public Long createAccount(AccountDto accountDto) {
        Account account = accountMapper.mapToAccount(accountDto, new Account());
        Long newAccountNumber = generateAccountNumber();
        account.setAccountNumber(newAccountNumber);
        Account savedAccount = accountRepository.save(account);
        return savedAccount.getAccountNumber();
    }

    private Long generateAccountNumber() {
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        return randomAccNumber;
    }

    @Override
    public AccountDto fetchAccountDetails(Long accountNumber) {
        Account account = accountRepository.findById(accountNumber).get();
        return accountMapper.mapToAccountDto(account, new AccountDto());
    }

    @Override
    public AccountDto updateAccountDetails(AccountDto accountDto) {
        return null;
    }

    @Override
    public AccountDto withdraw(Long accountNumber, BigDecimal amount) {
        Account account = accountRepository.findById(accountNumber).get();
        BigDecimal balance = account.getBalance();
        BigDecimal currentBalance = balance.subtract(amount);
        account.setBalance(currentBalance);
        accountRepository.save(account);
        return accountMapper.mapToAccountDto(account, new AccountDto());
    }

    @Override
    public AccountDto deposit(Long accountNumber, BigDecimal amount) {
        Account account = accountRepository.findById(accountNumber).get();
        BigDecimal balance = account.getBalance();
        BigDecimal currentBalance = balance.add(amount);
        account.setBalance(currentBalance);
        accountRepository.save(account);
        return accountMapper.mapToAccountDto(account, new AccountDto());
    }


}
