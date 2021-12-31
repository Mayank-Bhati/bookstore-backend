package com.mayank.mayankbookstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FirstController {
    @GetMapping("welcome")
    public String getData(){
        return "userLogin";
    }
}
