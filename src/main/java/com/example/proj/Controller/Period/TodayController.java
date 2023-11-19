package com.example.proj.Controller.Period;

import org.springframework.web.bind.annotation.RequestMapping;

public class TodayController {
    @RequestMapping("/today")
    public String showRegisterForm() {
        return "today"; // Returnează numele paginii annual.html
    }
}
