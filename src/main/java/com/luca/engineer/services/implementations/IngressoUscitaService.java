package com.luca.engineer.services.implementations;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.luca.engineer.dto.request.IngressoUscitaRequest;
import com.luca.engineer.dto.response.IngressoUscitaResponse;
import com.luca.engineer.dto.response.MessageResponse;
import com.luca.engineer.exceptions.TimbraCartellinoException;
import com.luca.engineer.models.Dipendente;
import com.luca.engineer.models.IngressoUscita;
import com.luca.engineer.repositories.DipendenteRepository;
import com.luca.engineer.repositories.IngressoUscitaRepository;
import com.luca.engineer.services.interfaces.IIngressoUscitaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IngressoUscitaService implements IIngressoUscitaService {

	private final IngressoUscitaRepository ingressoUscitaRepository;
	private final DipendenteRepository dipendenteRepository;
	private final ModelMapper modelMapper;

	@Override
	public IngressoUscitaResponse add(IngressoUscitaRequest request) throws Exception {
		
		IngressoUscita ingressoUscita = modelMapper.map(request, IngressoUscita.class);
		Dipendente dipendente = dipendenteRepository.findById(request.getDipendenteId()).orElseThrow(() -> new TimbraCartellinoException("dipendente non trovato"));
		
		ingressoUscita.setDipendente(dipendente);
		
		try {
			ingressoUscitaRepository.save(ingressoUscita);
		} catch (Exception e) {
			throw new TimbraCartellinoException("non è stato possibile registrare l'ingresso");
		}
		
		return modelMapper.map(ingressoUscita, IngressoUscitaResponse.class);
	}

	@Override
	public IngressoUscitaResponse update(IngressoUscitaRequest request) throws Exception {
		
		IngressoUscita ingressoUscita = ingressoUscitaRepository.findById(request.getId()).orElseThrow(() -> new TimbraCartellinoException("ingresso non trovato"));
		
		if (request.getDipendenteId() != null) {
			Dipendente dipendente = dipendenteRepository.findById(request.getDipendenteId()).orElseThrow(() -> new TimbraCartellinoException("dipendente non trovato"));
			ingressoUscita.setDipendente(dipendente);
		}
		
		if (request.getDataIngresso() != null) ingressoUscita.setDataIngresso(request.getDataIngresso());
		if (request.getDataUscita() != null) ingressoUscita.setDataUscita(request.getDataUscita());
		
		try {
			ingressoUscitaRepository.save(ingressoUscita);
		} catch (Exception e) {
			throw new TimbraCartellinoException("non è stato possibile aggiornare l'ingresso");
		}
		
		return modelMapper.map(ingressoUscita, IngressoUscitaResponse.class);
	}

	@Override
	public MessageResponse delete(String id) throws Exception {
		
		ingressoUscitaRepository.findById(id).orElseThrow(() -> new TimbraCartellinoException("ingresso non trovato"));
		
		try {
			ingressoUscitaRepository.deleteById(id);
		} catch (Exception e) {
			throw new TimbraCartellinoException("non è stato possibile rimuovere l'ingresso");
		}
		
		return new MessageResponse("ingresso con id ".concat(id).concat(" rimosso"));
	}

	@Override
	public List<IngressoUscitaResponse> getAll() throws Exception {
		
		List<IngressoUscita> ingressiUscite = (List<IngressoUscita>) ingressoUscitaRepository.findAll();
		Type tipoListaRes = new TypeToken<List<IngressoUscitaResponse>>() {}.getType();
		
		return modelMapper.map(ingressiUscite, tipoListaRes);
	}

	@Override
	public IngressoUscitaResponse getById(String id) throws Exception {
		
		IngressoUscita ingressoUscita = ingressoUscitaRepository.findById(id).orElseThrow(() -> new TimbraCartellinoException("ingresso non trovato"));
		
		return modelMapper.map(ingressoUscita, IngressoUscitaResponse.class);
	}
	
}
