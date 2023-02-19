package com.dingwallsmith.finance.account;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
    private final AccountService accountService;
    
    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account/create")
    public String create(String providerName, String accountName, HttpSession session) {
    	accountService.create(providerName, accountName);
        return "";
    }
    
    @PostMapping("/account/delete")
    public String delete(String name, HttpSession session) {
    	accountService.delete(name);
        return "";
    }
}
