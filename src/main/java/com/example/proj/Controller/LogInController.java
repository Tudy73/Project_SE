package com.example.proj.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogInController {
    @GetMapping("/logIn")
    public String index() {
        return "logIn";
    }
    @RequestMapping("/choice")
    public String showChoicePage() {
        return "choice"; // Returnează numele paginii annual.html
    }

    @RequestMapping("/today") // Modifică ruta în funcție de calea către fișierul HTML "annual.html"
    public String showTodayPage() {
        return "today"; // Returnează numele paginii annual.html
    }
    @RequestMapping("/weekly") // Modifică ruta în funcție de calea către fișierul HTML "annual.html"
    public String showWeeklyPage() {
        return "weekly"; // Returnează numele paginii annual.html
    }
    @RequestMapping("/monthly") // Modifică ruta în funcție de calea către fișierul HTML "annual.html"
    public String showMonthlyPage() {
        return "monthly"; // Returnează numele paginii annual.html
    }
    @RequestMapping("/annual") // Modifică ruta în funcție de calea către fișierul HTML "annual.html"
    public String showAnnualPage() {
        return "annual"; // Returnează numele paginii annual.html
    }

}
