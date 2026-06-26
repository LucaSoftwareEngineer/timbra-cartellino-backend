package com.luca.engineer.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luca.engineer.dto.request.RuoloRequest;
import com.luca.engineer.dto.response.MessageResponse;
import com.luca.engineer.dto.response.RuoloResponse;
import com.luca.engineer.exceptions.ValidationGroups;
import com.luca.engineer.services.implementations.RuoloService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/ruolo/")
@RequiredArgsConstructor
public class RuoloController {
	
	private final RuoloService ruoloService;
	
	@PostMapping("add")
	public ResponseEntity<RuoloResponse> add(@RequestBody @Validated(ValidationGroups.Create.class) RuoloRequest request) throws Exception {
		return ResponseEntity.ok(ruoloService.add(request));
	}
	
	@PutMapping("update")
	public ResponseEntity<RuoloResponse> update(@RequestBody @Validated(ValidationGroups.Update.class) RuoloRequest request) throws Exception {
		return ResponseEntity.ok(ruoloService.update(request));
	}
	
	@GetMapping("list")
	public ResponseEntity<List<RuoloResponse>> getAll() throws Exception {
		return ResponseEntity.ok(ruoloService.getAll());
	}
	
	@GetMapping("list/{id}")
	public ResponseEntity<RuoloResponse> getById(@PathVariable String id) throws Exception {
		return ResponseEntity.ok(ruoloService.getById(id));
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<MessageResponse> deleteById(@PathVariable String id) throws Exception {
		return ResponseEntity.ok(ruoloService.delete(id));
	}

}
