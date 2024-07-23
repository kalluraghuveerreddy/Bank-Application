package org.codehere.bank.controller;

import lombok.AllArgsConstructor;
import org.codehere.bank.dto.AccountDto;
import org.codehere.bank.dto.BankContactInfoDto;
import org.codehere.bank.service.IAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank")
@AllArgsConstructor
public class AccountController {

    private IAccountService iAccountService;

    private BankContactInfoDto bankContactInfoDto;

    @PostMapping("/openAccount")
    public ResponseEntity<?> createAccount(@RequestBody AccountDto accountDto) {
        Long newAccountNumber = iAccountService.createAccount(accountDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newAccountNumber);
    }

    @GetMapping("/fetch/{accountNumber}")
    public ResponseEntity<AccountDto> fetchAccountByAccNum(@PathVariable Long accountNumber) {
        AccountDto accountDto = iAccountService.fetchAccountDetails(accountNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountDto);
    }

    @GetMapping("/contact-info")
    public ResponseEntity<?> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bankContactInfoDto);
    }
}
