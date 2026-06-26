package com.luca.engineer.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luca.engineer.dto.request.DipendenteRequest;
import com.luca.engineer.dto.response.DipendenteResponse;
import com.luca.engineer.dto.response.MessageResponse;
import com.luca.engineer.exceptions.ValidationGroups;
import com.luca.engineer.services.implementations.DipendenteService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/dipendente/")
public class DipendenteController {

	private final DipendenteService dipendenteService;
	
	@PostMapping("add")
	public ResponseEntity<DipendenteResponse> add(@RequestBody @Validated(ValidationGroups.Create.class) DipendenteRequest request) throws Exception {		
		return ResponseEntity.ok(dipendenteService.add(request));
	}
	
	@PutMapping("update")
	public ResponseEntity<DipendenteResponse> update(@RequestBody @Validated(ValidationGroups.Update.class) DipendenteRequest request) throws Exception {		
		return ResponseEntity.ok(dipendenteService.update(request));
	}
	
	@GetMapping("list")
	public ResponseEntity<List<DipendenteResponse>> getAll() throws Exception {
		return ResponseEntity.ok(dipendenteService.getAll());
	}
	
	@GetMapping("list/{id}")
	public ResponseEntity<DipendenteResponse> getById(@PathVariable String id) throws Exception {
		return ResponseEntity.ok(dipendenteService.getById(id));
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<MessageResponse> deleteById(@PathVariable String id) throws Exception {
		return ResponseEntity.ok(dipendenteService.delete(id));
	}
	
}
