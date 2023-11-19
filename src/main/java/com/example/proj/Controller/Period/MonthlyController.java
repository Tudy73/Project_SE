package com.example.proj.Controller.Period;

import org.springframework.web.bind.annotation.RequestMapping;

public class MonthlyController {
    @RequestMapping("/monthly")
    public String showRegisterForm() {
        return "monthly"; // Returnează numele paginii annual.html
    }
}
