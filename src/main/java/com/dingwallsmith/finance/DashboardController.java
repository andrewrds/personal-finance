package com.dingwallsmith.finance;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
    @GetMapping("/dashboard")
    public String simpleDateFormat(HttpSession session) {
        return "<h1>Hello World!</h1>";
    }
}
