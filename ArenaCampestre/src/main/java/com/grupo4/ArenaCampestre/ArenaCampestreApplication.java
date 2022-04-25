package com.grupo4.ArenaCampestre;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.assertj.core.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.grupo4.ArenaCampestre.models.entities.Customer;
import com.grupo4.ArenaCampestre.models.entities.Event;
import com.grupo4.ArenaCampestre.models.entities.Rent;
import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.enums.SeatState;
import com.grupo4.ArenaCampestre.models.enums.Sector;
import com.grupo4.ArenaCampestre.models.repositories.EventRepository;
import com.grupo4.ArenaCampestre.models.repositories.SeatRepository;
import com.grupo4.ArenaCampestre.models.repositories.TransactionRepository;
import com.grupo4.ArenaCampestre.models.repositories.UserRepository;

@SpringBootApplication
public class ArenaCampestreApplication implements CommandLineRunner{
	
	@Autowired
	SeatRepository seatRepository;

	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ArenaCampestreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*String[] letras = {"A","B","C","D","E","F","G","H","I","J","K","L","M"};
		for(String letra : letras) {
			for(Sector sector : Sector.values()) {
				for(int i = 1; i < 10; i++) {
					Seat seat = new Seat(sector, SeatState.AVAILABLE_TO_RENT, letra + "0" + i);
					seatRepository.save(seat);
				}
				for(int i = 10; i <= 40; i++) {
					Seat seat = new Seat(sector, SeatState.AVAILABLE_TO_RENT, letra + "" + i);
					seatRepository.save(seat);
				}
			}
		}*/
		
		//Event event = this.eventRepository.findById(5207L).get();
		//Seat seat = this.seatRepository.findById(400L).get();
		//Customer customer = (Customer)this.userRepository.findById(1L).get();
		//Rent rent = new Rent(seat, customer, event, 13D);
		//transactionRepository.save(rent);
		//transactionRepository.delete(transactionRepository.getById(5206L));
		//this.eventRepository.findByRent(499L,new Date(new java.util.Date().getTime())).forEach(a->{
		//	System.out.println(a.getName());
		//});;
	}

}
