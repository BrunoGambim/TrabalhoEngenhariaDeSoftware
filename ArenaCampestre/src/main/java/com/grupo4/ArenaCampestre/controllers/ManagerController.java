package com.grupo4.ArenaCampestre.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.DateUtils;

import com.grupo4.ArenaCampestre.dtos.SeatsForSaleFormDto;
import com.grupo4.ArenaCampestre.models.entities.Event;
import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.enums.SeatState;
import com.grupo4.ArenaCampestre.models.services.EventService;
import com.grupo4.ArenaCampestre.models.services.SeatService;
import com.grupo4.ArenaCampestre.models.validators.EventValidator;

@Controller
public class ManagerController {
	@Autowired
	EventService eventService;
	
	@Autowired
	SeatService seatService;
	
	@Autowired
	EventValidator eventValidator;
	
	@GetMapping("/manager")
    public String managerControllerPanel(Model model) {
        return "managerControllerPanel";
    }
	
	@GetMapping("/manager/event")
    public String eventForm(Model model) {
		model.addAttribute("eventForm", new Event());
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(DateUtils.createToday().getTime());
		model.addAttribute("today", formattedDate);
        return "eventForm";
    }
	
	@GetMapping("/manager/seatsForSale")
    public String showAvailableSeatsForSale(Model model) {
		List<Seat> seats = seatService.findByStateNot(SeatState.SOLD);
		SeatsForSaleFormDto dto = new SeatsForSaleFormDto(seats);
		model.addAttribute("seatForSaleForm", dto);
        return "seatsForSale";
    }
	
	@PostMapping("/manager/seatsForSale")
    public String setSeatsForSale(Model model,  @ModelAttribute("seatForSaleForm")  SeatsForSaleFormDto seatsForSaleFormDto) {
		seatService.setSeatsForSale(seatsForSaleFormDto.getSeatList());
		List<Seat> seats = seatService.findByStateNot(SeatState.SOLD);
		SeatsForSaleFormDto dto = new SeatsForSaleFormDto(seats);
		model.addAttribute("seatForSaleForm",dto);
        return "seatsForSale";
    }
	
	@PostMapping("/manager/event")
    public String createEvent(Model model, @ModelAttribute("eventForm") Event eventForm, BindingResult bindingResult) {
		eventValidator.validate(eventForm, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "eventForm";
		}
		
		eventService.addEvent(eventForm);

		model.addAttribute("success", "O evento foi criado com sucesso!");
		
        return "eventForm";
    }
}
