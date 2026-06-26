package com.luca.engineer.services.implementations;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.luca.engineer.dto.request.DipendenteRequest;
import com.luca.engineer.dto.response.DipendenteResponse;
import com.luca.engineer.dto.response.MessageResponse;
import com.luca.engineer.exceptions.TimbraCartellinoException;
import com.luca.engineer.models.Dipendente;
import com.luca.engineer.models.Ruolo;
import com.luca.engineer.repositories.DipendenteRepository;
import com.luca.engineer.repositories.RuoloRepository;
import com.luca.engineer.services.interfaces.IDipendenteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DipendenteService implements IDipendenteService {

	private final DipendenteRepository dipendenteRepository;
	private final RuoloRepository ruoloRepository;
	private final ModelMapper modelMapper;

	@Override
	public DipendenteResponse add(DipendenteRequest request) throws Exception {
		
		Dipendente dipendente = modelMapper.map(request, Dipendente.class);
		Ruolo ruolo = ruoloRepository.findById(request.getRuoloId()).orElseThrow(() -> new TimbraCartellinoException("ruolo non trovato"));
		
		dipendente.setRuolo(ruolo);
		
		try {
			dipendenteRepository.save(dipendente);
		} catch (Exception e) {
			throw new TimbraCartellinoException("non è stato possibile inserire il dipendente");
		}
		
		return modelMapper.map(dipendente, DipendenteResponse.class);
	}

	@Override
	public DipendenteResponse update(DipendenteRequest request) throws Exception {
		
		Dipendente dipendente = dipendenteRepository.findById(request.getId()).orElseThrow(() -> new TimbraCartellinoException("dipendente non trovato"));
		
		if (request.getNome() != null) dipendente.setNome(request.getNome());
		if (request.getCognome() != null) dipendente.setCognome(request.getCognome());
		
		if (request.getRuoloId() != null) {
			Ruolo ruolo = ruoloRepository.findById(request.getRuoloId()).orElseThrow(() -> new TimbraCartellinoException("ruolo non trovato"));
			dipendente.setRuolo(ruolo);
		}
		
		try {
			dipendenteRepository.save(dipendente);
		} catch (Exception e) {
			throw new TimbraCartellinoException("non è stato possibile modificare il dipendente");
		}
		
		return modelMapper.map(dipendente, DipendenteResponse.class);
	}

	@Override
	public MessageResponse delete(String id) throws Exception {
		
		dipendenteRepository.findById(id).orElseThrow(() -> new TimbraCartellinoException("dipendente non trovato"));
		
		try {
			dipendenteRepository.deleteById(id);
		} catch (Exception e) {
			throw new TimbraCartellinoException("non è stato possibile rimuovere il dipendente");
		}
		
		return new MessageResponse("dipendente con id ".concat(id).concat(" rimosso"));
	}

	@Override
	public List<DipendenteResponse> getAll() throws Exception {
		
		List<Dipendente> dipendenti = (List<Dipendente>) dipendenteRepository.findAll();
		Type tipoListaRes = new TypeToken<List<Dipendente>>() {}.getType();
		
		return modelMapper.map(dipendenti, tipoListaRes);
	}

	@Override
	public DipendenteResponse getById(String id) throws Exception {
		
		Dipendente dipendente = dipendenteRepository.findById(id).orElseThrow(() -> new Exception("dipendente non trovato"));
		
		return modelMapper.map(dipendente, DipendenteResponse.class);
	}
	
}
