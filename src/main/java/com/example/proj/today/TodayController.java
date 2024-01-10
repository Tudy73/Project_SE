package com.example.proj.today;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodayController {
    private  String dayOfWeek;
    private  String dayOfMonth;

    private final TodayService todayService;

    @Autowired
    public TodayController(TodayService todayService) {
        this.todayService = todayService;
    }

    @PostMapping("/saveData")
    public ResponseEntity<String> saveData(@RequestBody List<Today> todayList) {
        todayService.saveData(todayList);
        return ResponseEntity.ok("Datele au fost salvate cu succes!");
    }

    @PostMapping("/saveDayOfWeek")
    public ResponseEntity<String> saveDayOfWeek(@RequestBody String dayOfWeekData) {
        dayOfWeek = dayOfWeekData.replaceAll("^\"|\"$", "");
        return ResponseEntity.ok("Ziua săptămânii a fost salvată cu succes!");
    }
    @PostMapping("/saveDayOfMonth")
    public ResponseEntity<String> saveDayOfMonth(@RequestBody String dayOfMonthData) {
        dayOfMonth = dayOfMonthData;
        return ResponseEntity.ok("Ziua lunii a fost salvată cu succes!");
    }

    @GetMapping("/getTodayData")
    public ResponseEntity<List<Today>> getTodayDataByAccountId() {
        return ResponseEntity.ok(todayService.getTodayDataByAccountId());
    }
    @DeleteMapping("/deleteData")
    public ResponseEntity<String> deleteData(@RequestBody List<Today> todayList) {
        System.out.println("ce faci aici");
        todayService.deleteData(todayList);
        return ResponseEntity.ok("Datele au fost sterse cu succes!");
    }
}
