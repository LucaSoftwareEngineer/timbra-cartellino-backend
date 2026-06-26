package com.luca.engineer.dto.request;

import com.luca.engineer.exceptions.ValidationGroups;
import com.luca.engineer.models.Ruolo;

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
public class DipendenteRequest {

	@NotNull(groups = {ValidationGroups.Update.class}, message = "manca id del dipendente")
	@NotBlank(groups = {ValidationGroups.Update.class}, message = "manca id del dipendente")
	private String id;
	
	@NotNull(groups = {ValidationGroups.Create.class}, message = "manca nome del dipendente")
	@NotBlank(groups = {ValidationGroups.Create.class}, message = "manca nome del dipendente")
	private String nome;
	
	@NotNull(groups = {ValidationGroups.Create.class}, message = "manca cognome del dipendente")
	@NotBlank(groups = {ValidationGroups.Create.class}, message = "manca cognome del dipendente")
	private String cognome;
	
	@NotNull(
		groups = {
			ValidationGroups.Create.class,
			ValidationGroups.Update.class
		}, 
		message = "manca ruoloId del dipendente"
	)
	@NotBlank(
		groups = {
			ValidationGroups.Create.class,
			ValidationGroups.Update.class
		}, 
		message = "manca ruoloId del dipendente"
	)
	private String ruoloId;
	
}
