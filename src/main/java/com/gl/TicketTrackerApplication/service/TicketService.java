package com.gl.TicketTrackerApplication.service;

import java.util.List;

import com.gl.TicketTrackerApplication.dto.TicketDto;

public interface TicketService {

	List<TicketDto> findAllTickets();

	void saveTicket(TicketDto ticketDto);

	TicketDto findTicketById(Long ticketId);

	void deleteTicket(Long ticketId);

	List<TicketDto> searchTickets(String search);
}
