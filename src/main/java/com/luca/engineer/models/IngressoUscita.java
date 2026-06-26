package com.luca.engineer.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RedisHash("ingresso_uscita")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class IngressoUscita {

	@Id
	private String id;
	private LocalDate dataIngresso;
	private LocalDate dataUscita;
	private Dipendente dipendente;
	
}
