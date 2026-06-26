package com.luca.engineer.services.implementations;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.luca.engineer.dto.request.RuoloRequest;
import com.luca.engineer.dto.response.MessageResponse;
import com.luca.engineer.dto.response.RuoloResponse;
import com.luca.engineer.exceptions.TimbraCartellinoException;
import com.luca.engineer.models.Ruolo;
import com.luca.engineer.repositories.RuoloRepository;
import com.luca.engineer.services.interfaces.IRuoloService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RuoloService implements IRuoloService {
	
	private final RuoloRepository ruoloRepository;
	private final ModelMapper modelMapper;
	
	@Override
	public RuoloResponse add(RuoloRequest request) throws Exception {
		
		Ruolo ruolo = modelMapper.map(request, Ruolo.class);
		
		try {
			ruoloRepository.save(ruolo);
		} catch (Exception e) {
			throw new TimbraCartellinoException("non è stato possibile inserire il ruolo");
		}
		
		return modelMapper.map(ruolo, RuoloResponse.class);
	}

	@Override
	public RuoloResponse update(RuoloRequest request) throws Exception {
		
		Ruolo ruolo = ruoloRepository.findById(request.getId()).orElseThrow(() -> new TimbraCartellinoException("ruolo non trovato"));
		
		if (request.getDescrizione() != null) ruolo.setDescrizione(request.getDescrizione());
		
		try {
			ruoloRepository.save(ruolo);
		}
		catch (Exception e) {
			throw new TimbraCartellinoException("non è stato possibile inserire il ruolo");
		}
		return modelMapper.map(ruolo, RuoloResponse.class);
	}

	@Override
	public MessageResponse delete(String id) throws Exception {
		
		ruoloRepository.findById(id).orElseThrow(() -> new TimbraCartellinoException("ruolo non trovato"));
		
		try {
			ruoloRepository.deleteById(id);
		} catch (Exception e) {
			throw new TimbraCartellinoException("non è stato possibile rimuovere il ruolo");
		}
		
		return new MessageResponse("ruolo con id ".concat(id).concat(" rimosso"));
	}

	@Override
	public List<RuoloResponse> getAll() throws Exception {
		
		List<Ruolo> ruoli = (List<Ruolo>) ruoloRepository.findAll();
		Type tipoListaRes = new TypeToken<List<RuoloResponse>>() {}.getType();
		
		return modelMapper.map(ruoli, tipoListaRes);
	}

	@Override
	public RuoloResponse getById(String id) throws Exception {
		
		Ruolo ruolo = ruoloRepository.findById(id).orElseThrow(() -> new TimbraCartellinoException("ruolo non trovato"));
		
		return modelMapper.map(ruolo, RuoloResponse.class);
	}

}
