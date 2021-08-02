package com.day.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MVCController {
	
	@GetMapping("/a")
	public void a(String id) {
		System.out.println(id);
	}
}
