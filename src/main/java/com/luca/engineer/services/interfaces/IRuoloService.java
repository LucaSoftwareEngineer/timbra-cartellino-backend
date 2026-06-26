package com.luca.engineer.services.interfaces;

import java.util.List;

import com.luca.engineer.dto.request.RuoloRequest;
import com.luca.engineer.dto.response.MessageResponse;
import com.luca.engineer.dto.response.RuoloResponse;

public interface IRuoloService {

	public RuoloResponse add(RuoloRequest request) throws Exception;
	public RuoloResponse update(RuoloRequest request) throws Exception;
	public MessageResponse delete(String id) throws Exception;
	public List<RuoloResponse> getAll() throws Exception;
	public RuoloResponse getById(String id) throws Exception;
	
}
