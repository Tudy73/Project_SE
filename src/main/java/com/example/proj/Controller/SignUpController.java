package com.example.proj.Controller;

import com.example.proj.Model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignUpController {
    @RequestMapping("/signUp")
    public String showRegisterForm() {
        return "signUp"; // Returnează numele paginii contNou.html
    }
    @RequestMapping("/successAccount")
    public String showSuccessPage() {

        return "successAccount"; // Returnează numele paginii success.html
    }
    @PostMapping("/signUp")
    public String signUp(Account cont, BindingResult bindingResult) {
        String username = cont.getUsername();
        String password = cont.getPassword();
         String firstName=cont.getFirstName();
         String lastName= cont.getLastName();
         String phoneNumber=cont.getPhoneNumber();
         String birthDate=cont.getBirthDate();
         String email=cont.getEmail();
        // Validare parolă în backend
        if (!validatePassword(cont.getPassword())) {
            bindingResult.rejectValue("password", "error.password", "Parola trebuie să conțină caractere speciale, litere mari, cifre si minim 8 caractere.");
        }

        if (bindingResult.hasErrors()) {
            // Dacă sunt erori, redirectează înapoi către formularul de înregistrare
            return "redirect:/signUp";
        }

        // Altă logică pentru salvarea datelor sau procesarea formularului în cazul în care validarea a trecut

        return "redirect:/successAccount"; // Redirectare către o pagină de succes sau altă pagină
    }

    private boolean validatePassword(String password) {
        // Expresie regulată pentru a verifica parola
        String regex = "^(?=.*[!@#$%^&*])(?=.*[A-Z])(?=.*[0-9]).{8,}$";
        return password.matches(regex);
    }
}

