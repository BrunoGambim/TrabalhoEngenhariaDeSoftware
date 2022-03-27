package com.grupo4.ArenaCampestre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.enums.SeatState;
import com.grupo4.ArenaCampestre.models.enums.Sector;
import com.grupo4.ArenaCampestre.models.repositories.SeatRepository;

@SpringBootApplication
public class ArenaCampestreApplication implements CommandLineRunner{
	
	@Autowired
	SeatRepository seatRepository;

	public static void main(String[] args) {
		SpringApplication.run(ArenaCampestreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Seat seat1 = new Seat(Sector.MIDDLE_EAST, SeatState.SOLD, "C13");
		Seat seat2 = new Seat(Sector.LOWER_NORTH, SeatState.AVAILABLE_TO_BUY, "C14");
		Seat seat3 = new Seat(Sector.LOWER_NORTH, SeatState.AVAILABLE_TO_BUY, "C15");
		Seat seat4 = new Seat(Sector.LOWER_NORTH, SeatState.AVAILABLE_TO_BUY, "C16");
		Seat seat5 = new Seat(Sector.LOWER_NORTH, SeatState.AVAILABLE_TO_BUY, "C17");
		Seat seat6 = new Seat(Sector.LOWER_NORTH, SeatState.AVAILABLE_TO_BUY, "C18");
		Seat seat7 = new Seat(Sector.LOWER_NORTH, SeatState.AVAILABLE_TO_BUY, "C19");
		Seat seat8 = new Seat(Sector.LOWER_NORTH, SeatState.AVAILABLE_TO_BUY, "C20");
		//seatRepository.save(seat1);
		//seatRepository.save(seat2);
		//seatRepository.save(seat3);
		//seatRepository.save(seat4);
		//seatRepository.save(seat5);
		//seatRepository.save(seat6);
		//seatRepository.save(seat7);
		//seatRepository.save(seat8);
	}

}
