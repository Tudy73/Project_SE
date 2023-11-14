package com.example.demo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
public String hello(){
        Connect q=new Connect("cont");
        String s=" ";
for(int i=0;i<q.ultimul_index("hello");i++)
{
    s+=q.getName(i)+" ";
}
    return s;
}
}
