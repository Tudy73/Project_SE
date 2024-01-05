package com.example.proj.monthly;

import com.example.proj.color.Color;
import com.example.proj.color.ColorService;
import com.example.proj.today.Today;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.util.List;


@Controller
public class MonthlyController {

    private int number;

    private final MonthlyService monthlyService;
    private final ColorService colorService;

    @Autowired
    public MonthlyController(MonthlyService monthlyService, ColorService colorService) {
        this.monthlyService = monthlyService;
        this.colorService = colorService;
    }

    @PostMapping("/saveSquare")
    public ResponseEntity<String> squareNumber(@RequestBody int numberAsString) {
        number = numberAsString;
        return ResponseEntity.ok("Success");
    }

    @RequestMapping("/addMonthly")
    public String showChoicePage() {
        return "addMonthly";
    }

    @GetMapping("/number")
    public ResponseEntity<Integer> getnumber() {
        return ResponseEntity.ok(number);
    }

    @PostMapping("/saveMonthly")
    public ResponseEntity<String> saveMonthly(@RequestBody List<Monthly> monthlyList) {
        monthlyService.saveMonthly(monthlyList);
        return ResponseEntity.ok("Datele au fost salvate cu succes!");
    }

    @PostMapping("/saveColor")
    public ResponseEntity<String> saveColor(@RequestBody Color color) {
        colorService.addColor(color);
        return ResponseEntity.ok("Datele au fost salvate cu succes!");
    }

    @GetMapping("/getColorList")
    public ResponseEntity<List<Color>> getColorList() {
        return ResponseEntity.ok(colorService.getColorList());
    }

    @GetMapping("/getMonthlyData")
    public ResponseEntity<List<Today>> getMonthlyData() {
        return ResponseEntity.ok(monthlyService.getMonthlyData(number));
    }

    @DeleteMapping("/deleteMonthly")
    public ResponseEntity<String> deleteData(@RequestBody List<Monthly> monthlyList) {
        System.out.println("\nthe list: ");
        for(Monthly monthly : monthlyList){
            System.out.println(monthly);
        }
        System.out.println("end list");
        monthlyService.deleteMonthly(monthlyList);
        return ResponseEntity.ok("Datele au fost sterse cu succes!");
    }

}
