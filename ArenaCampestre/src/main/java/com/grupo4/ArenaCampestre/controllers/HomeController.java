package com.grupo4.ArenaCampestre.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.services.SeatService;

@Controller
public class HomeController {
	
	@Autowired
	SeatService seatService;
	
	@GetMapping({"/", "/home"})
    public String home(Model model) {
		List<Seat> seats = seatService.findAll();
		model.addAttribute("seats",seats);
        return "home";
    }
}
