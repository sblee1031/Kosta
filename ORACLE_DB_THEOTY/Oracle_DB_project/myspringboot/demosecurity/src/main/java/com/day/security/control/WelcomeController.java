package com.day.security.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class WelcomeController {
	@RequestMapping("/")
	public String index() {
//		return "semantic_css_jq";
		return "index";
	}
}
