package com.gl.TicketTrackerApplication.mapper;

import com.gl.TicketTrackerApplication.dto.TicketDto;
import com.gl.TicketTrackerApplication.model.Ticket;

public class TicketMapper {

	public static TicketDto mapToTicketDto(Ticket ticket) {
		TicketDto ticketDto = TicketDto.builder().id(ticket.getId()).title(ticket.getTitle())
				.shortDescription(ticket.getShortDescription()).content(ticket.getContent())
				.createdOn(ticket.getCreatedOn()).updatedOn(ticket.getUpdatedOn()).build();
		return ticketDto;
	}

	public static Ticket mapToTicket(TicketDto ticketDto) {
		Ticket ticket = Ticket.builder().id(ticketDto.getId()).title(ticketDto.getTitle())
				.shortDescription(ticketDto.getShortDescription()).content(ticketDto.getContent())
				.createdOn(ticketDto.getCreatedOn()).updatedOn(ticketDto.getUpdatedOn()).build();
		return ticket;
	}

}
