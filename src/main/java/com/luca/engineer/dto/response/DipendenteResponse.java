package com.luca.engineer.dto.response;

import com.luca.engineer.models.Ruolo;

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
public class DipendenteResponse {

	private String id;
	private String nome;
	private String cognome;
	private Ruolo ruolo;
	
}
