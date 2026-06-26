package com.luca.engineer.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luca.engineer.dto.request.IngressoUscitaRequest;
import com.luca.engineer.dto.response.IngressoUscitaResponse;
import com.luca.engineer.dto.response.MessageResponse;
import com.luca.engineer.exceptions.ValidationGroups;
import com.luca.engineer.services.implementations.IngressoUscitaService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/ingresso/uscita/")
@RequiredArgsConstructor
public class IngressoUscitaController {
	
	private final IngressoUscitaService ingressoUscitaService;

	@PostMapping("add")
	public ResponseEntity<IngressoUscitaResponse> add(@RequestBody @Validated(ValidationGroups.Create.class) IngressoUscitaRequest request) throws Exception {
		return ResponseEntity.ok(ingressoUscitaService.add(request));
	}
	
	@PutMapping("update")
	public ResponseEntity<IngressoUscitaResponse> update(@RequestBody @Validated(ValidationGroups.Update.class) IngressoUscitaRequest request) throws Exception {
		return ResponseEntity.ok(ingressoUscitaService.update(request));
	}
	
	@GetMapping("list")
	public ResponseEntity<List<IngressoUscitaResponse>> getAll() throws Exception {
		return ResponseEntity.ok(ingressoUscitaService.getAll());
	}
	
	@GetMapping("list/{id}")
	public ResponseEntity<IngressoUscitaResponse> getById(@PathVariable String id) throws Exception {
		return ResponseEntity.ok(ingressoUscitaService.getById(id));
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<MessageResponse> deleteById(@PathVariable String id) throws Exception {
		return ResponseEntity.ok(ingressoUscitaService.delete(id));
	}
	
	
}
