package com.gl.TicketTrackerApplication.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {

	private Long id;

	private String title;

	private String shortDescription;

	private String content;

	private LocalDateTime createdOn;

	private LocalDateTime updatedOn;
}
