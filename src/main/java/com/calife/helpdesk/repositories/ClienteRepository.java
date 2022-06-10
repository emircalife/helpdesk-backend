package com.calife.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calife.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
