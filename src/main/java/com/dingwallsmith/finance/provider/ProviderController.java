package com.dingwallsmith.finance.provider;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProviderController {
	private final ProviderService providerService;
	
    public ProviderController(ProviderService providerService) {
		this.providerService = providerService;
	}
    
	@GetMapping("/provider/list")
    public String list(Map<String, Object> model, HttpSession session) {
		List<String> providerList = providerService.list();
		model.put("providerList", providerList);
		
        return "providerList";
    }
}
