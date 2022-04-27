package com.grupo4.ArenaCampestre.models.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupo4.ArenaCampestre.models.entities.Customer;
import com.grupo4.ArenaCampestre.models.entities.Rent;

public interface RentRepository extends JpaRepository<Rent, Long>{
	
	@Query(value="select * from (((transaction left join seat on seat.id = transaction.seat_id) right join user on user.id = transaction.customer_id) right join rent on rent.id = transaction.id) where user.id = :#{#customer?.getId()}", nativeQuery=true)
	public List<Rent> findByCustomer(@Param("customer")Customer customer);		
	
	@Query(value="select * from (((transaction left join seat on seat.id = transaction.seat_id) right join user on user.id = transaction.customer_id) right join rent on rent.id = transaction.id) where user.id = :#{#customer?.getId()} and transaction.created_at >= :date", nativeQuery=true)
	public List<Rent> findByCustomerAndDateGreaterThan(@Param("date")Date date, @Param("customer")Customer customer);
}
