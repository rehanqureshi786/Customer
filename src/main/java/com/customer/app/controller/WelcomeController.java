package com.customer.app.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WelcomeController {

	@GetMapping("/")
	public String index(Model model)
	{
		return "redirect:/index";
	}
}
