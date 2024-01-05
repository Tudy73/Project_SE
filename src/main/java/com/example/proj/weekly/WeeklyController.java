package com.example.proj.weekly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WeeklyController {

    private final WeeklyService weeklyService;
    @Autowired
    public WeeklyController(WeeklyService weeklyService) {
        this.weeklyService = weeklyService;
    }

    @PostMapping("/addWeeklyData")
    public ResponseEntity<String> addWeeklyData(@RequestBody Weekly weekly) {
        weeklyService.addWeeklyData(weekly);
        return ResponseEntity.ok("Datele au fost adăugate cu succes în baza de date.");
    }

    @RequestMapping("/showWeekly")
    public String showChoicePage() {
        return "showWeekly";
    }

    @GetMapping("/getTableData")
    public ResponseEntity<List<Weekly>> getTableData() {
        return ResponseEntity.ok(weeklyService.getWeeklyData());
    }

    @PostMapping("/deleteCell")
    public ResponseEntity<String> deleteData(@RequestBody List<Weekly> weeklies) {
        weeklyService.deleteData();
        return ResponseEntity.ok("Datele au fost sterse cu succes!");
    }
}
