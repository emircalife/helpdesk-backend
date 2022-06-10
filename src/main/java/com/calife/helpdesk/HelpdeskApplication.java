package com.calife.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.calife.helpdesk.domain.Chamado;
import com.calife.helpdesk.domain.Cliente;
import com.calife.helpdesk.domain.Tecnico;
import com.calife.helpdesk.domain.enums.Perfil;
import com.calife.helpdesk.domain.enums.Prioridade;
import com.calife.helpdesk.domain.enums.Status;
import com.calife.helpdesk.repositories.ChamadoRepository;
import com.calife.helpdesk.repositories.ClienteRepository;
import com.calife.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner{
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Tecnico tec1 = new Tecnico(null, "Emir Calife", "02159070432", "emircalife@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "16805083001", "torvalds@mail.com", "123");
		
		Chamado ch1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(ch1));
		*/
	}
}
