package com.luca.engineer.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RedisHash("dipendente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Dipendente implements Serializable {

	private static final long serialVersionUID = -536420909173859003L;
	
	@Id
	private String id;
	private String nome;
	private String cognome;
	private Ruolo ruolo;
	
}
