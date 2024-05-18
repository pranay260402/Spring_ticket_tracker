package com.gl.TicketTrackerApplication.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.TicketTrackerApplication.dto.TicketDto;
import com.gl.TicketTrackerApplication.service.TicketService;

@Controller
@RequestMapping("/admin")
public class TicketController {

	TicketService ticketService;

	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/tickets")
	public String tickets(Model model) {
		List<TicketDto> tickets = ticketService.findAllTickets();
		model.addAttribute("ticketAttribute", tickets);
		return "allTickets";
	}

	@GetMapping("/newtickets")
	public String newTickets(Model model) {
		TicketDto ticket = new TicketDto();
		model.addAttribute("ticketAttribute", ticket);
		return "createTicket";
	}

	@PostMapping("/saveTicket")
	public String saveTicket(@ModelAttribute("ticketAttribute") TicketDto ticket) {
		ticketService.saveTicket(ticket);
		return "redirect:/admin/tickets";
	}

	@GetMapping("/delete/{id}")
	public String deleteTicket(@PathVariable("id") Long id) {
		ticketService.deleteTicket(id);
		return "redirect:/admin/tickets";
	}

	@GetMapping("/edit/{id}")
	public String editTicket(@PathVariable("id") Long id, Model model) {
		model.addAttribute("ticketAttribute", ticketService.findTicketById(id));
		return "editTicket";
	}

	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") Long id, @ModelAttribute("ticketAttribute") TicketDto ticket) {
		TicketDto existingTicket = ticketService.findTicketById(id);
		existingTicket.setId(id);
		existingTicket.setTitle(ticket.getTitle());
		existingTicket.setShortDescription(ticket.getShortDescription());
		existingTicket.setContent(ticket.getContent());
		ticketService.saveTicket(existingTicket);
		return "redirect:/admin/tickets";
	}

	@GetMapping("/search")
	public String searchTickets(@RequestParam(value = "query") String query, Model model) {

		List<TicketDto> tickets = ticketService.searchTickets(query);
		model.addAttribute("ticketAttribute", tickets);
		return "allTickets";

	}

	@GetMapping("/view/{id}")
	public String viewTickets(@PathVariable("id") Long id, Model model) {

		TicketDto tickets = ticketService.findTicketById(id);
		model.addAttribute("ticketAttribute", tickets);
		return "viewDetail";

	}

}
