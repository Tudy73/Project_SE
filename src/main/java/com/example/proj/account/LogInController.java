package com.example.proj.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LogInController {

    private final AccountService accountService;
    private long currentId=-1;

    @Autowired
    public LogInController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/login")
    public String showLogInPage() {
        return "logIn";
    }
    @RequestMapping("/choice")
    public String showChoicePage() {
        return "choice";
    }
    @RequestMapping("/today")
    public String showTodayPage() {
        return "today";}
    @RequestMapping("/weekly")
    public String showWeeklyPage() {
        return "weekly";
    }
    @RequestMapping("monthly")
    public String showMonthlyPage() {
        return "monthly";
    }
    @RequestMapping("/annual")
    public String showAnnualPage() {
        return "annual";
    }
    @PostMapping("/verificationAccount")    //verifica daca exista account
    public ResponseEntity<Boolean> verificationAccount(@RequestBody AccountRequest accountRequest) {
        long validAccount = accountService.getIdByAccount(accountRequest);
        if (validAccount == -1) {
            return ResponseEntity.ok(false);
        } else {
            currentId=validAccount;
            return ResponseEntity.ok(true);
        }
    }
    @GetMapping("/getIdAccountValue")   //returneaza id account conectat
    public ResponseEntity<Long> getIdAccountValue() {
        return ResponseEntity.ok(currentId);
    }
}
