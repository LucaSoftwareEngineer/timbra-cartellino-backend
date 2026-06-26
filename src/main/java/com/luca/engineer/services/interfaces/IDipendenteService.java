package com.luca.engineer.services.interfaces;

import java.util.List;

import com.luca.engineer.dto.request.DipendenteRequest;
import com.luca.engineer.dto.response.DipendenteResponse;
import com.luca.engineer.dto.response.MessageResponse;

public interface IDipendenteService {

	public DipendenteResponse add(DipendenteRequest request) throws Exception;
	public DipendenteResponse update(DipendenteRequest request) throws Exception;
	public MessageResponse delete(String id) throws Exception;
	public List<DipendenteResponse> getAll() throws Exception;
	public DipendenteResponse getById(String id) throws Exception;
	
}
