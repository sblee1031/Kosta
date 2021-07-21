package com.day.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	@GetMapping("/")
	public String index() {
		return "semantic_css_jq";
	}
	
}
