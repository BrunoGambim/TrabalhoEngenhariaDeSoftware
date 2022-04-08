package com.grupo4.ArenaCampestre.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.enums.SeatState;
import com.grupo4.ArenaCampestre.models.enums.Sector;
import com.grupo4.ArenaCampestre.models.services.SeatService;

@Controller
public class HomeController {
	public static Integer NO_SECTOR_SELECTED = 0;
	
	@Autowired
	SeatService seatService;
	
	@GetMapping({"", "/", "/home"})
    public String home(Model model, @RequestParam(name = "sector", defaultValue = "0") Integer sectorCode) {
		List<Seat> seats;
		if(sectorCode == NO_SECTOR_SELECTED) {
			seats = seatService.findByStateNot(SeatState.SOLD);
		}else {
			seats = seatService.findBySectorAndStateNot(Sector.toEnum(sectorCode),SeatState.SOLD);
		}
		model.addAttribute("sectorCode",sectorCode);
		model.addAttribute("seats",seats);
		model.addAttribute("sectors", Sector.values());
        return "home";
    }
}
