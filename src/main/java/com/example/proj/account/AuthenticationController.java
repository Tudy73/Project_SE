package com.example.proj.account;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
            @RequestBody AuthenticationRequest request,
            HttpServletResponse response
    ){

        AuthenticationResponse auth = service.authenticate(request);
        String token = auth.getToken();

        Cookie authCookie = new Cookie("AUTH_TOKEN", token);
        authCookie.setHttpOnly(true); // This cookie cannot be accessed by JavaScript
        authCookie.setSecure(true); // Cookie will only be sent over HTTPS
        authCookie.setPath("/"); // The cookie is available to all paths

        // Add cookie to response
        response.addCookie(authCookie);

        return ResponseEntity.ok(auth);
    }
}
