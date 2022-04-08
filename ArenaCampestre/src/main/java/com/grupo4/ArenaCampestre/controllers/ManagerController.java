package com.grupo4.ArenaCampestre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.grupo4.ArenaCampestre.models.services.EventManagementService;

@Controller
public class ManagerController {
	@Autowired
	EventManagementService eventManagementService;
	
	@GetMapping({"/", "/manager/event"})
    public String eventForm(Model model) {		
        return "eventForm";
    }
}
