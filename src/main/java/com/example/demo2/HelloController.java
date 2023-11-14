package com.example.demo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        Connect q = new Connect("cont");
        StringBuilder returnedString = new StringBuilder(" ");
        for (int i = 0; i < q.tableSize("hello"); i++) {
            returnedString.append(q.getName(i)).append(" ");
        }
        return returnedString.toString();
    }
}
