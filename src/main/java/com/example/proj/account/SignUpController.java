package com.example.proj.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignUpController {

    private final AccountService accountService;

    @Autowired
    public SignUpController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/signUp")
    public String showSignUpPage() {
        return "signUp";
    }

    @RequestMapping("/successAccount")
    public String showSuccessPage() {
        return "successAccount";
    }

    @PostMapping("/signUp")
    public String signUp(@RequestParam String username,
                                         @RequestParam String password,
                                         @RequestParam String firstName,
                                         @RequestParam String lastName,
                                         @RequestParam String phoneNumber,
                                         @RequestParam String birthDate,
                                         @RequestParam String email) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setPhoneNumber(phoneNumber);
        account.setBirthDate(birthDate);
        account.setEmail(email);
        // Validează parola
//        if (account.getPassword() != null && !validatePassword(account.getPassword())) {
//            bindingResult.rejectValue("password", "error.password", "Parola trebuie să conțină caractere speciale, litere mari, cifre și să aibă minim 8 caractere.");
//        }
        accountService.addAccount(account);

        showSuccessPage();

        return "redirect:/successAccount";
    }


    private boolean validatePassword(String password) {
        String regex = "^(?=.*[!@#$%^&*])(?=.*[A-Z])(?=.*[0-9]).{8,}$";
        return password.matches(regex);
    }
}

