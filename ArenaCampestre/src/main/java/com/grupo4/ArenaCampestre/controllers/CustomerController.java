package com.grupo4.ArenaCampestre.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
	
	@GetMapping("/customer/rent")
    public String home(Model model, @RequestParam(name = "seatId", defaultValue = "-1") Long seatId) {
		if(seatId == -1) {
			return "redirect:/home";
		}
		System.out.println(seatId);
		return "eventList";
    }
}
