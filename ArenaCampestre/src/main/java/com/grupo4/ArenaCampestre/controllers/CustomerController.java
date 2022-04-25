package com.grupo4.ArenaCampestre.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo4.ArenaCampestre.models.entities.Customer;
import com.grupo4.ArenaCampestre.models.entities.Event;
import com.grupo4.ArenaCampestre.models.entities.Rent;
import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.entities.User;
import com.grupo4.ArenaCampestre.models.repositories.EventRepository;
import com.grupo4.ArenaCampestre.models.repositories.SeatRepository;
import com.grupo4.ArenaCampestre.models.repositories.TransactionRepository;
import com.grupo4.ArenaCampestre.models.services.EventService;
import com.grupo4.ArenaCampestre.models.services.SeatService;
import com.grupo4.ArenaCampestre.models.services.TransactionService;
import com.grupo4.ArenaCampestre.models.services.UserService;

@Controller
public class CustomerController {
	
	@Autowired
	EventService eventService;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	SeatService seatService;
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/customer/rent")
    public String showEvents(Model model, @RequestParam(name = "seatId", defaultValue = "-1") Long seatId) {
		if(seatId == -1) {
			return "redirect:/home";
		}
		List<Event> events = eventService.findEventBySeat(seatId, new Date(new java.util.Date().getTime()));
		model.addAttribute("events",events);
		model.addAttribute("seatId",seatId);
		return "eventList";
    }
	
	@PostMapping("/customer/rent")
    public String rentSeat(Model model, @RequestParam(name = "eventId", defaultValue = "-1") Long eventId,
    		@RequestParam(name = "seatId", defaultValue = "-1") Long seatId) {
		if(eventId == -1) {
			return "redirect:/home";
		}
	    Customer customer =  (Customer)userService.getLoggedUser();
		Seat seat = seatService.findById(seatId);
		Event event = eventService.findEventById(eventId);
		Rent rent = new Rent(seat, customer, event, 50D);
		transactionService.save(rent);
		return "redirect:/home";
    }
}
