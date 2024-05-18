package com.gl.TicketTrackerApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.TicketTrackerApplication.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query("SELECT t from Ticket t WHERE " + " t.title LIKE CONCAT('%', :query, '%') OR "
			+ " t.shortDescription LIKE CONCAT('%', :query, '%')")
	List<Ticket> searchTickets(String query);

}
