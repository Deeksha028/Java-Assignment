package com.wipro.rest.jpa.restcontroller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @GetMapping("/msg")
    public String msg() {
        return "Loan Service Working ✅";
    }
}