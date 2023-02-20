package com.dingwallsmith.finance.account;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dingwallsmith.finance.provider.Provider;
import com.dingwallsmith.finance.provider.ProviderService;

@Controller
public class AccountController {
	private final ProviderService providerService;
    private final AccountService accountService;
    
    public AccountController(ProviderService providerService, AccountService accountService) {
    	this.providerService = providerService;
        this.accountService = accountService;
    }
    
    @GetMapping("/account/list")
    public String list(long providerId, Map<String, Object> model, HttpSession session) {
    	Provider provider = providerService.find(providerId);
        model.put("provider", provider);
    	
        List<Account> accountList = accountService.listForProvider(provider);
        model.put("accountList", accountList);
        
        return "accountList";
    }
}
