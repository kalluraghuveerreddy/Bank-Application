package org.codehere.bank.mapper;

import org.codehere.bank.dto.AccountDto;
import org.codehere.bank.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto, Account account) {
        account.setAccountHolderName(accountDto.getAccountHolderName());
        account.setBalance(accountDto.getBalance());
        return account;
    }


    public static AccountDto mapToAccountDto(Account account, AccountDto accountDto) {
        accountDto.setAccountHolderName(account.getAccountHolderName());
        accountDto.setBalance(account.getBalance());
        return accountDto;
    }
}
