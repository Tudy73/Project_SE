package com.example.proj.account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChoiceController {
    @GetMapping("/choice")
    public String showChoicePage() {
        return "choice";
    }
    @GetMapping("/today")
    public String showTodayPage() {
        return "today";}
    @GetMapping("/weekly")
    public String showWeeklyPage() {
        return "weekly";
    }
    @GetMapping("monthly")
    public String showMonthlyPage() {
        return "monthly";
    }
    @GetMapping("/annual")
    public String showAnnualPage() {
        return "annual";
    }
}
