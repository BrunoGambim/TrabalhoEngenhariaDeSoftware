package com.grupo4.ArenaCampestre.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo4.ArenaCampestre.models.entities.Customer;
import com.grupo4.ArenaCampestre.models.entities.Event;
import com.grupo4.ArenaCampestre.models.entities.Rent;
import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.enums.SeatState;
import com.grupo4.ArenaCampestre.models.enums.Sector;
import com.grupo4.ArenaCampestre.models.repositories.TransactionRepository;
import com.grupo4.ArenaCampestre.models.services.EventService;
import com.grupo4.ArenaCampestre.models.services.SeatService;
import com.grupo4.ArenaCampestre.models.services.TransactionService;
import com.grupo4.ArenaCampestre.models.services.UserService;

@Controller
public class CustomerController {
	
	public static Integer NO_SECTOR_SELECTED = 0;
	
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
    public String showEvents(Model model) {
		List<Event> events = eventService.findByDateGreaterThan(new Date(new java.util.Date().getTime()));
		model.addAttribute("events",events);
		return "eventList";
    }
    
    @GetMapping("/customer/rent/seats")
    public String showEventSeats(Model model,@RequestParam(name = "eventId", defaultValue = "-1") Long eventId,
    		@RequestParam(name = "sector", defaultValue = "0") Integer sectorCode) {
		List<Seat> seats;
		if(sectorCode == NO_SECTOR_SELECTED) {
			seats = seatService.findByStateNotAndEvent(SeatState.SOLD,eventId);
		}else {
			seats = seatService.findBySectorAndStateAndEvent(Sector.toEnum(sectorCode),SeatState.SOLD,eventId);
		}
		model.addAttribute("sectorCode",sectorCode);
		model.addAttribute("seats",seats);
		model.addAttribute("eventId",eventId);
		model.addAttribute("sectors", Sector.values());
		return "eventSeatList";
    }
    
    @GetMapping("/customer/rent/payment")
    public String rentSeatPayment(Model model, @RequestParam(name = "eventId", defaultValue = "-1") Long eventId,
    		@RequestParam(name = "seatId", defaultValue = "-1") Long seatId) {
		if(eventId == -1 || seatId == -1) {
			return "redirect:/home";
		}
		Seat seat = seatService.findById(seatId);
		Event event = eventService.findEventById(eventId);
		model.addAttribute("seat",seat);
		model.addAttribute("event",event);
		return "rentSeatPayment";
    }
	
	@PostMapping("/customer/rent")
    public String rentSeat(Model model, @RequestParam(name = "eventId", defaultValue = "-1") Long eventId,
    		@RequestParam(name = "seatId", defaultValue = "-1") Long seatId) {
		if(eventId == -1) {
			return "redirect:/home";
		}
	    Customer customer = (Customer) userService.getLoggedUser();
		Seat seat = seatService.findById(seatId);
		Event event = eventService.findEventById(eventId);
		Rent rent = new Rent(seat, customer, event, 50D);
		transactionService.save(rent);
		return "redirect:/home";
    }
}
