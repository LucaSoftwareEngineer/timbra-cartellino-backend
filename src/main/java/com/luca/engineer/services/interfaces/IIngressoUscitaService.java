package com.luca.engineer.services.interfaces;

import java.util.List;

import com.luca.engineer.dto.request.IngressoUscitaRequest;
import com.luca.engineer.dto.response.IngressoUscitaResponse;
import com.luca.engineer.dto.response.MessageResponse;

public interface IIngressoUscitaService {

	public IngressoUscitaResponse add(IngressoUscitaRequest request) throws Exception;
	public IngressoUscitaResponse update(IngressoUscitaRequest request) throws Exception;
	public MessageResponse delete(String id) throws Exception;
	public List<IngressoUscitaResponse> getAll() throws Exception;
	public IngressoUscitaResponse getById(String id) throws Exception;
	
}
