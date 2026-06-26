package com.luca.engineer.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.luca.engineer.models.Dipendente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class IngressoUscitaResponse {

	private String id;
	private LocalDateTime dataIngresso;
	private LocalDateTime dataUscita;
	private Dipendente dipendente;
	
}
