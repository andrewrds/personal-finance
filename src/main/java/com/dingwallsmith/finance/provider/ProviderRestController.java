package com.dingwallsmith.finance.provider;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderRestController {
    private final ProviderService providerService;
    
    public ProviderRestController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @PostMapping("/provider/create")
    public String create(String name, HttpSession session) {
        providerService.create(name);
        return "";
    }
    
    @PostMapping("/provider/delete")
    public void delete(long id, HttpSession session) {
        providerService.delete(id);
    }
}
