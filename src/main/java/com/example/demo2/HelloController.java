package com.example.demo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        Connection connection = new Connection("cont");
        StringBuilder returnedString = new StringBuilder(" ");
        for (int i = 0; i < connection.tableSize("hello"); i++) {
            returnedString.append(connection.getName(i)).append(" ");
        }
        return returnedString.toString();
    }
}
