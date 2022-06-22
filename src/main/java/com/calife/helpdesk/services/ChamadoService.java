package com.calife.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calife.helpdesk.domain.Chamado;
import com.calife.helpdesk.domain.Cliente;
import com.calife.helpdesk.domain.Tecnico;
import com.calife.helpdesk.domain.dtos.ChamadoDTO;
import com.calife.helpdesk.domain.enums.Prioridade;
import com.calife.helpdesk.domain.enums.Status;
import com.calife.helpdesk.repositories.ChamadoRepository;
import com.calife.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {
	@Autowired
	private ChamadoRepository repository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não enocontrado ID: " + id));
	}
	
	public List<Chamado> findAll() {
		return repository.findAll();
	}
	
	public Chamado create(ChamadoDTO objDTO) {
		return repository.save(newChamado(objDTO));
	}

	private Chamado newChamado(ChamadoDTO objDTO) {
		Tecnico tecnico = tecnicoService.findById(objDTO.getTecnico());
		Cliente cliente = clienteService.findById(objDTO.getCliente());
		
		Chamado chamado = new Chamado();
		if(objDTO.getId() != null) {
			chamado.setId(objDTO.getId());
		}
		
		chamado.setTecnico(tecnico);
		chamado.setCliente(cliente);
		chamado.setPrioridade(Prioridade.toEnaum(objDTO.getPrioridade()));
		chamado.setStatus(Status.toEnaum(objDTO.getStatus()));
		chamado.setTitulo(objDTO.getTitulo());
		chamado.setObservacoes(objDTO.getObservacoes());
		
		return chamado;
	}
}
