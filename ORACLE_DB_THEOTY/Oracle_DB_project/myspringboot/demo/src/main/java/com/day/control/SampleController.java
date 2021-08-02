package com.day.control;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "hi";
	}
	@PostMapping("/add")
	public String add(@RequestBody Map<String, String> map) {
		return map.get("id");
	}
}
