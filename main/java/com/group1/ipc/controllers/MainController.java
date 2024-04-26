package com.group1.ipc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping(value = "/**/{path:[^\\.]*}")
    public String getIndex() {
        return "forward:/";
    }
	
	@GetMapping("/")
	public String index() {
		return "index.html";
	}
}
