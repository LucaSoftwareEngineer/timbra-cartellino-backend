package com.luca.engineer.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RedisHash("ruolo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Ruolo implements Serializable {

	private static final long serialVersionUID = 1151829596439475244L;
	
	@Id
	private String id;
	private String descrizione;
	
}
