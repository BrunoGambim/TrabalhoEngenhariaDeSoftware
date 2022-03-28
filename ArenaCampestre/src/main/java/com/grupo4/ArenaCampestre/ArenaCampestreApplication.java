package com.grupo4.ArenaCampestre;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
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
	}

}
