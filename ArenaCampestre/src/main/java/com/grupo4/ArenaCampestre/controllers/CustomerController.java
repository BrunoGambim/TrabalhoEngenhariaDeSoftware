package com.grupo4.ArenaCampestre.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo4.ArenaCampestre.controllers.utils.DateUtils;
import com.grupo4.ArenaCampestre.models.entities.Purchase;
import com.grupo4.ArenaCampestre.models.entities.Customer;
import com.grupo4.ArenaCampestre.models.entities.Event;
import com.grupo4.ArenaCampestre.models.entities.Rent;
import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.entities.Sale;
import com.grupo4.ArenaCampestre.models.enums.PurchaseStatus;
import com.grupo4.ArenaCampestre.models.enums.SeatState;
import com.grupo4.ArenaCampestre.models.enums.Sector;
import com.grupo4.ArenaCampestre.models.enums.TransactionTypes;
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
	SeatService seatService;
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/customer/rent")
    public String showEvents(Model model) {
		List<Event> events = eventService.findByDateGreaterThan(DateUtils.getDateNow());
		model.addAttribute("events",events);
		return "eventList";
    }
    
    @GetMapping("/customer/rent/seats")
    public String showEventSeats(Model model,@RequestParam(name = "eventId", defaultValue = "-1") Long eventId,
    		@RequestParam(name = "sector", defaultValue = "0") Integer sectorCode) {
		List<Seat> seats;
		if(sectorCode == NO_SECTOR_SELECTED) {
			seats = seatService.findByStateAndEvent(SeatState.AVAILABLE_TO_RENT,eventId);
		}else {
			seats = seatService.findBySectorAndStateAndEvent(Sector.toEnum(sectorCode),SeatState.AVAILABLE_TO_RENT,eventId);
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
		if(eventId == -1 || seatId == -1) {
			return "redirect:/home";
		}
	    Customer customer = (Customer) userService.getLoggedUser();
		Seat seat = seatService.findById(seatId);
		Event event = eventService.findEventById(eventId);
		Rent rent = new Rent(seat, customer, event, DateUtils.getDateNow(), seat.getPrice());
		transactionService.save(rent); 
		return "redirect:/home";
    }
	
	@GetMapping("/customer/purchase/seats")
    public String showSeatsForSale(Model model, @RequestParam(name = "sector", defaultValue = "0") Integer sectorCode) {
		List<Seat> seats;
		if(sectorCode == NO_SECTOR_SELECTED) {
			seats = seatService.findByState(SeatState.AVAILABLE_TO_BUY);
		}else {
			seats = seatService.findBySectorAndState(Sector.toEnum(sectorCode),SeatState.AVAILABLE_TO_BUY);
		}
		model.addAttribute("sectorCode",sectorCode);
		model.addAttribute("seats",seats);
		model.addAttribute("sectors", Sector.values());
        return "seatListForSale";
    }
	
	@GetMapping("/customer/purchase/payment")
    public String purchaseSeatPayment(Model model, @RequestParam(name = "seatId", defaultValue = "-1") Long seatId) {
		if(seatId == -1) {
			return "redirect:/home";
		}
		Seat seat = seatService.findById(seatId);
		model.addAttribute("seat",seat);
		return "purchaseSeatPayment";
    }
	
	@PostMapping("/customer/purchase")
    public String purchaseSeat(Model model, @RequestParam(name = "seatId", defaultValue = "-1") Long seatId) {
		if(seatId == -1) {
			return "redirect:/home";
		}
	    Customer customer = (Customer) userService.getLoggedUser();
		Seat seat = seatService.findById(seatId);
		Purchase purchase = new Purchase(seat, customer, seat.getPrice(),DateUtils.getDateNow(), PurchaseStatus.ACTIVE);
		seat.setState(SeatState.SOLD);
		seatService.saveSeat(seat);
		transactionService.save(purchase);
		return "redirect:/home";
    }
	
	@GetMapping("/customer/sale/seats")
    public String showCustomerSeats(Model model, @RequestParam(name = "sector", defaultValue = "0") Integer sectorCode) {
		List<Seat> seats;
		Customer customer = (Customer) userService.getLoggedUser();
		if(sectorCode == NO_SECTOR_SELECTED) {
			seats = seatService.findByCustomer(customer);
		}else {
			seats = seatService.findBySectorAndCustomer(Sector.toEnum(sectorCode), customer);
		}
		model.addAttribute("sectorCode",sectorCode);
		model.addAttribute("seats",seats);
		model.addAttribute("sectors", Sector.values());
        return "customerSeats";
    }
	
	@GetMapping("/customer/sale/confirm")
    public String confirmSeatSale(Model model, @RequestParam(name = "seatId", defaultValue = "-1") Long seatId) {
		if(seatId == -1) {
			return "redirect:/home";
		}
		Seat seat = seatService.findById(seatId);
		model.addAttribute("seat",seat);
		return "confirmSeatSale";
    }
	
	@PostMapping("/customer/sale")
    public String sellSeat(Model model, @RequestParam(name = "seatId", defaultValue = "-1") Long seatId) {
		if(seatId == -1) {
			return "redirect:/home";
		}
	    Customer customer = (Customer) userService.getLoggedUser();
		Seat seat = seatService.findById(seatId);
		Sale sale = new Sale(seat, customer, seat.getPrice(),DateUtils.getDateNow());
		seat.setState(SeatState.AVAILABLE_TO_RENT);
		Purchase purchase = transactionService.findPurchaseByCustomerAndSeat(seat, customer);
		if(purchase == null) {
			System.out.println(" "+seat.getId()+"    "+customer.getId());
		}
		purchase.setStatus(PurchaseStatus.INACTIVE);
		seatService.saveSeat(seat);
		transactionService.save(sale);
		transactionService.save(purchase);
		return "redirect:/home";
    }
	
	@GetMapping("/customer/report")
    public String showReport(Model model, @RequestParam(name = "date", defaultValue = "") String stringDate,
    		@RequestParam(name = "transactionTypesCode", defaultValue = "1") Integer transactionTypesCode) {
		Customer customer = (Customer) userService.getLoggedUser();
    	List<Sale> sales = null;
    	List<Purchase> purchases = null;
    	List<Rent> rents = null;
    	if(stringDate.equals("")) {
    		if(transactionTypesCode.equals((Integer)TransactionTypes.COMPRA.getCode()) || transactionTypesCode.equals((Integer)0)) {
				purchases = transactionService.findPurchaseByCustomer(customer);
    		}
    		if(transactionTypesCode.equals((Integer)TransactionTypes.RENT.getCode()) || transactionTypesCode.equals((Integer)0)){
    			rents = transactionService.findRentByCustomer(customer);
    		}
    		if(transactionTypesCode.equals((Integer)TransactionTypes.SALE.getCode()) || transactionTypesCode.equals((Integer)0)) {
    			sales = transactionService.findSaleByCustomer(customer);
    		}
    	}else {
    		Date date = DateUtils.dateFromString(stringDate);
    		if(transactionTypesCode.equals((Integer)TransactionTypes.COMPRA.getCode()) || transactionTypesCode.equals((Integer)0)) {
    			purchases = transactionService.findPurchaseByCustomerAndDateGreaterThan(date, customer);
    		}
    		if(transactionTypesCode.equals((Integer)TransactionTypes.RENT.getCode()) || transactionTypesCode.equals((Integer)0)){
    			rents = transactionService.findRentByCustomerAndDateGreaterThan(date, customer);
    		}
    		if(transactionTypesCode.equals((Integer)TransactionTypes.SALE.getCode()) || transactionTypesCode.equals((Integer)0)) {
    			sales = transactionService.findSaleByCustomerAndDateGreaterThan(date, customer);
    		}
    	}
    	model.addAttribute("sales",sales);
    	model.addAttribute("purchases",purchases);
    	model.addAttribute("rents",rents);
    	model.addAttribute("transactionTypesCode",transactionTypesCode);
    	model.addAttribute("transactionTypes",TransactionTypes.values());
    	
        return "customerReport";
    }
}
