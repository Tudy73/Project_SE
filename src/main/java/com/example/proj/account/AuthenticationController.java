package com.example.proj.account;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @GetMapping("/successAccount")
    public String showSuccessPage() {
        return "successAccount";
    }

    @GetMapping("/signUp")
    public String showSignUpPage() {
        return "signUp";
    }
    @PostMapping("/signUp")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.register(request));
    }
    @RequestMapping("/login")
    public String showLogInPage() {
       return "logIn";
    }

    @PostMapping("/toChoice")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }
}
