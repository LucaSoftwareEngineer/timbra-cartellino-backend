package com.luca.engineer.dto.request;

import java.time.LocalDate;

import com.luca.engineer.exceptions.ValidationGroups;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class IngressoUscitaRequest {

	@NotNull(groups = {ValidationGroups.Update.class}, message = "id ingresso uscita mancante")
	@NotBlank(groups = {ValidationGroups.Update.class}, message = "id ingresso uscita mancante")
	private String id;
	
	@NotNull(groups = {ValidationGroups.Create.class}, message = "data ingresso mancante")
	@NotBlank(groups = {ValidationGroups.Create.class}, message = "data ingresso mancante")
	private LocalDate dataIngresso;
	
	private LocalDate dataUscita;
	
	@NotNull(
		groups = {
			ValidationGroups.Create.class,
			ValidationGroups.Update.class
		}, 
		message = "id dipendente mancante"
	)
	@NotBlank(
		groups = {
			ValidationGroups.Create.class,
			ValidationGroups.Update.class
		}, 
		message = "id dipendente mancante"
	)
	private String dipendenteId;
	
}
