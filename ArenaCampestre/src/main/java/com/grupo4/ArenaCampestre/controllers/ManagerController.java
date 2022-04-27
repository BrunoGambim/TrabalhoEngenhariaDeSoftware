package com.grupo4.ArenaCampestre.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo4.ArenaCampestre.controllers.utils.DateUtils;
import com.grupo4.ArenaCampestre.dtos.SeatsForSaleFormDto;
import com.grupo4.ArenaCampestre.models.entities.Buy;
import com.grupo4.ArenaCampestre.models.entities.Event;
import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.enums.SeatState;
import com.grupo4.ArenaCampestre.models.services.EventService;
import com.grupo4.ArenaCampestre.models.services.SeatService;
import com.grupo4.ArenaCampestre.models.services.TransactionService;
import com.grupo4.ArenaCampestre.models.validators.EventValidator;

@Controller
public class ManagerController {
	@Autowired
	EventService eventService;
	
	@Autowired
	SeatService seatService;
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	EventValidator eventValidator;
	
	@GetMapping("/manager")
    public String managerControllerPanel(Model model) {
        return "managerControllerPanel";
    }
	
	@GetMapping("/manager/event")
    public String eventForm(Model model) {
		model.addAttribute("eventForm", new Event());
		
		String formattedDate = DateUtils.getFormattedDateNow();
		model.addAttribute("today", formattedDate);
        return "eventForm";
    }
	
	@GetMapping("/manager/seatsForSale")
    public String showAvailableSeatsForSale(Model model) {
		List<Seat> seats = seatService.findNotRentedOrSoldSeat(DateUtils.getDateNow(), SeatState.SOLD);
		SeatsForSaleFormDto dto = new SeatsForSaleFormDto(seats);
		model.addAttribute("seatForSaleForm", dto);
        return "seatsForSale";
    }
	
	@PostMapping("/manager/seatsForSale")
    public String setSeatsForSale(Model model,  @ModelAttribute("seatForSaleForm")  SeatsForSaleFormDto seatsForSaleFormDto) {
		seatService.setSeatsForSale(seatsForSaleFormDto.getSeatList());
		List<Seat> seats = seatService.findNotRentedOrSoldSeat(DateUtils.getDateNow(), SeatState.SOLD);
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
	
    @GetMapping("/manager/report")
    public String showReport(Model model, @RequestParam(name = "date", defaultValue = "") String stringDate) {
    	List<Buy> buys;
    	if(stringDate.equals("")) {
    		buys = transactionService.findAllBuys();
    	}else {
    		Date date = DateUtils.dateFromString(stringDate);
    		buys = transactionService.findByCreatedAtGreaterThanEqual(date);
    	}
    	model.addAttribute("buys",buys);
        return "managerReport";
    }
}
