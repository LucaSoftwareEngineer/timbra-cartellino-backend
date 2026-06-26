package com.luca.engineer.dto.request;

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
public class RuoloRequest {

	@NotNull(groups = {ValidationGroups.Update.class}, message = "manca id del ruolo")
	@NotBlank(groups = {ValidationGroups.Update.class}, message = "manca id del ruolo")
	private String id;
	
	@NotNull(
		groups = {
			ValidationGroups.Create.class,
			ValidationGroups.Update.class
		}, 
		message = "manca descrizione del ruolo"
	)
	@NotBlank(
		groups = {
			ValidationGroups.Create.class,
			ValidationGroups.Update.class
		}, 
		message = "manca descrizione del ruolo"
	)
	private String descrizione;
	
}
