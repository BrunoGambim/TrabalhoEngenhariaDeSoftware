package com.grupo4.ArenaCampestre.models.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.thymeleaf.util.DateUtils;

import com.grupo4.ArenaCampestre.models.entities.Event;
import com.grupo4.ArenaCampestre.models.services.EventManagementService;

@Component
public class EventValidator implements Validator {
    @Autowired
    private EventManagementService eventManagementService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Event.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	Event event = (Event) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if (event.getName().length() > 32) {
            errors.rejectValue("name", "Size.eventForm.username");
        }
        
        if (event.getDate().before(DateUtils.createToday().getTime())) {
        	errors.rejectValue("date", "Value.eventForm.date");
        }
        
        if (eventManagementService.findByDate(event.getDate()) != null) {
            errors.rejectValue("date", "Duplicate.eventForm.date");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");
        if (event.getDescription().length() < 8 || event.getDescription().length() > 64) {
            errors.rejectValue("description", "Size.eventForm.description");
        }
    }
}
