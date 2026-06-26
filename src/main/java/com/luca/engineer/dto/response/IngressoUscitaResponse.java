package com.luca.engineer.dto.response;

import java.time.LocalDate;

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
	private LocalDate dataIngresso;
	private LocalDate dataUscita;
	private Dipendente dipendente;
	
}
