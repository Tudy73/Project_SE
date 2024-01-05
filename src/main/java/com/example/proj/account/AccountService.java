package com.example.proj.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public long getIdByAccount(AccountRequest accountRequest) {
        Optional<Account> accountId = accountRepository.findByAccount(accountRequest.getPassword(),accountRequest.getUsername());
        long returnId=-1;
        if(accountId.isPresent()){
            returnId=accountId.get().getId();
        }
        return returnId;
    }

    public void addAccount(Account account) {
        accountRepository.save(account);
    }
}
