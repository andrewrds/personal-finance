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
    public String list(String providerName, Map<String, Object> model, HttpSession session) {
        List<String> accountList = accountService.listForProvider(providerName);
        model.put("accountList", accountList);
        model.put("providerName", providerName);
        
        return "accountList";
    }
}
