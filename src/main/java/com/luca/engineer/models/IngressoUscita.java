package com.luca.engineer.models;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class IngressoUscita implements Serializable {

	private static final long serialVersionUID = 7408802569881391757L;
	
	@Id
	private String id;
	private LocalDateTime dataIngresso;
	private LocalDateTime dataUscita;
	private Dipendente dipendente;
	
}
