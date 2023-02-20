package com.dingwallsmith.finance.account;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    private final AccountService accountService;
    
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    @GetMapping("/account/list")
    public String list(long providerId, Map<String, Object> model, HttpSession session) {
        List<Account> accountList = accountService.listForProvider(providerId);
        model.put("accountList", accountList);
        model.put("providerId", providerId);
        
        return "accountList";
    }
}
