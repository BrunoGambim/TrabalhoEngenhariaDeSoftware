package com.grupo4.ArenaCampestre.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.DateUtils;

import com.grupo4.ArenaCampestre.models.entities.Event;
import com.grupo4.ArenaCampestre.models.services.EventManagementService;
import com.grupo4.ArenaCampestre.models.validators.EventValidator;

@Controller
public class ManagerController {
	@Autowired
	EventManagementService eventManagementService;
	
	@Autowired
	EventValidator eventValidator;
	
	@GetMapping({"/", "/manager/event"})
    public String eventForm(Model model) {
		model.addAttribute("eventForm", new Event());
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(DateUtils.createToday().getTime());
		model.addAttribute("today", formattedDate);
		
        return "eventForm";
    }
	
	@PostMapping("/manager/event")
    public String createEvent(Model model, @ModelAttribute("eventForm") Event eventForm, BindingResult bindingResult) {
		eventValidator.validate(eventForm, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "eventForm";
		}
		
		eventManagementService.addEvent(eventForm);

		model.addAttribute("success", "O evento foi criado com sucesso!");
		
        return "eventForm";
    }
}
