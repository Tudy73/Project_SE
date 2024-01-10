package com.example.proj.weekly;

import com.example.proj.today.Today;
import com.example.proj.today.TodayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WeeklyController {

    private final WeeklyService weeklyService;
    private final TodayService todayService;
    @Autowired
    public WeeklyController(WeeklyService weeklyService, TodayService todayService) {
        this.weeklyService = weeklyService;
        this.todayService = todayService;
    }

    @PostMapping("/addWeeklyData")
    public ResponseEntity<String> addWeeklyData(@RequestBody Weekly weekly) {
        weeklyService.addWeeklyData(weekly);
        Today newToday = new Today(weekly.getImage(),weekly.getText(),weekly.getHour());
        todayService.addToday(newToday);
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

    @DeleteMapping("/deleteCell")
    public ResponseEntity<String> deleteData(@RequestBody List<Weekly> weeklies) {
        weeklyService.deleteData(weeklies);
        return ResponseEntity.ok("Datele au fost sterse cu succes!");
    }

}
