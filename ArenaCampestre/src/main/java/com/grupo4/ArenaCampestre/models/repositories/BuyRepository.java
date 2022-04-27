package com.grupo4.ArenaCampestre.models.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupo4.ArenaCampestre.models.entities.Buy;
import com.grupo4.ArenaCampestre.models.entities.Customer;
import com.grupo4.ArenaCampestre.models.entities.Seat;

public interface BuyRepository extends JpaRepository<Buy, Long>{

	public List<Buy> findByCreatedAtGreaterThanEqual(Date date);
	
	@Query(value="select * from (((transaction left join seat on seat.id = transaction.seat_id) right join user on user.id = transaction.customer_id) right join buy on buy.id = transaction.id) where user.id = :#{#customer?.getId()} and seat.id = :#{#seat?.getId()} and status = 0", nativeQuery=true)
	public Buy findByCustomerAndSeat(@Param("seat")Seat seat, @Param("customer")Customer customer);		
}
