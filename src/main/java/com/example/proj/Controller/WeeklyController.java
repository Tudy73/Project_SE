package com.example.proj.Controller;

import com.example.proj.Model.Saptamanal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public class WeeklyController {
    @RequestMapping("/weekly")
    public String showRegisterForm() {
        return "weekly"; // Returnează numele paginii annual.html
    }
    @PostMapping("/weekly")
    public String saveData(@RequestBody Saptamanal data) {

        System.out.println( "Datele au fost salvate cu succes: Ziua: " + data.getDay() + ", Text: " + data.getText());
            return "Datele au fost salvate cu succes: Ziua: " + data.getDay() + ", Text: " + data.getText();
    }
}
